package dao_jdbc;

import java.sql.SQLException;

public interface EntityDAO<E> {

    void add(E e) throws SQLException;
    void read(long id);
    void all();
    void update(E e, long id);
    void delete(long id);
}
