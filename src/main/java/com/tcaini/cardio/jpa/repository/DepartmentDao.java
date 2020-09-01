package com.tcaini.cardio.jpa.repository;

import com.tcaini.cardio.jpa.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentDao extends JpaRepository<Department, Long> {

    /**
     * 根据层级查询部门
     * @param levels
     * @return
     */
    List<Department> findDepartmentsByLevels(Integer levels);
}
