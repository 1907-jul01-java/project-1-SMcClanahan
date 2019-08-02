package com.revature.requests;

import java.util.List;

import com.revature.DAO;
import com.revature.Service;

/**
 * requestService
 */
public class requestService implements Service<Requests> {
    private DAO<Requests> dao;

    public requestService(DAO<Requests> dao) {
        this.dao = dao;
    }

    @Override
    public void insert(Requests request) {
        this.dao.insert(request);
    }

    @Override
    public List<Requests> getAll() {
        return dao.getAll();
    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {
		
    }

}