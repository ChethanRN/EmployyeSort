package com.example.EmployeeSort;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@RestController
public class EmployeeController {

    private List<Employee> employees = new ArrayList<>();

    // initialize the list of employees
    public EmployeeController() {
        employees.add(new Employee(1, "John", 35, "Sales"));
        employees.add(new Employee(2, "Bob", 28, "IT"));
        employees.add(new Employee(3, "Alice", 42, "HR"));
    }

    @GetMapping("/employees/sort/{method}")
    public List<Employee> sortEmployees(@PathVariable String method) {
        switch (method) {
            case "name":
                employees.sort(Comparator.comparing(Employee::getName));
                break;
            case "age":
                employees.sort(Comparator.comparingInt(Employee::getAge));
                break;
            case "department":
                employees.sort(Comparator.comparing(Employee::getDepartment));
                break;
            default:
                throw new IllegalArgumentException("Invalid sort method: " + method);
        }
        return employees;
    }
}
