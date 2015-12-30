package com.company;

import org.postgresql.util.PSQLException;

import java.io.IOException;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Main {

    private static Map cmdList = null;
    static Scanner sc;

    public static void main(String[] args) throws IOException, InterruptedException, SQLException {

        sc = new Scanner(System.in);
        String conCmd = "";

        initCommand();
        startPage();

        System.out.println("Welcome in MsS DB");

        while(true){
            System.out.println("cmd: help");
            conCmd = sc.nextLine();
            Command c = (Command) cmdList.get(conCmd);

            if(c != null) {
                c.execute(); continue;
            }
            nothing();
        }
    }

    private static void nothing() {
        System.out.println("error: no found command");
    }

    private static void initCommand(){
        cmdList = new HashMap< String, Command>();
        cmdList.put("list", new listTables());
        cmdList.put("login",new login());
        cmdList.put("use",new use());
        cmdList.put("show",new show());

        cmdList.put("quit", new quit());
        cmdList.put("help", new help());
    }

    public static void startPage() {
        String str =
                " __  __        _____ _                 _        _____  ____  \n" +
                        " |  \\/  |      / ____(_)               | |      |  __ \\|  _ \\ \n" +
                        " | \\  / |_   _| (___  _ _ __ ___  _ __ | | ___  | |  | | |_) |\n" +
                        " | |\\/| | | | |\\___ \\| | '_ ` _ \\| '_ \\| |/ _ \\ | |  | |  _ < \n" +
                        " | |  | | |_| |____) | | | | | | | |_) | |  __/ | |__| | |_) |\n" +
                        " |_|  |_|\\__, |_____/|_|_| |_| |_| .__/|_|\\___| |_____/|____/ \n" +
                        "          __/ |                  | |                          \n" +
                        "         |___/                   |_|           ";

        System.out.println(str);
        System.out.println();
    }
}

interface Command{
    void execute() throws SQLException;
}

class listTables implements Command {
    private MyConnect base = null;

    public void execute() {
        base = base.instance();
        try {

            if (base.getConn() == null) { new login().execute(); }

            DatabaseMetaData md = base.getConn().getMetaData();
            String table[]={"TABLE"};
            ResultSet rs= null;
            StringBuilder result = new StringBuilder();

            rs = md.getTables(null,null,null,table);

            result.append("[");
            while (rs.next()) {
                result = result.append(rs.getString(3)).append(",").append(" ");
            }
            String result1 = result.substring(0,result.length() - 2) + "]";

            System.out.println(result1);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

class login implements Command {
    private MyConnect base = null;

    public void execute() throws PSQLException {
        base = base.instance();

        while (base.connect()){
            Scanner sc = new Scanner(System.in);

            System.out.print("enter login: ");
            String userName  = sc.nextLine();

            System.out.print("enter password: ");
            String userPass = sc.nextLine();

            base.setUserCur(new MyUser(userName, userPass));
        }
    }
}

class use implements Command {
    public void execute(){
        System.out.print("cmd: quit\n ");
    }
}

class show implements Command {
    private MyConnect base = null;
    public void execute(){
        System.out.print("cmd: show\n ");
    }
}

class quit implements Command {
    private MyConnect base = null;
    public void execute(){
        System.out.print("cmd: quit\n ");
        base = base.instance();
        base.close();
    }
}

class help implements Command {
    public void execute(){
        System.out.println("\n"+
                "-list          :show all tables\n"+
                "-login         \n"+
                "\n" +
                "-quit  : disconnect and quit program\n"
        );
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
