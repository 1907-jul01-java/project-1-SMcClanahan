package com.revature;

import java.util.List;

/**
 * Service
 */
public interface Service<E> {
    void insert(E e);

    List<E> getAll();

    void update();

    void delete();
}