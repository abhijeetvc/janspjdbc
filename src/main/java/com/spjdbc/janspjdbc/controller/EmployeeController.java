package com.spjdbc.janspjdbc.controller;

import com.spjdbc.janspjdbc.dao.EmployeeDao;
import com.spjdbc.janspjdbc.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

//http methods: get, post, put, delete

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @GetMapping("/getemployees")
    public List<Employee> getEmployeeData(){
        return employeeDao.getEmployeeList();
    }

    @PostMapping("/save")
    public String saveEmployee(@RequestBody Employee employee){
        return employeeDao.insertEmployee(employee);
    }

    @GetMapping("/getemp/{id}")
    public Employee getEmpData(@PathVariable Integer id){
        return employeeDao.getEmployee(id);
    }

    @PutMapping("/updateEmp")
    public String updateEmp(@RequestBody Employee emp){
        return employeeDao.updateEmployee(emp);
    }

    @GetMapping("/joindata")
    public List<Map<String,Object>> getJoinData(){
        return employeeDao.getJoinData();
    }
}
