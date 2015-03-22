package com.sg.socrates.domain.empdeatil;


public class EmployeeDetail {

	private String empId;
	private String dateOfJoining;
	private String emailId;
	private String firstName;
	private String lastName;
	private String departement;
	private String managerName;
	private String managerEmpid;
	private String managerEmailId;
	private String employeeAddress;
	private String city;
	private String empHrId;
	private String empHrName;
	public String getEmpId() {
		return empId;
	}
	public String getDateOfJoining() {
		return dateOfJoining;
	}
	public String getEmailId() {
		return emailId;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getDepartement() {
		return departement;
	}
	public String getManagerName() {
		return managerName;
	}
	public String getManagerEmpid() {
		return managerEmpid;
	}
	public String getManagerEmailId() {
		return managerEmailId;
	}
	public String getEmployeeAddress() {
		return employeeAddress;
	}
	public String getCity() {
		return city;
	}
	public String getEmpHrId() {
		return empHrId;
	}
	public String getEmpHrName() {
		return empHrName;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public void setDateOfJoining(String dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setDepartement(String departement) {
		this.departement = departement;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public void setManagerEmpid(String managerEmpid) {
		this.managerEmpid = managerEmpid;
	}
	public void setManagerEmailId(String managerEmailId) {
		this.managerEmailId = managerEmailId;
	}
	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setEmpHrId(String empHrId) {
		this.empHrId = empHrId;
	}
	public void setEmpHrName(String empHrName) {
		this.empHrName = empHrName;
	}
	@Override
	public String toString() {
		return "EmployeeDetail [empId=" + empId + ", dateOfJoining="
				+ dateOfJoining + ", emailId=" + emailId + ", firstName="
				+ firstName + ", lastName=" + lastName + ", departement="
				+ departement + ", managerName=" + managerName
				+ ", managerEmpid=" + managerEmpid + ", managerEmailId="
				+ managerEmailId + ", employeeAddress=" + employeeAddress
				+ ", city=" + city + ", empHrId=" + empHrId + ", empHrName="
				+ empHrName + "]";
	}
	
	

}