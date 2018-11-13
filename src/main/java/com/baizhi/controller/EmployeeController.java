package com.baizhi.controller;

import com.baizhi.entity.Employee;
import com.baizhi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @RequestMapping("saveEm")
    public String saveEm(Employee employee){
        employeeService.saveEm(employee);
        return "redirect:/employee/findAll";
    }

    @RequestMapping("findAll")
    public String findAll(HttpServletRequest request){
        List<Employee> findEmployees = employeeService.findEmployees();
        request.setAttribute("list", findEmployees);
        return "emplist";
    }

    @RequestMapping("deleteEm")
    public String deleteEm(String id){
        employeeService.deleteEmployee(id);
        /*throw new RuntimeException("服务器崩溃");*/
        return "redirect:/employee/findAll";
    }

    @RequestMapping("updateEm")
    public String updateEm(Employee employee){
        employeeService.updateEmployee(employee);
        return "redirect:/employee/findAll";
    }

    @RequestMapping("findOne")
    public String findOne(HttpServletRequest request,String id){
        Employee findOneEmployee = employeeService.findOneEmployee(id);
        request.setAttribute("one", findOneEmployee);
        return "updateEmp";
    }
}
