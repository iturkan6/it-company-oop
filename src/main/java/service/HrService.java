package service;

import dao.DAOHr;
import entity.Employer;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class HrService {
    public DAOHr daoHr = new DAOHr();

    public HrService() throws IOException {
    }

    public List<Employer> getAll() {
        return daoHr.getAll();
    }

    public boolean toTest(String department, int experience, int test1, int test2, int test3) {
        if (department.trim().toLowerCase().equals("frontend")) {
            return experience == 3 && test1 == 2 && test2 == 1 && test3 == 2;
        } else if (department.trim().toLowerCase().equals("backend")) {
            return experience == 5 && test1 == 3 && test2 == 4 && test3 == 2;
        }
        return false;
    }

    public void toHire(String department, int experience,
                       String name, String surname, String status, String login, String password) {
        daoHr.create(new Employer(getAll().size() + 1, login, password, name, surname,
                department, experience, status));
    }

    public List<Employer> getInfoByName(String name, String surname, String department) {
        List<Employer> employers = getAll();
        if (employers.size() == 0) {
            System.out.println("No such employer");
        } else {
            return daoHr.getAllBy(e -> e.getName().equals(name)
                    && e.getSurname().equals(surname) && e.getDepartment().equals(department));
        }
        return Collections.emptyList();
    }

    public Optional<Employer> getInfoById(int id) {
        if (getAll().size() == 0) {
            System.out.println("No such Employer");
        } else {
            return daoHr.get(id);
        }
        return Optional.empty();
    }

    public void save() throws IOException {
        daoHr.write();
    }

    public void toDismiss(Employer employer) {
        daoHr.delete(employer);
    }

}

