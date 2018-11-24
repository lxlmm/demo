package com.lxl;

import java.sql.*;

public class Test {
    static final String DB_URL = "jdbc:mysql://localhost:3306/liaoxl_db";
    // MySQL的JDBC URL编写方式：jdbc:mysql://主机名称：连接端口/数据库的名称
    static final String USER = "root";
    static final String PASS = "123456";

    public static void main(String[] args) {

        Connection conn = null;
        Statement stat = null;
        try {
            // 注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 创建链接
            conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);

            // 执行查询
            stat = conn.createStatement();
            String sql = "SELECT now() FROM dual";
            ResultSet rs = stat.executeQuery(sql);
//            System.out.printf(rs.getString(1));
            while(rs.next()){
                String id = rs.getString("now()");

                System.out.printf(id);
            }
        } catch (Exception e) {

            System.out.printf(e.toString());
        } finally {
            try {
                if (stat != null) {
                    stat.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
