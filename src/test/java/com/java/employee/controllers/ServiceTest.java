package com.java.employee.controllers;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.java.employees.dao.EmployeeRepository;
import com.java.employees.model.Employee;
import com.java.employees.services.EmployeeService;

@ExtendWith(MockitoExtension.class)
public class ServiceTest {
	@InjectMocks
	EmployeeService employeeService;
	
	@Mock
	EmployeeRepository repository;
	
	public void init() {
		MockitoAnnotations.openMocks(this);
	}
    @Test
	public void testFindEmp() {
	List<Employee> list= new ArrayList<Employee>();
	list.add(new Employee("admin","manager"));
	list.add(new Employee("john","doe"));
	when(repository.findAll()).thenReturn(list);
	
	List<Employee> empList= employeeService.findAll();
	assertEquals(2, list.size());
	Mockito.verify(repository,Mockito.times(1)).findAll();
	}
	@Test
	public void testSave() {
		Employee emp= new Employee("admin", "manager");
		employeeService.save(emp);
		Mockito.verify(employeeService,Mockito.times(1)).save(emp);
	}
}
