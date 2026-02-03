package com.example.demows1nov;



import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        Employee existing = getEmployeeById(id);

        existing.setName(employee.getName());
        existing.setSalary(employee.getSalary());
        existing.setDob(employee.getDob());

        return employeeRepository.save(existing);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public String sendBirthdayWish(Long id) {
        Employee employee = getEmployeeById(id);

        LocalDate today = LocalDate.now();

        if (employee.getDob().getMonth() == today.getMonth()
                && employee.getDob().getDayOfMonth() == today.getDayOfMonth()) {
            return "🎉 Happy Birthday " + employee.getName() + "! 🎂";
        } else {
            return "Today is not " + employee.getName() + "'s birthday.";
        }
    }
}
