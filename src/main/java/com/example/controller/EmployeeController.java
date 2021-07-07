package com.example.controller;

import com.example.bean.Employee;
import com.example.service.EmployeeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @description 处理员工的增删改查
 * @user summerHouAnNing
 * @creatTime 2021/7/7--3:08
 */

@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/emps")
    public String getEmps(@RequestParam(value = "pageNo",defaultValue = "1")Integer pageNo, Model model){

        //在查询之前开启分页
        PageHelper.startPage(pageNo,20);
        //此时startPage方法后面紧跟的查询就是一个分页查询
        List<Employee> all = employeeService.getAll();

        //用pageInfo对结果进行包装,
        PageInfo page = new PageInfo(all,5);

        model.addAttribute("pageInfo",page);
        return "list";
    }
}
