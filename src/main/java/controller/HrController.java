package controller;

import io.MainMenu;
import service.AdminService;

import java.io.IOException;

public class HrController {
    boolean exit = true;
    AdminService adminService = new AdminService();
    MainMenu menu = new MainMenu();

    public HrController() throws IOException {
    }

    public void toHire() {
        menu.print("Please choose the department you want to be hired: \n");
        menu.print("1. Front End                              2. Back End");
        int department = menu.checkInt();
        String dep = department == 1 ? "frontend" : "backend";
        menu.printLn("How much experience you have?");
        int exp = menu.checkInt();
        menu.print("Please take a short test to to check your skills. Choose a correct number.\n");
        switch (department) {
            case 1:
                if (testFrontend(exp)) {
                    createEmployer(exp, dep);
                } else {
                    menu.print("Unfortunately you cant pass our exam");
                }
                break;
            case 2:
                if (testBackend(exp)) {
                    createEmployer(exp, dep);
                } else {
                    menu.print("Unfortunately you cant pass our exam");
                }
                break;
            default:
                System.out.println("We dont have such department");
        }

    }

    public boolean testBackend(int experience) {
        menu.print("Question1. What is the best programming language?\n1. Python\n2. Java");
        int test1 = menu.checkInt();
        menu.print("Question2. How are you?\n1. Fine\n2. So so");
        int test2 = menu.checkInt();
        menu.print("Do you love caterpillars?\n1. No\n2. Yes");
        int test3 = menu.checkInt();
        return experience >= 5 && test1 == 2 && test2 == 1 && test3 == 2;
    }

    public boolean testFrontend(int experience) {
        menu.print("Question1. What is the best programming language?\n1. JS\n2. Css");
        int test1 = menu.checkInt();
        menu.print("Question2. How are you?\n1. Amazing\n2. Bad");
        int test2 = menu.checkInt();
        menu.print("Do you love animals?\n1. No\n2. Yes");
        int test3 = menu.checkInt();
        return experience >= 2 && test1 == 1 && test2 == 1 && test3 == 2;
    }

    public void createEmployer(int experience, String department) {
        menu.print("Congratulations! You are hired.\n Please enter your details.\n Enter your name:");
        String name = menu.readLn();
        menu.print("Your surname:");
        String surname = menu.readLn();
        menu.print("Create your login");
        String login = menu.readLn();
        menu.print("Create your password");
        String password = menu.readLn();
        adminService.toHire(department, experience, name, surname, "online", login, password);
    }


    public void getInfoByName() {
        menu.print("Enter name of employer: ");
        String name = menu.readLn();
        menu.print("Enter surname of employer: ");
        String surname = menu.readLn();
        menu.print("Enter department in which employer work: ");
        String department = menu.readLn();
        System.out.println(adminService.getInfoByName(name, surname, department).toString());
    }

    public void getInfoById() {
        menu.print("Enter id of employer: ");
        int id = menu.checkInt();
        menu.print(adminService.getInfoById(id).toString());
    }

    public void toSave() throws IOException {
        adminService.save();
    }

    public String toCheckAccess() {
        menu.print("Type your login: ");
        String login = menu.readLn();
        menu.print("Type your password");
        String password = menu.readLn();
        return adminService.getByCredentials(login, password).get(0).getDepartment();
    }

    public void toSeeMessage() {

        while (exit) {
            System.out.println("..............Welcome to HR Department.............\n" +
                    "              Please choose the action:\n" +
                    "1. To see the inform about employer          2. Exit\n");
            int num = menu.checkInt();
            switch (num) {
                case 1:
                    while (true) {
                        menu.print("                Choose the number:                \n");
                        menu.print("1.Get information bt ID      3.Return to main menu\n");
                        menu.print("2.Get information by Name and Surname             \n");
                        int i = menu.checkInt();
                        if (i == 1) {
                            getInfoById();
                        } else if (i == 2) {
                            getInfoByName();
                        } else {
                            break;
                        }
                    }
                case 2:
                    exit = false;
                    break;
            }
        }
    }
}

