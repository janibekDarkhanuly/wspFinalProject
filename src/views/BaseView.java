package views;

import java.util.Scanner;
import java.util.Vector;

import Controller.UserConroller;
import models.UserType;
import models.User;

import static localization.Localization.ln;

public class BaseView {
    ManagerView managerView = new ManagerView();

    private static Scanner in = new Scanner(System.in);

    public static void chooseLanguage() {
        boolean validInput = false;

        while (!validInput) {
            System.out.println("Choose language:");
            System.out.println("1 - English");
            System.out.println("2 - Қазақ тілі");
            System.out.println("3 - Русский язык");

            int option = in.nextInt();

            if (option == 1) {
                ln.setLanguage("en");
                validInput = true;
                ManagerView.ManagerPanel();
            } else if (option == 2) {
                ln.setLanguage("kz");
                validInput = true;
            } else if (option == 3) {
                ln.setLanguage("ru");
                validInput = true;
            } else {
                System.out.println("Invalid choice! // Оңдай таңдау жоқ! // Некорректный выбор!");
            }
            if(validInput){
                return;
            }
        }

    }

    public static void welcome() {
       System.out.println(ln.getMessage("authorize"));


        int option = in.nextInt();

        if (option == 1) {
            authorize("teacher.txt");
        } else if (option == 2) {
            authorize("manager.txt");
        } else if (option == 3) {
            authorize("student.txt");
        }
        else if(option == 4){
            authorize("admin.txt");
        }
        else if(option == 5){
            authorize("librarian.txt");
        }
        else if(option == 6){
            authorize("researcher.txt");
        }
        else if (option == 0){
            System.out.println(ln.getMessage("Goodbye"));
        }
    }

    public static void authorize(String fileName) {
        System.out.println("Please, enter your credentials:");

        in.nextLine();

        System.out.println("Username:");
        String username = in.nextLine();

        System.out.println("Password:");
        String password = in.nextLine();

        boolean res = UserConroller.authorize(fileName, username, password);


        if (res && fileName.equals("admin.txt")) {
            adminMenu();
        } else {
            System.err.println("Your credentials is wrong! Please, try again!");
            welcome();
        }
    }

    public static void adminMenu() {
        System.out.println(ln.getMessage("adminMenu"));

        int option = in.nextInt();

        if (option == 1) {
            createUser();
        } else if (option == 2) {
            showUsers();
        } else if (option == 3) {
            deleteUser();
        }
        else if(option == 4){
            System.out.println(ln.getMessage("Goodbye"));
        }
    }


    public static void showUsers() {
        System.out.println(ln.getMessage("adminMenu_chooseTypeOfUserstoShow"));
        int option = in.nextInt();
        UserType u = null;
        switch (option) {
            case 6:
                u = UserType.RESEARCHER;
                printUserInfo(u);
                break;
            case 5:
                u = UserType.LIBRARIAN;
                printUserInfo(u);
                break;
            case 4:
                u = UserType.ADMIN;
                printUserInfo(u);
                break;
            case 3:
                u = UserType.STUDENT;
                printUserInfo(u);
                break;
            case 2:
                u = UserType.MANAGER;
                printUserInfo(u);
                break;
            case 1:
                u = UserType.TEACHER;
                printUserInfo(u);
                break;
        }
        if(u == null){
            System.out.println(ln.getMessage("adminMenu_chooseTypeError"));
        }
    }
    public static void printUserInfo(UserType u){
        Object o = UserConroller.getUsers(u);
        if(o instanceof Vector){
            Vector v = (Vector)o;
            if(v.isEmpty()){
                System.out.println(ln.getMessage("Empty"));
                return;
            }
            for(Object x : v){
                if(x instanceof User){
                    System.out.println("Username: " + ((User) x).getUsername() + " Password: " + ((User) x).getPassword());
                }

            }
        }
    }
    public static void deleteUser(){
       System.out.println(ln.getMessage("adminDeleteOption"));
       int option = in.nextInt();
       in.nextLine();

       if(option == 1){



           System.out.println(ln.getMessage("EnterUsername"));
           String username = in.nextLine();
           if (username != null && !username.trim().isEmpty()) {
               boolean res = UserConroller.deleteUser(UserType.TEACHER, username);
               if (res) {
                   System.out.println(ln.getMessage("Good"));
               } else {
                   System.out.println(ln.getMessage("Error"));
               }

           }

       }
       else if(option == 2){
           System.out.println(ln.getMessage("EnterUsername"));
           String username = in.nextLine();
           if (username != null && !username.trim().isEmpty()) {
               boolean res = UserConroller.deleteUser(UserType.MANAGER, username);
               if (res) {
                   System.out.println(ln.getMessage("Good"));
               } else {
                   System.out.println(ln.getMessage("Error"));
               }

           }

       }


    }

    public static void createUser() {

        System.out.println(ln.getMessage("adminCreateOption"));
        int option = in.nextInt();

        in.nextLine();

        if (option == 1) {
            System.out.println("Creating a new teacher...");

            System.out.println(ln.getMessage("EnterUsername"));
            String username = in.nextLine();
            System.out.println(ln.getMessage("EnterPassword"));
            String password = in.nextLine();

            // controller
            boolean res = UserConroller.createUser(username, password, UserType.TEACHER);

            if (res) {
                System.out.println(username + " is created!");
            } else {
                System.err.println("error!");
            }

        }
        if (option == 3) {
            System.out.println("Creating a new Manager...");

            System.out.println("Enter a username:");
            String username = in.nextLine();
            System.out.println("Enter a password:");
            String password = in.nextLine();

            // controller
            boolean res = UserConroller.createUser(username, password, UserType.MANAGER);

            if (res) {
                System.out.println(username + " is created!");
            } else {
                System.err.println("error!");
            }

        }
        if (option == 2) {
            System.out.println("Creating a new student...");

            System.out.println("Enter a username:");
            String username = in.nextLine();
            System.out.println("Enter a password:");
            String password = in.nextLine();

            // controller
            boolean res = UserConroller.createUser(username, password, UserType.STUDENT);

            if (res) {
                System.out.println(username + " is created!");
            } else {
                System.err.println("error!");
            }

        }
        if(option == 4){

                System.out.println("Creating a new admin...");

                System.out.println("Enter a username:");
                String username = in.nextLine();
                System.out.println("Enter a password:");
                String password = in.nextLine();
                boolean res = UserConroller.createUser(username, password, UserType.ADMIN);

                if (res) {
                    System.out.println(username + " is created!");
                } else {
                    System.err.println("error!");
                }

        }
        if(option == 5){

            System.out.println("Creating a new researcher...");

            System.out.println("Enter a username:");
            String username = in.nextLine();
            System.out.println("Enter a password:");
            String password = in.nextLine();
            boolean res = UserConroller.createUser(username, password, UserType.RESEARCHER);

            if (res) {
                System.out.println(username + " is created!");
            } else {
                System.err.println("error!");
            }

        }
        if(option == 6){

            System.out.println("Creating a new librarian...");

            System.out.println("Enter a username:");
            String username = in.nextLine();
            System.out.println("Enter a password:");
            String password = in.nextLine();
            boolean res = UserConroller.createUser(username, password, UserType.LIBRARIAN);
            if (res) {
                System.out.println(username + " is created!");
            } else {
                System.err.println("error!");
            }

        }


    }
}