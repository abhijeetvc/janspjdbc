package com.spjdbc.janspjdbc.repository;

import com.spjdbc.janspjdbc.model.Employee;

import java.util.List;

public interface EmployeeRepository {
    List<Employee> getEmployeeList();
}
