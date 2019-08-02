package com.revature.login;

import java.util.List;

import com.revature.DAO;
import com.revature.Service;

/**
 * loginService
 */
public class loginService implements Service<Login> {
    private DAO<Login> dao;

    public loginService(DAO<Login> dao) {
        this.dao = dao;
    }

    @Override
    public void insert(Login login) {
        this.dao.insert(login);
    }

    @Override
    public List<Login> getAll() {
        return dao.getAll();
    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {
		
    }

}