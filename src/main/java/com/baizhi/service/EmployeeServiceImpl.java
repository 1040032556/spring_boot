package com.baizhi.service;

import com.baizhi.dao.EmployeeDao;
import com.baizhi.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    EmployeeDao employeeDao;
    @Override
    public void saveEm(Employee employee) {
        employee.setId(UUID.randomUUID().toString());
        employeeDao.saveEm(employee);
    }

    @Override
    public List<Employee> findEmployees() {
        return employeeDao.findEmployees();
    }

    @Override
    public void deleteEmployee(String id) {
        employeeDao.deleteEmployee(id);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeDao.updateEmployee(employee);
    }

    @Override
    public Employee findOneEmployee(String id) {
        return employeeDao.findOneEmployee(id);
    }
}
