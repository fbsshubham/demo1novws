package com.example.demows1nov;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.Resource;

@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = "*")
public class EmployeeController {

//	@Autowired
//	@Qualifier("#${employee.service.bean}")//ennviroment variable se aa sakti hai kya
	@Resource(name="${employee.service.bean}")
	EmployeeService es; //new EmployeeService1();
	
	@GetMapping("/getemployeebyid/{id}")
	public Employee getEmployeeById(@PathVariable int id)
	{
		
		return es.getEmployeeById(id);
	}
	
	@GetMapping("/getemployeebyname/{name}")
	public Employee getEmployeeByName(@PathVariable String name)
	{
		
		
		return es.getEmployeeByName(name);
	}
	
	@GetMapping("/saveemployee")
	public Employee saveEmployee()
	{
		Employee emp=new Employee(101, "emp1", 10000);
		
		return es.saveEmployee(emp);
	}
	
	
}
