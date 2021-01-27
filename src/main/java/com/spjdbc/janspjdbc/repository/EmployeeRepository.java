package com.spjdbc.janspjdbc.repository;

import com.spjdbc.janspjdbc.model.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeRepository {
    List<Employee> getEmployeeList();

    String insertEmployee(Employee employee);

    Employee getEmployee(Integer id);

    String updateEmployee(Employee employee);

    List<Map<String,Object>> getJoinData();
}
