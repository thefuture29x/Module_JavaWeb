package com.example.module_javaweb_test.connection;

import java.sql.DriverManager;
import java.sql.Statement;

public class Connection {
    private String driverName = "com.mysql.cj.jdbc.Driver";
    private String user = "root";
    private String pass = "";
    private String url = "jdbc:mysql://localhost:3306/module_javaweb";

    public java.sql.Connection getConnection(){
        java.sql.Connection conn = null;
        try {
            Class.forName(driverName).newInstance();
            conn = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    public Statement StatementConection(){
        try{
            Class.forName(driverName);
            java.sql.Connection con= DriverManager.getConnection(url,user,pass);
            Statement stmt= ((java.sql.Connection) con).createStatement();
            return stmt;
        }catch(Exception e){ System.out.println(e);}
        return null;
    }

    public static void main(String[] args) {
        new Connection().getConnection();
    }
}
