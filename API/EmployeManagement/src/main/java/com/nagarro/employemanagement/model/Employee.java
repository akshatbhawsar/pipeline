package com.nagarro.employemanagement.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;
/**
 * Model  class for the Employees
 * @author akshatBhawsar
 *
 */
@Entity
public class Employee {
	
	@Id
  private int employeeCode;
  private String name;
  private String location;
  private String email;
  
  private String  birthDate;
  
  
public Employee(int employeeCode, String name, String location, String email, String birthDate) {
	super();
	this.employeeCode = employeeCode;
	this.name = name;
	this.location = location;
	this.email = email;
	this.birthDate = birthDate;
}
public Employee() {
	super();
	// TODO Auto-generated constructor stub
}
public int getEmployeeCode() {
	return employeeCode;
}
public void setEmployeeCode(int employeeCode) {
	this.employeeCode = employeeCode;
}
@Override
public String toString() {
	return "Employee [employeeCode=" + employeeCode + ", name=" + name + ", location=" + location + ", email=" + email
			+ ", birthDate=" + birthDate.toString() + "]";
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public  String getBirthDate() {
	return birthDate;
}
public void setBirthDate(String birthDate) {
	this.birthDate = birthDate;
}
	

}
