package com.nagarro.employemanagement.services;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nagarro.employemanagement.dao.EmployeeRepo;
import com.nagarro.employemanagement.model.Employee;

@Component
public class FileDownlodeService {
	@Autowired
	EmployeeRepo repo;

	public void load(PrintWriter writer) {
		List<Employee> emps = (List<Employee>) repo.findAll();

		EmployeesToCSV(emps, writer);

	}

	public void EmployeesToCSV(List<Employee> employees, PrintWriter writer) {

		try (CSVPrinter csvp = new CSVPrinter(writer,
				CSVFormat.DEFAULT.withHeader("ID", "NAME", "LOC", "EMAIL", "DOB"));) {
			for (Employee emp : employees) {
				List<String> data = Arrays.asList(

						String.valueOf(emp.getEmployeeCode()), emp.getBirthDate(), emp.getEmail(), emp.getLocation(),
						emp.getName());
				csvp.printRecord(data);
			}

			csvp.flush();

		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}
}
