package com.example.test;

import com.example.bean.Department;
import com.example.bean.Employee;
import com.example.dao.DepartmentMapper;
import com.example.dao.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

/**
 * @description
 * @user summerHouAnNing
 * @creatTime 2021/7/7--2:05
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml"})
public class MapperTest {

    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    SqlSession sqlSession;

    @Test
    public void testInsert(){

        //1.插入部门
//       departmentMapper.insertSelective(new Department(null,"财务部"));
//       departmentMapper.insertSelective(new Department(null,"人事部"));

        //2.插入员工
        //employeeMapper.insertSelective(new Employee(null,"王五","b","wangwu@qq.com",3));

        //3.批量插入,使用可以执行批量操作的sqlSession
//        for (int i = 0; i < ; i++) {
//
//        }
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        for (int i = 0; i < 1000; i++) {
            String uuid = UUID.randomUUID().toString().substring(0, 5) + i;
            mapper.insertSelective(new Employee(null,uuid,"M",uuid+"@qq.com",1));

        }
        System.out.println("测试完成 ==========" );

    }

}
