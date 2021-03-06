package com.example.test;

import com.example.bean.Employee;
import com.github.pagehelper.PageInfo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

/**
 * @description
 * @user summerHouAnNing
 * @creatTime 2021/7/7--3:39
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:spring.xml","file:src/main/webapp/WEB-INF/dispatcherServlet-servlet.xml"})
public class MvcTest {
    //传入springMvc的IOC容器
    @Autowired
    WebApplicationContext context;

    //虚拟的mvc请求，获取到处理结果
    MockMvc mockMvc;

    @Before
    public void initMockMvc(){
         mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testPage() throws Exception {
        MvcResult pageNo = mockMvc.perform(MockMvcRequestBuilders.get("/emps").param("pageNo", "5")).andReturn();

        MockHttpServletRequest request = pageNo.getRequest();
        PageInfo pageInfo = (PageInfo) request.getAttribute("pageInfo");

        System.out.println("当前页码："+pageInfo.getPageNum());
        System.out.println("总页码："+pageInfo.getPages());
        System.out.println("总记录数："+pageInfo.getTotal());
        System.out.println("在页面要显示的页码======================");
        int[] navigatepageNums = pageInfo.getNavigatepageNums();
        for (int i = 0; i < navigatepageNums.length; i++) {
            System.out.println("第"+ navigatepageNums[i] + "页");
        }
        System.out.println("拿到的员工信息是============================");
        List<Employee> list = pageInfo.getList();
        for (Employee employee : list) {
            System.out.println("employee = " + employee);
        }
    }

}
