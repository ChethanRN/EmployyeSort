package com.example.EmployeeSort;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EmployeeControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testSortByName() {
        ResponseEntity<List<Employee>> response = restTemplate.exchange(
                "/employees/sort/name",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Employee>>() {});
        List<Employee> employees = response.getBody();
        assertEquals("Alice", employees.get(0).getName());
        assertEquals("Bob", employees.get(1).getName());
        assertEquals("John", employees.get(2).getName());
    }

    @Test
    void testSortByAge() {
        ResponseEntity<List<Employee>> response = restTemplate.exchange(
                "/employees/sort/age",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Employee>>() {});
        List<Employee> employees = response.getBody();
        assertEquals(28, employees.get(0).getAge());
        assertEquals(35, employees.get(1).getAge());
        assertEquals(42, employees.get(2).getAge());
    }

    @Test
    void testSortByDepartment() {
        ResponseEntity<List<Employee>> response = restTemplate.exchange(
                "/employees/sort/department",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Employee>>() {});
        List<Employee> employees = response.getBody();
        assertEquals("HR", employees.get(0).getDepartment());
        assertEquals("IT", employees.get(1).getDepartment());
        assertEquals("Sales", employees.get(2).getDepartment());
    }
}