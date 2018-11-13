package com.baizhi.service;

import com.baizhi.entity.Employee;

import java.util.List;

public interface EmployeeService {
    void saveEm(Employee employee);

    List<Employee> findEmployees();

    void deleteEmployee(String id);

    void updateEmployee(Employee employee);

    Employee findOneEmployee(String id);
}
