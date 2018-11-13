package com.baizhi.controller;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    @RequestMapping("regist")
    public String regist(Admin admin,String code,HttpServletRequest request){
        String code1= (String) request.getSession().getAttribute("code");
            if(code1.equals(code)){
                adminService.add(admin);
                return "redirect:/login.jsp";
            }else {
                return "redirect:/regist.jsp";
            }
    }

    @RequestMapping("login")
    public String login(Admin admin, HttpServletRequest request){
        Admin find = adminService.find(admin);
        if(find==null){
            return "redirect:/login.jsp";
        }else{
            request.getSession().setAttribute("loginAdmin",find);
            return "redirect:/employee/findAll";
        }
    }
}
