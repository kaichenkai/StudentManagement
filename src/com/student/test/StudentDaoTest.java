package com.student.test;

import com.student.entity.Student;
import com.student.utils.JDBCDruidUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class StudentDaoTest {
    @Test
    public void test(){
    // 获取 JdbcTemplate 对象
    DataSource ds  = JDBCDruidUtils.getDataSource();

    JdbcTemplate template = new JdbcTemplate(ds);
//    JdbcTemplate template2 = new JdbcTemplate(ds);


    // 查询结果, 返回基本数据类型, 多用于 聚合函数
    String querySql = "select sum(balance) from user";
    Integer balanceTotal = template.queryForObject(querySql, Integer.class);
    System.out.println(balanceTotal);  // 125456


    // 查询结果, 将结果集封装为 JavaBean 对象 (放在java实例属性值)
    Map<String, String> map = new HashMap<>();
    map.put("id", "1");
    map.put("studentId", "1901");
    map.put("name", "johny");

    Student student = new Student();

//    try {
//        BeanUtils.populate(student, map);
//    } catch (IllegalAccessException e) {
//        e.printStackTrace();
//    } catch (InvocationTargetException e) {
//        e.printStackTrace();
//    }

        System.out.println(student);

    }

}
