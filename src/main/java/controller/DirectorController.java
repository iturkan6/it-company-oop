package controller;

import io.MainMenu;
import service.AdminService;

import java.io.IOException;

public class DirectorController {
    AdminService service = new AdminService();
    private MainMenu menu = new MainMenu();
    private boolean exit = true;

    public DirectorController() throws IOException {
    }

    public void toHire() {
        menu.print("Please write the department in which you accept the employee: ");
        String department = menu.readLn();
        menu.print("How much experience employer have? Type here -> ");
        int experience = menu.readInt();
        menu.print("Enter name: ");
        String name = menu.readLn();
        menu.print("Enter surname: ");
        String surname = menu.readLn();
        menu.print("Create login for employer: ");
        String login = menu.readLn();
        menu.print("Create password for employer");
        String password = menu.readLn();
        service.toHire(department, experience, name, surname, "online", login, password);
    }


    public void getInfoByName() {

        menu.print("Please write the department of employer: ");
        String department = menu.readLn();
        menu.print("Enter name: ");
        String name = menu.readLn();
        menu.print("Enter surname: ");
        String surname = menu.readLn();
        System.out.println(service.getInfoByName(name, surname, department).toString());
    }

    public void getInfoById() {
        menu.print("Enter id of employer");
        int id = menu.readInt();
        System.out.println(service.getInfoById(id).toString());
    }

    public void toSave() throws IOException {
        service.save();
    }

    public String toCheckAccess() {
        menu.print("Type your login");
        String login = menu.readLn();
        menu.print("Type your password");
        String password = menu.readLn();
        return service.getByCredentials(login, password).iterator().next().getDepartment();
    }

    public void toDismiss(){
        menu.print("Enter ID of employer");
        int id = menu.readInt();
        service.deleteById(id);
    }

    public void toSeeMessage(){

        while (exit) {
            menu.print(".................Welcome to Director Service.................\n");
            menu.print("Please choose the action:                                    \n");
            menu.print("1. See the inform about employer(s)    3. Delete employer\n");
            menu.print("2. Hire new employer                   4. Return to main menu\n");
            int num = menu.readInt();
            switch (num) {
                case 1:
                    while (true) {
                        menu.print("                  Choose the number:\n");
                        menu.print("1.Get information bt ID       2.Get information by name and surname \n");
                        menu.print("3.Return to main menu\n");
                        int i = menu.readInt();
                        if (i == 1) {
                            getInfoById();
                        } else if (i == 2) {
                            getInfoByName();
                        } else if(i == 3){
                            break;
                        }else {
                            System.out.println("Please enter a number from 1 to 3");
                        }
                    }
                case 2:
                    toHire();
                    break;
                case 3:
                    toDismiss();
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
