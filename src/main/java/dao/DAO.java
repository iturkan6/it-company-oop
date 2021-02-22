package dao;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public interface DAO<T> {
    Optional<T> get(int id);

    List<T> getAllBy(Predicate<T> p);

    void create(T t);

    List<T> getAll();

    void delete(T t);
}
