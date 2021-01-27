package com.spjdbc.janspjdbc.dao;

import com.spjdbc.janspjdbc.model.Employee;
import com.spjdbc.janspjdbc.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.List;
import java.util.Map;

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

    @Override
    public String insertEmployee(Employee employee) {
        String sql="insert into employee values(?,?,?)";
        jdbcTemplate.update(sql,new Object[]{employee.getId()
                ,employee.getName(),employee.getCity()});
        return "Employee added successfully";
    }

    @Override
    public Employee getEmployee(Integer id) {
        String sql="select * from employee where id=?";
        Employee emp= (Employee) jdbcTemplate.queryForObject(sql,
                new Object[]{id},new int[]{Types.INTEGER},
                new BeanPropertyRowMapper(Employee.class));
        return emp;
    }

    @Override
    public String updateEmployee(Employee employee) {
        String sql="update employee set city=? where id=?";
        jdbcTemplate.update(sql,new Object[]{employee.getCity(),employee.getId()});
        return "Employee updated";
    }

    @Override
    public List<Map<String, Object>> getJoinData() {
        String sql="select a.id,a.name,a.city,b.name as deptName from " +
                "employee a,department b where a.dept_id=b.id";
        List<Map<String,Object>> list=jdbcTemplate.queryForList(sql);
        return list;
    }
}
