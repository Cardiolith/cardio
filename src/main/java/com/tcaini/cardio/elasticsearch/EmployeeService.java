package com.tcaini.cardio.elasticsearch;

import com.tcaini.cardio.elasticsearch.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    void save(Employee employee);

    boolean deleteById(Long id);

    void update(Employee employee);

    Optional<Employee> findById(Long id);

    Iterable<Employee> findAll();
}
