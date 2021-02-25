import controller.HrController;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        HrController hrController = new HrController();
        boolean exit = true;
        while (exit) {
            System.out.println("..............Welcome to our application.............\n" +
                    "              Please choose the action:\n" +
                    "1. Come in\n                                3. Pass a test\n" +
                    "2. Exit");
            int number = scanner.nextInt();
            if (number == 1) {
                switch (hrController.toCheckAccess()) {
                    case "hr":
                        hrController.toSeeMessage();
                        break;
                    case "backend":
                        break;
                    case "frontend":
                        break;
                    case "director":
                        break;
                }
            } else if (number == 3) {
                hrController.toHire();
            } else if (number == 2) {
                hrController.toSave();
                exit = false;
            }


        }

    }
}
