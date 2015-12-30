package com.company;

import org.postgresql.util.PSQLException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnect {
    private MyConnect(){}
    static MyConnect base = null;

    public static MyConnect instance() {
        if (base == null) {
            base = new MyConnect();
        }
        return base;
    }

    public boolean connect(){
        String URL = "jdbc:postgresql://127.0.0.1:5432/testB";
        try {
            conn = DriverManager.getConnection(URL, userCur.getName(), userCur.getPass());
        } catch (PSQLException e) {
            System.out.println("Connection Failed! Check output console");
            return true;
        } catch (SQLException e) {
        }
        return false;
    }

    public void  close(){
        try {
            conn.close();
        }
        catch (SQLException e){
            System.out.println("error: connect.close()");
        }
    }

    public Connection getConn() {
        return conn;
    }

    public MyUser getName() {
        return userCur;
    }

    public static void setUserCur(MyUser userCur) {
        MyConnect.userCur = userCur;
    }

    private String name = "";
    private Connection conn = null;
    private static MyUser userCur = new MyUser();
}
