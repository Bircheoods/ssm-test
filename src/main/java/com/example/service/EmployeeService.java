package com.example.service;

import com.example.bean.Employee;
import com.example.dao.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description
 * @user summerHouAnNing
 * @creatTime 2021/7/7--3:13
 */
@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    public List<Employee> getAll() {
       return employeeMapper.selectByExampleWithDept(null);
    }
}
