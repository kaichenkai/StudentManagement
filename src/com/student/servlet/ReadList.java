package com.student.servlet;

import com.student.utils.JDBCDruidUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/list")
public class ReadList extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 不用获取参数, 所以不用设置流的编码
            // 获取 JdbcTemplate 对象
        DataSource ds  = JDBCDruidUtils.getDataSource();
        JdbcTemplate template = new JdbcTemplate(ds);

        // 查询结果, 将结果集封装为 ReadList 集合
//        String querySql = "select * from student limit 0, 3";
        String querySql = "select * from student";
        List<Map<String, Object>> studentList = template.queryForList(querySql);
        // 将学生对象列表存储到 request 对象域中
        request.setAttribute("studentList", studentList);

        // 转发到 list 页面
        request.getRequestDispatcher("/list.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
