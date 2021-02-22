package dao;

import entity.Employer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DAOBackend implements DAO<Employer> {
    ArrayList<Employer> employersBack = new ArrayList<>();

    @Override
    public Optional<Employer> get(int id) {
        return Optional.of(employersBack.get(id));
    }

    @Override
    public List<Employer> getAllBy(Predicate<Employer> p) {
        return employersBack.stream().filter(p).collect(Collectors.toList());
    }

    @Override
    public void create(Employer employer) {
        employersBack.add(employer);
    }

    @Override
    public List<Employer> getAll() {
        return null;
    }

    @Override
    public void delete(Employer employer) {
        employersBack.remove(employer);
    }
}
