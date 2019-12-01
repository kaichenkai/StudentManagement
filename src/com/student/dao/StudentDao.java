package com.student.dao;

import com.student.entity.Student;
import com.student.utils.JDBCDruidUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * student 对象相关的操作方法
 */
public class StudentDao {
    // 获取 JdbcTemplate 对象
    private static JdbcTemplate template = new JdbcTemplate(JDBCDruidUtils.getDataSource());

    /**
     * 获取 JdbcTemplate 对象, 将学生信息写入到数据库中
     */
    public static int createStudent(Student student){
        String createSql = "insert into student values(?,?,?,?,?,?,?,?);";
        int num = StudentDao.template.update(createSql, student.getId(), student.getStudentId(), student.getName(),
                student.getGender(), student.getBirthday(), student.getAddress(), student.getQq(), student.getEmail());
        return num;
    }

    /**
     * 通过id查询学生
     * @param id
     * @return
     */
    public static Student queryStudentById(String id){
        String querySql = "select * from student where id = ?";
        Student student = StudentDao.template.queryForObject(querySql, new BeanPropertyRowMapper<Student>(Student.class), id);
        return student;
    }


    /**
     * 更新 学生信息
     * @param student
     * @return
     */
    public static int updateStudent(Student student){
        String updateSql = "update student set gender = ?, birthday = ?, address = ?," +
                           "qq = ?, email = ? where id = ?;";
        int num = StudentDao.template.update(updateSql, student.getGender(), student.getBirthday(), student.getAddress(),
                student.getQq(), student.getEmail(), student.getId());
        return num;
    }

    /**
     * 删除学生信息
     * @param id
     * @return
     */
    public static int deleteStudentById(String id){
        String deleteSql = "delete from student where id = ?";
        int num = StudentDao.template.update(deleteSql, id);
        return num;
    }
}
