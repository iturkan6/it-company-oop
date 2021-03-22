package controller;

import io.MainMenu;

public class BackendController {
    MainMenu menu = new MainMenu();
    private boolean exit = true;

    public void writeApp() {
        System.out.println("You are cool developer! You wrote java application!");
    }

    public void createApi() {
        System.out.println("API for Front End is crated");
    }

    public void toBreak() {
        System.out.println("You was very productive today. You can take a break ;)");
    }

    public void toSeeMessage() {
        while (exit) {
            menu.print("..............Welcome to Back End Department..............\n");
            menu.print("Please choose the action:                                 \n");
            menu.print("1. Write application                3. To take a break\n");
            menu.print("2. Create API                       4. Return to main menu\n");
            int num = menu.readInt();
            switch (num) {
                case 1:
                    writeApp();
                case 2:
                    createApi();
                    break;
                case 3:
                    toBreak();
                    break;
                case 4:
                    exit = false;
                default:
                    menu.print("Please enter a number from 1 to 4");
                    break;
            }
        }
    }
}
