package com.nagarro.employemanagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nagarro.employemanagement.dao.EmployeeRepo;
import com.nagarro.employemanagement.model.Employee;
/**
 * Service class for the API
 * @author akshatBhawsar
 *
 */
@Component
public class EmployeeServices {

	@Autowired
	EmployeeRepo repo;
/**
 * used for add emp in database
 * @param emp
 * @return Emp object
 */
	public Employee addEmployee(Employee emp) {

		try {

			repo.save(emp);

		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return emp;

	}
/**
 * used for editing pf employee
 * @param id
 * @param newemp
 * @return emp object
 */
	public Employee editEmployee(int id, Employee newemp) {
		try {

			
			System.out.println(newemp.getEmployeeCode());
			Employee emp = repo.findById(id).orElse(null);
			emp.setBirthDate(newemp.getBirthDate());
			emp.setEmail(newemp.getEmail());
			emp.setLocation(newemp.getLocation());
			emp.setName(newemp.getName());
			repo.save(emp);

		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return newemp;
	}

	public String deleteEmployee(int id) {
		try {

			repo.deleteById(id);

		}

		catch (Exception e) {
			e.printStackTrace();

		}
		return "Deleted";
	}
/**
 * used to retrive all object
 * @return list of Employee object in database
 */
	public List<Employee> getEmployees() {
		try {
			return repo.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * used to get the emp by its id
	 * @param id
	 * @return emp object
	 */
	public Employee getEmployee(int id)
	{
		return repo.findById(id).orElse(null);
	}

}
