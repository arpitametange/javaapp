package com.example.demo.controller;

import com.example.demo.service.VectorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class vectorController { // Capitalized class name for consistency

    private final VectorService vectorService;

    public vectorController(VectorService vectorService) {
        this.vectorService = vectorService;
    }

    @PostMapping("/split-excel") // POST for file operations
    public ResponseEntity<String> splitExcel(@RequestParam String filePath, @RequestParam String outputFolder) {
        try {
            vectorService.splitExcelFile(filePath, outputFolder);
            return ResponseEntity.ok("Excel file split successfully!");
        } catch (Exception e) {
            // Log the error (consider using a logger)
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error: " + e.getMessage());
        }
    }
}
