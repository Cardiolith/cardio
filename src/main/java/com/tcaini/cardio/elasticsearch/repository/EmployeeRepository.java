package com.tcaini.cardio.elasticsearch.repository;

import com.tcaini.cardio.elasticsearch.entity.Employee;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface EmployeeRepository extends ElasticsearchRepository<Employee, Long> {

}
