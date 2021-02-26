package service;

import dao.DAOAdmin;
import entity.Employer;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class AdminService {
    public DAOAdmin daoAdmin = new DAOAdmin();

    public AdminService() throws IOException {

    }

    public List<Employer> getAll() {
        return daoAdmin.getAll();
    }

    public boolean toTestBackend( int experience, int test1, int test2, int test3) {
            return experience >= 5 && test1 == 2 && test2 == 1 && test3 == 2;
    }
    public boolean toTestFront(int experience, int test1, int test2, int test3) {
            return experience >= 3 && test1 == 2 && test2 == 1 && test3 == 2;
    }

    public void toHire(String department, int experience,
                       String name, String surname, String status, String login, String password) {
        daoAdmin.create(new Employer(getAll().size() + 1, login, password, name, surname,
                department, experience, status));
    }

    public List<Employer> getInfoByName(String name, String surname, String department) {
        List<Employer> employers = getAll();
        if (employers.size() == 0) {
            System.out.println("No such employer");
        }
        return daoAdmin.getAllBy(e -> e.getName().equals(name)
                && e.getSurname().equals(surname) && e.getDepartment().equals(department));
    }

    public Optional<Employer> getInfoById(int id) {
        if (getAll().size() == 0) {
            System.out.println("No such Employer");
        } else {
            return daoAdmin.get(id - 1);
        }
        return Optional.empty();
    }

    public void save() throws IOException {
        daoAdmin.write();
    }

    public void deleteById(int id) {
        if(getAll().size() == 0){
            System.out.println("We don't have employers :(");
        }
        try {
            Employer employer = daoAdmin.get(id-1).orElseThrow(Exception::new);
            daoAdmin.delete(employer);
            System.out.println(employer.toString() + "\nAbove employer was deleted.");
        }catch (Exception ex){
            System.out.println("No employer with this ID.");
        }

    }

    public List<Employer> getByCredentials(String login, String password) {

        return daoAdmin.getAllBy(e -> e.getLogin().equals(login) && e.getPassword().equals(password));
    }

}

