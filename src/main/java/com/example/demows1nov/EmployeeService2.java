package com.example.demows1nov;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class EmployeeService2 implements EmployeeService {

	@Override
	public void someservice() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Employee getEmployeeById(int id) {
		
		System.out.println("Service 2 is called");
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getEmployeeByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee saveEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return null;
	}

}
