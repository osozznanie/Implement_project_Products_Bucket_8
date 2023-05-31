package ExampleWithDB.DAO;

import java.sql.SQLException;
import java.util.List;

public abstract class BaseDAO <T> {
    public abstract void create(T t) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException;

    public abstract List<T> readAll();

    public abstract void update(T t);

    public abstract void deleteById(int id);
}

