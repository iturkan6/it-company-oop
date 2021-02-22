package service;

import dao.DAOHr;
import entity.Employer;

import java.io.IOException;
import java.util.List;

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

    public boolean toHire(String department, int experience, int test1, int test2, int test3,
                          String name, String surname, String status, String login, String password) {
        if (toTest(department, experience, test1, test2, test3)) {
            daoHr.create(new Employer(getAll().size() + 1, login, password, name, surname,
                    department, experience, status));
            return true;
        }
        return false;
    }

    public void save() throws IOException {
        daoHr.write();
    }
}
