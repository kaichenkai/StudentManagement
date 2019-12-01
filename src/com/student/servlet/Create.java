package com.student.servlet;

import com.student.dao.StudentDao;
import com.student.entity.Student;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/create")
public class Create extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取参数, 设置流的编码
        request.setCharacterEncoding("utf-8");
        // 将参数封装到 map 集合中 (使用JavaBeanUtils工具)
        Map<String, String[]> map = request.getParameterMap();
        Student student = new Student();
        try {
            BeanUtils.populate(student, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        // 获取 JdbcTemplate 对象, 将学生信息写入到数据库中
        int num = StudentDao.createStudent(student);
        System.out.println("新增成功, num: " + num);
        // 重定向到 list 页面
        response.sendRedirect(request.getContextPath() + "/list");
    }
}
