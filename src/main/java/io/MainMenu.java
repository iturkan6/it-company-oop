package io;

import java.util.Scanner;

public class MainMenu implements Menu{
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void print(String line) {
        System.out.print(line);
    }

    @Override
    public void printLn(String line) {
        System.out.println(line);
    }

    @Override
    public String readLn() {
        return scanner.nextLine().toLowerCase().trim();
    }

    public int readInt() {
        while (true){
            try {
                return Integer.parseInt(readLn());
            } catch (Exception exception){
                print("Invalid input. Try to enter number.");
            }
        }
    }
    public void displayMenu(){
        print("...............Welcome to our application...............\n");
        print("Please choose the action:                               \n");
        print("1. Login                                  3. Pass a test\n");
        print("2. Exit                                                 \n");
    }
}
