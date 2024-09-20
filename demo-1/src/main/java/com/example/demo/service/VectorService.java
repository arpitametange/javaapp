package com.example.demo.service;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.model.SharedStringsTable;
import org.springframework.stereotype.Service;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings("deprecation")
@Service
public class VectorService {

    public void splitExcelFile(String filePath, String outputFolder) {
        int rowsPerFile = 100000; // Split into files with 100,000 rows

        Path outputPath = Paths.get(outputFolder);
        try {
            if (!Files.exists(outputPath)) {
                Files.createDirectories(outputPath);
            }
        } catch (IOException e) {
            System.err.println("Failed to create output directory");
            e.printStackTrace();
            return;
        }

        try (OPCPackage opcPackage = OPCPackage.open(new File(filePath))) {
            XSSFReader reader = new XSSFReader(opcPackage);
            SharedStringsTable sharedStrings = (SharedStringsTable) reader.getSharedStringsTable();
            XMLReader parser = XMLReaderFactory.createXMLReader();

            // Create a handler for processing rows
            RowHandler rowHandler = new RowHandler(sharedStrings, outputFolder, rowsPerFile);
            parser.setContentHandler(rowHandler);

            // Process each sheet
            XSSFReader.SheetIterator sheets = (XSSFReader.SheetIterator) reader.getSheetsData();
            while (sheets.hasNext()) {
                try (InputStream sheet = sheets.next()) {
                    InputSource sheetSource = new InputSource(sheet);
                    parser.parse(sheetSource);
                }
            }

            System.out.println("Splitting completed.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class RowHandler extends DefaultHandler {
    private List<String[]> chunk = new ArrayList<>();
    private List<String> rowData = new ArrayList<>();
    private int fileIndex = 1;
    private int rowCount = 0;
    private int rowsPerFile;
    private String outputFolder;
    private boolean isCellValue;
    private RichTextString cellValue;
    private SharedStringsTable sharedStrings;

    public RowHandler(SharedStringsTable sharedStrings, String outputFolder, int rowsPerFile) {
        this.sharedStrings = sharedStrings;
        this.outputFolder = outputFolder;
        this.rowsPerFile = rowsPerFile;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("row")) {
            rowData = new ArrayList<>(); // Start new row
        } else if (qName.equals("c")) {
            isCellValue = true; // Start reading cell value
            cellValue = ""; // Reset cell value
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("v")) {
            if (isCellValue) {
                cellValue = cellValue.trim();
                // Handle shared string index
                if (cellValue.matches("\\d+")) {
                    int idx = Integer.parseInt(cellValue);
                    cellValue = sharedStrings.getItemAt(idx);
                }
                rowData.add(cellValue);
                isCellValue = false;
            }
        } else if (qName.equals("row")) {
            chunk.add(rowData.toArray(new String[0]));
            rowCount++;

            // Save chunk if it reaches the limit
            if (rowCount >= rowsPerFile) {
                saveChunkToCSV(chunk, outputFolder, fileIndex);
                chunk.clear();
                rowCount = 0;
                fileIndex++;
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isCellValue) {
            cellValue += new String(ch, start, length).trim(); // Append cell value
        }
    }

    private void saveChunkToCSV(List<String[]> chunk, String outputFolder, int fileIndex) {
        String outputFile = outputFolder + "/split_file_" + fileIndex + ".csv";
        try (PrintWriter writer = new PrintWriter(new FileWriter(outputFile))) {
            // Write header (if needed)
            writer.println("First_Name,Last_Name,Email_Address,Company_Name,Company_Domain,Job_Title");
            
            for (String[] rowData : chunk) {
                // Join values with commas and wrap in quotes if they contain commas or newlines
                String line = Arrays.stream(rowData)
                    .map(value -> value.contains(",") || value.contains("\n") ? "\"" + value + "\"" : value)
                    .collect(Collectors.joining(","));
                writer.println(line);
            }
            System.out.println("Saved " + outputFile + " with " + chunk.size() + " rows");
        } catch (IOException e) {
            System.err.println("Failed to write file: " + outputFile);
            e.printStackTrace();
        }
    }
}

