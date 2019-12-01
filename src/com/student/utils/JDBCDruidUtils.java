package com.student.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * JDBCDruidUtils 工具类
 */
public class JDBCDruidUtils {
    private static DataSource ds = null;

    static {
        try {
            // 加载配置文件
            Properties pro = new Properties();
            // 获取 src 路径下的文件 --> ClassLoader
            ClassLoader cl = JDBCDruidUtils.class.getClassLoader();
            InputStream is = cl.getResourceAsStream("druid.properties");
            pro.load(is);
            // 通过工厂函数 获取 数据库连接池 (传入配置文件)
            ds = DruidDataSourceFactory.createDataSource(pro);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 获取连接池对象
    public static DataSource getDataSource(){
        return ds;
    }

    // 获取连接对象
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    // 资源回收
    public static void close(ResultSet ret, PreparedStatement pstat, Connection conn){
        if (ret != null) {
            try {
                ret.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (pstat != null) {
            try {
                ret.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                ret.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
