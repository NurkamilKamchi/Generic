package DAO;

import java.util.List;

public interface GenericDao<T, ID> {

    List<T> getAll();

    T getById(ID id);

    boolean add(T t);

    boolean remove(ID id);
}
