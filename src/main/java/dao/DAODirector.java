package dao;

import entity.Employer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DAODirector implements DAO<Employer> {

    ArrayList<Employer> employersAll = new ArrayList<>();

    @Override
    public Optional<Employer> get(int id) {
        return Optional.of(employersAll.get(id));
    }

    @Override
    public List<Employer> getAllBy(Predicate<Employer> p) {
        return employersAll.stream().filter(p).collect(Collectors.toList());
    }

    @Override
    public void create(Employer employer) {
        employersAll.add(employer);
    }

    @Override
    public List<Employer> getAll() {
        return null;
    }

    @Override
    public void delete(Employer employer) {
        employersAll.remove(employer);
    }
}
