package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class Vector19 {
	public Vector19() {}
	 @Id
	    @Column(name = "id")
	    private Integer id;

	    public Vector19(Integer id, String firstName, String lastName, String emailAddress, String companyName,
			String companyDomain, String jobTitle, String jobFunction, String jobLevel, String companyAddress,
			String city, String state, String zipCode, String country, String telephoneNumber, String employeeSize,
			String industry, String revenue, String sic, String naic, String companyLink, String prospectLink,
			String emailValidation, String pid, String headquarterAddress, String headCity, String headState,
			String campaignId, String api, String region) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.companyName = companyName;
		this.companyDomain = companyDomain;
		this.jobTitle = jobTitle;
		this.jobFunction = jobFunction;
		this.jobLevel = jobLevel;
		this.companyAddress = companyAddress;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.country = country;
		this.telephoneNumber = telephoneNumber;
		this.employeeSize = employeeSize;
		this.industry = industry;
		this.revenue = revenue;
		this.sic = sic;
		this.naic = naic;
		this.companyLink = companyLink;
		this.prospectLink = prospectLink;
		this.emailValidation = emailValidation;
		this.pid = pid;
		this.headquarterAddress = headquarterAddress;
		this.headCity = headCity;
		this.headState = headState;
		this.campaignId = campaignId;
		this.api = api;
		this.region = region;
	}

		public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyDomain() {
		return companyDomain;
	}

	public void setCompanyDomain(String companyDomain) {
		this.companyDomain = companyDomain;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getJobFunction() {
		return jobFunction;
	}

	public void setJobFunction(String jobFunction) {
		this.jobFunction = jobFunction;
	}

	public String getJobLevel() {
		return jobLevel;
	}

	public void setJobLevel(String jobLevel) {
		this.jobLevel = jobLevel;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public String getEmployeeSize() {
		return employeeSize;
	}

	public void setEmployeeSize(String employeeSize) {
		this.employeeSize = employeeSize;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getRevenue() {
		return revenue;
	}

	public void setRevenue(String revenue) {
		this.revenue = revenue;
	}

	public String getSic() {
		return sic;
	}

	public void setSic(String sic) {
		this.sic = sic;
	}

	public String getNaic() {
		return naic;
	}

	public void setNaic(String naic) {
		this.naic = naic;
	}

	public String getCompanyLink() {
		return companyLink;
	}

	public void setCompanyLink(String companyLink) {
		this.companyLink = companyLink;
	}

	public String getProspectLink() {
		return prospectLink;
	}

	public void setProspectLink(String prospectLink) {
		this.prospectLink = prospectLink;
	}

	public String getEmailValidation() {
		return emailValidation;
	}

	public void setEmailValidation(String emailValidation) {
		this.emailValidation = emailValidation;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getHeadquarterAddress() {
		return headquarterAddress;
	}

	public void setHeadquarterAddress(String headquarterAddress) {
		this.headquarterAddress = headquarterAddress;
	}

	public String getHeadCity() {
		return headCity;
	}

	public void setHeadCity(String headCity) {
		this.headCity = headCity;
	}

	public String getHeadState() {
		return headState;
	}

	public void setHeadState(String headState) {
		this.headState = headState;
	}

	public String getCampaignId() {
		return campaignId;
	}

	public void setCampaignId(String campaignId) {
		this.campaignId = campaignId;
	}

	public String getApi() {
		return api;
	}

	public void setApi(String api) {
		this.api = api;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

		@Column(name = "first_name")
	    private String firstName;

	    @Column(name = "last_name")
	    private String lastName;

	    @Column(name = "email_address")
	    private String emailAddress;

	    @Column(name = "company_name")
	    private String companyName;

	    @Column(name = "company_domain")
	    private String companyDomain;

	    @Column(name = "job_title")
	    private String jobTitle;

	    @Column(name = "job_function")
	    private String jobFunction;

	    @Column(name = "job_level")
	    private String jobLevel;

	    @Column(name = "company_address")
	    private String companyAddress;

	    @Column(name = "city")
	    private String city;

	    @Column(name = "state")
	    private String state;

	    @Column(name = "zip_code")
	    private String zipCode;

	    @Column(name = "country")
	    private String country;

	    @Column(name = "telephone_number")
	    private String telephoneNumber;

	    @Column(name = "employee_size")
	    private String employeeSize;

	    @Column(name = "industry")
	    private String industry;

	    @Column(name = "revenue")
	    private String revenue;

	    @Column(name = "sic")
	    private String sic;

	    @Column(name = "naic")
	    private String naic;

	    @Column(name = "company_link")
	    private String companyLink;

	    @Column(name = "prospect_link")
	    private String prospectLink;

	    @Column(name = "email_validation")
	    private String emailValidation;

	    @Column(name = "pid")
	    private String pid;

	    @Column(name = "headquarter_address")
	    private String headquarterAddress;

	    @Column(name = "head_city")
	    private String headCity;

	    @Column(name = "head_state")
	    private String headState;

	    @Column(name = "campaign_id")
	    private String campaignId;

	    @Column(name = "api")
	    private String api;

	    @Column(name = "region")
	    private String region;

}
