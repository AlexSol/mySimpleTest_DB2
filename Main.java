package com.company;

import java.io.IOException;
import java.sql.*;


public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        MyMenu menu = new MyMenu();
        menu.run();
    }

}

/*
class JDBCExample {

    public static void main(String[] argv) throws SQLException {

        System.out.println("-------- PostgreSQL "
                + "JDBC Connection Testing ------------");

       try {

            Class.forName("org.postgresql.Driver");

        } catch (ClassNotFoundException e) {

            System.out.println("Where is your PostgreSQL JDBC Driver? "
                    + "Include in your library path!");
            e.printStackTrace();
            return;

        }

        System.out.println("PostgreSQL JDBC Driver Registered!");

        String URL = "jdbc:postgresql://127.0.0.1:5432/testB";
        String USER = "postgres";
        String PASS = "1111";

        Connection conn = null;

        try {
            conn = DriverManager.getConnection(URL, USER, PASS);

        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;

        }
        if (conn != null) {
            System.out.println("You made it, take control your database now!");


            DatabaseMetaData md = conn.getMetaData();
            String table[]={"TABLE"};
            ResultSet rs= md.getTables(null,null,null,table);
            while (rs.next()) {
                System.out.println(rs.getString(3));
            }

            Statement stmt = null;
            try {
                stmt = conn.createStatement();

                *//*String sql_Create = "CREATE TABLE REGISTRATION_2 " +
                    "(id INTEGER not NULL, " +
                    " first VARCHAR(255), " +
                    " last VARCHAR(255), " +
                    " age INTEGER, " +
                    " PRIMARY KEY ( id ))";

                stmt.execute(sql_Create);
                *//*

*//*                String sql = "SELECT tablename  FROM pg_tables WHERE schemaname = 'public';"
                ResultSet rs = stmt.executeQuery(sql);



                while(rs.next()){
                    //Retrieve by column name
                    String first = rs.getString("tablename");

                    //Display values
                    System.out.println("tablename: " + first);
                }

                //System.out.print(stmt);*//*


            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
    public String[] getTableAll(){
        String[] res = null;

        return res;
    }

}*/
