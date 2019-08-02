package com.revature;

/**
 * Hello world!
 *
 */
import java.util.List;

/**
 * Dao
 */
public interface DAO<E> {
    void insert(E e);

    List<E> getAll();

    void update();

    void delete();
}
