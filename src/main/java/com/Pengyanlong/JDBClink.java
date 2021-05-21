package com.Pengyanlong;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBClink {
    public static void main(String[] args)
    {
        String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=test";  // studentmanager为数据库名，此处填写你的数据库名

        String userName="sa";   // 填写你的登录账户名名，我的是sa
        String userPwd="20011120";   // 填写你的密码

        try
        {
            Class.forName(driverName);
            @SuppressWarnings("unused")
            Connection dbConn= DriverManager.getConnection(dbURL,userName,userPwd);
            System.out.println("连接数据库成功");
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.print("连接失败");
        }
    }
}
