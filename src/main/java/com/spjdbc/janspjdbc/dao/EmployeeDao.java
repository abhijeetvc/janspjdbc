package com.spjdbc.janspjdbc.dao;

import com.spjdbc.janspjdbc.model.Employee;
import com.spjdbc.janspjdbc.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDao implements EmployeeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Employee> getEmployeeList() {
        String sql="select * from employee";
        List<Employee> list=jdbcTemplate
                .query(sql,new BeanPropertyRowMapper(Employee.class));
        return list;
    }
}
