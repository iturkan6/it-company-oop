package dao;

import entity.Employer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DAOFrontend implements DAO<Employer> {
    ArrayList<Employer> employersFront = new ArrayList<>();

    @Override
    public Optional<Employer> get(int id) {
        return Optional.of(employersFront.get(id));
    }

    @Override
    public List<Employer> getAllBy(Predicate<Employer> p) {
        return employersFront.stream().filter(p).collect(Collectors.toList());
    }


    @Override
    public void create(Employer employer) {
        employersFront.add(employer);
    }

    @Override
    public List<Employer> getAll() {
        return null;
    }


    @Override
    public void delete(Employer employer) {
        employersFront.remove(employer);
    }

}
