package controller;

import service.HrService;

import java.io.IOException;
import java.util.Scanner;

public class HrController {
    boolean exit = true;
    HrService hrService = new HrService();

    public HrController() throws IOException {
    }

    Scanner scanner = new Scanner(System.in);


    public void toHire(){

        System.out.println("Please write the department you want to be hired");
        String department = scanner.nextLine().toLowerCase().trim();
        System.out.println("How much experience you have?");
        int exp = scanner.nextInt();
        System.out.println("Please take a short test to to check your skills. Choose a correct number.\nQuestion1. " +
                "What is the best programming language?\n1. Python\n2. Java");
        int test1 = scanner.nextInt();
        System.out.println("Question2. How are you?\n 1.Fine\n2.So so");
        int test2 = scanner.nextInt();
        System.out.println("Do you love caterpillars?\n1.No\n2.Yes");
        int test3 = scanner.nextInt();
        if (hrService.toTest(department, exp, test1, test2, test3)) {
            scanner.nextLine();
            System.out.println("Congratulations! You are hired.\n Please enter your details.\n Enter your name:");
            String name = scanner.nextLine().trim().toLowerCase();
            System.out.println("Your surname:");
            String surname = scanner.nextLine().trim().toLowerCase();
            System.out.println("Create your login");
            String login = scanner.nextLine().trim().toLowerCase();
            System.out.println("Create your password");
            String password = scanner.nextLine().trim().toLowerCase();
            hrService.toHire(department, exp, name, surname, "online", login, password);
        } else {
            System.out.println("Unfortunately you cant pass our exam");
        }
    }

    public void getInfoByName() {
        System.out.println("Enter name, surname and department of employer");
        String name = scanner.nextLine().trim().toLowerCase();
        String surname = scanner.nextLine().trim().toLowerCase();
        String department = scanner.nextLine().trim().toLowerCase();
        System.out.println(hrService.getInfoByName(name, surname, department).toString());
    }
    public void info() throws IOException {
        hrService.information();
    }

    public void getInfoById() {
        System.out.println("Enter id of employer");
        int id = scanner.nextInt();
        System.out.println(hrService.getInfoById(id).toString());
    }

    public void toSave() throws IOException {
        hrService.save();
    }

    public String toCheckAccess() {
        System.out.println("Type your login");
        String login = scanner.nextLine().toLowerCase().trim();
        System.out.println("Type your password");
        String password = scanner.nextLine().toLowerCase().trim();
        return hrService.getByCredentials(login, password).get(0).getDepartment();
    }

    public void toSeeMessage() {

        while (exit) {
            System.out.println("..............Welcome to HR Department.............\n" +
                    "              Please choose the action:\n" +
                    "1. To see the inform about employer          2. Exit\n");
            int num = scanner.nextInt();
            switch (num) {
                case 1:
                    while (true) {
                        System.out.println("Choose the number:\n1.Get information bt ID\n" +
                                "2.Get information by Name and Surname\n3.Return to main menu");
                        int i = scanner.nextInt();
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

