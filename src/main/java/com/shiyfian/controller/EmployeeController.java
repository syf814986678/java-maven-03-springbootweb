package com.shiyfian.controller;

import com.shiyfian.Dao.DepartmentDao;
import com.shiyfian.Dao.EmployeeDao;
import com.shiyfian.pojo.Department;
import com.shiyfian.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;
    @RequestMapping("/employees")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps",employees);
        return "employees/employees";
    }
    @GetMapping("/addemp")
    public String toaddempspages(Model model){
        //查出所有部门信息
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("department",departments);
        return "employees/add";
    }
    @PostMapping("/addemp")
    public String addemployees(Employee employee){
        employeeDao.addEmployee(employee);//保存员工信息
        System.out.println("save=>"+employee);
        //添加操作
        return "redirect:/employees";
    }
    @GetMapping("/updateemp/{id}")
    public String toupdatempspages(@PathVariable("id") int EID,Model model){
        Employee employee = employeeDao.getEmployeesByDID(EID);
        model.addAttribute("emp",employee);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("department",departments);
        return "employees/update";
    }
    @PostMapping("/updateemployees")
    public String updateemployees(Employee employee){
        employeeDao.addEmployee(employee);
        return "redirect:/employees";
    }
    @GetMapping("/deleteemp/{id}")
    public String deleteemployees(@PathVariable("id") int EID){
        employeeDao.delete(EID);
        return "redirect:/employees";
    }
}
