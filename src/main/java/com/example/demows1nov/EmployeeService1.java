package com.example.demows1nov;

import org.springframework.stereotype.Service;


@Service
public class EmployeeService1 implements EmployeeService {

	@Override
	public void someservice() {
		// TODO Auto-generated method stub
		
	}

	public Employee getEmployeeById(int id) {
		
		System.out.println("Service 1 is called");
		
		//data base se employee id ke basis pe search karke lana aur idhar se rturn karna nahito null
		return new Employee(101, "soham", 70000);
	}

	public Employee getEmployeeByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
