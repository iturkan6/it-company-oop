import controller.BackendController;
import controller.DirectorController;
import controller.FrontendController;
import controller.HrController;
import io.MainMenu;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        MainMenu menu = new MainMenu();
        HrController hrController = new HrController();
        DirectorController directorController = new DirectorController();
        BackendController backendController = new BackendController();
        FrontendController frontendController = new FrontendController();
        boolean exit = true;
        while (exit) {
            menu.displayMenu();
            int number = menu.checkInt();
            switch (number) {
                case 1:
                    switch (hrController.toCheckAccess()) {
                        case "hr":
                            hrController.toSeeMessage();
                            break;
                        case "backend":
                            backendController.toSeeMessage();
                            break;
                        case "frontend":
                            frontendController.toSeeMessage();
                            break;
                        case "director":
                            directorController.toSeeMessage();
                            break;
                    }
                    break;
                case 3:
                    hrController.toHire();
                    break;
                case 2:
                    hrController.toSave();
                    exit = false;
                    break;
                default:
                    menu.print("Please enter number from 1 to 3");
                    break;
            }
        }
    }
}
