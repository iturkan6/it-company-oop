package controller;

import io.MainMenu;

public class FrontendController {
    MainMenu menu = new MainMenu();
    private boolean exit = true;

    public void writeSite() {
        System.out.println("You write very cool site!");
    }

    public void takeApi() {
        System.out.println("Api from Back End is taken");
    }

    public void toBreak() {
        System.out.println("You was very productive today. You can take a break ;)");
    }

    public void toSeeMessage() {
        while (exit)
            menu.print("..............Welcome to Front End Department..............\n");
        menu.print("Please choose the action:                                  \n");
        menu.print("1. Write site                        3. To take a break\n");
        menu.print("2. Take API                          4. Return to main menu\n");
        int num = menu.checkInt();
        switch (num) {
            case 1:
                writeSite();
            case 2:
                takeApi();
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
