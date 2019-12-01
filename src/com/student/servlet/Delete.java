package com.student.servlet;

import com.student.dao.StudentDao;
import com.student.entity.Student;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/delete")
public class Delete extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取student的 id
        String id = request.getParameter("id");
        int num = StudentDao.deleteStudentById(id);
        System.out.println("删除学生信息, num: " + num);
        // 重定向到 list 页面
        response.sendRedirect(request.getContextPath() + "/list");
    }
}
