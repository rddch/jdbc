package DAO;

import java.sql.SQLException;
import java.util.List;

public interface EntityDAO<E> {

    void add(E e) throws SQLException;
    E read(long id);
    List<E> all();
    void update(E e);
    void delete(long id);
}
