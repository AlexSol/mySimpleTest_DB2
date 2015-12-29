package com.company;

import java.util.Scanner;
import java.util.regex.MatchResult;

/**
 * Created by Plishchenko1 on 29.12.2015.
 */
public class MyMenu {

    Scanner sc;
    boolean isLogin = false;

    public void run(){

        startPage();

        sc = new Scanner(System.in);
        String cmd = "";

        while(!cmd.equals("quit") && !cmd.equals("exit")){

            System.out.println("0. help");

            if(cmd.equals("0")){
                help();
            }
            if(cmd.equals("list")){
                cmdList();
            }

            login();

            cmd = sc.nextLine();
        }
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

    public void help(){
        System.out.println("\n"+
                "-list          :show all tables\n "+
                "-quit || exit  : disconnect and quit program" +
                        "\n");
    }

    public void cmdList(){
        System.out.println("command List");
        sc.next();
    }

    public void login(){


        while (isLogin == false){
            System.out.print("enter login: ");
            sc.findInLine("(\\S)");

            try {
                MatchResult result = sc.match();
                String userLogin = result.group(0);

            }catch (IllegalStateException ex){
                System.out.println("invalid symbols");
                sc.nextLine();
                continue;
            }

            System.out.print("enter password: ");

            isLogin = true;

            break;
        }
    }
}
