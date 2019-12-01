package com.student.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import com.student.dao.StudentDao;
import com.student.entity.Student;
import org.apache.commons.beanutils.BeanUtils;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/update")
public class Update extends HttpServlet {
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
        // 获取 JdbcTemplate 对象, 将学生信息更新到数据库中
        int num = StudentDao.updateStudent(student);
        System.out.println("更新成功, num: " + num);
        // 重定向到 list 页面
        response.sendRedirect(request.getContextPath() + "/list");
    }

    // 返回带有 student 信息的修改页面
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取student的 id
        String id = request.getParameter("id");
        Student student = StudentDao.queryStudentById(id);
        // 将需要修改的学生信息放到 request 域对象中
        request.setAttribute("student", student);
        // 请求转发到 update.jsp 页面
        request.getRequestDispatcher("/update.jsp").forward(request, response);
    }
}
