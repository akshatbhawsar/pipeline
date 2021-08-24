package com.nagarro.employemanagement.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.employemanagement.model.Employee;
import com.nagarro.employemanagement.services.EmployeeServices;
import com.nagarro.employemanagement.services.FileDownlodeService;
/**
 * Controller class for the Api
 * @author akshatBhawsar
 *
 */
@RestController
public class EmployeeController {
	@Autowired
	EmployeeServices eService;
	@Autowired
	FileDownlodeService csvService;

	@GetMapping("/emp")
	@ResponseBody

	public List<Employee> getAllEmployee() {

		return eService.getEmployees();

	}

	@DeleteMapping("/emp/{id}")
	public String deleteEmp(@PathVariable int id) {
		return eService.deleteEmployee(id);

	}

	@PutMapping("/emp/{id}")
	public Employee updateEmp(@PathVariable int id, @RequestBody Employee emp) {
		return eService.editEmployee(id, emp);
	}

	@PostMapping("/emp")
	public Employee addEmp(@RequestBody Employee emp) {
		return eService.addEmployee(emp);
	}

	@GetMapping("/emp/{id}")
	public Employee getemp(@PathVariable int id) {
		return eService.getEmployee(id);
	}

	@GetMapping("/emp/downlode")
	public void getFile(HttpServletResponse res) throws IOException {

		res.setContentType("text/csv");
		res.setHeader("Content-Display", "attachment; file= employees.csv");
		csvService.load(res.getWriter());

	}

}
