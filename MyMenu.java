package com.company;

import java.util.Scanner;
import java.util.regex.MatchResult;

/**
 * Created by Plishchenko1 on 29.12.2015.
 */
public class MyMenu {

    Scanner sc;

    public void run(){

        startPage();

        sc = new Scanner(System.in);
        String cmd = "";

        while(!cmd.equals("quit") || !cmd.equals("exit")){

            System.out.println("0. help");
            if(cmd.equals("0")){
                help();
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
        System.out.println(
                "-list   :show all tables\n "+
                        "");
    }

    public void login(){
        System.out.print("enter login: ");
        //String userLogin = sc.nextLine();

        sc.findInLine("(\\D)");
        try {
            MatchResult result = sc.match();
            String userLogin = result.group(0);



        }catch (IllegalStateException ex){
            System.out.println("invalid login");
        }

        System.out.print("enter password: ");
        String userPass = sc.nextLine();
    }
}
