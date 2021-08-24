package com.nagarro.employemanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.employemanagement.model.Employee;

/**
 * interface for the JPArepository
 * used for provide all functions for the CRUD operation in database
 * @author akshatBhawsar
 *
 */
public interface EmployeeRepo  extends JpaRepository<Employee,Integer> {

}
