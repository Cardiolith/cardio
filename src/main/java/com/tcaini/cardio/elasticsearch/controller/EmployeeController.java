package com.tcaini.cardio.elasticsearch.controller;

import com.tcaini.cardio.elasticsearch.EmployeeService;
import com.tcaini.cardio.elasticsearch.entity.Employee;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/es/employee")
public class EmployeeController {

    @Resource
    EmployeeService employeeService;

    @PostMapping("/save")
    public void save(@RequestBody Employee employee){
        employeeService.save(employee);
    }

    @PostMapping("/update")
    public void update(@RequestBody Employee employee){
        employeeService.update(employee);
    }

    @PostMapping("/delete")
    public void deleteById(Long id){
        employeeService.deleteById(id);
    }

    @GetMapping("/findbyid/id")
    public Employee findById(@RequestParam("id") Long id){
        return employeeService.findById(id).get();
    }

    @GetMapping("/findall")
    public List<Employee> findAll(){
        return (List)employeeService.findAll();
    }
}
