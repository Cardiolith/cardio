package com.tcaini.cardio.elasticsearch.repository.impl;

import com.tcaini.cardio.elasticsearch.EmployeeService;
import com.tcaini.cardio.elasticsearch.entity.Employee;
import com.tcaini.cardio.elasticsearch.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    @Resource
    private EmployeeRepository employeeRepository;

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public boolean deleteById(Long id) {
        employeeRepository.deleteById(id);
        return true;
    }

    @Override
    public void update(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Iterable<Employee> findAll() {
        return employeeRepository.findAll();
    }
}
