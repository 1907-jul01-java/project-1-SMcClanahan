package com.revature.login;

import com.revature.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class loginDAO implements DAO<Login> {
    Connection connection;
    
    public loginDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Login login) {
        try {
            PreparedStatement pStatement = connection.prepareStatement("insert into logins(username, pass, firstname, lastname) values(?, ?, ?, ?)");
            pStatement.setString(1, login.getUsername());
            pStatement.setString(2, login.getPassword());
            pStatement.setString(3, login.getFirstname());
            pStatement.setString(4, login.getLastname());
            pStatement.executeUpdate();
        } catch (SQLException e) {

        }
    }

    @Override
    public List<Login> getAll() {
        Login login;
        List<Login> logins = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from logins");
            while (resultSet.next()) {
                login = new Login();
                login.setId(resultSet.getInt("id"));
                login.setUsername(resultSet.getString("username"));
                login.setFirstname(resultSet.getString("firstname"));
                login.setLastname(resultSet.getString("lastname"));
                logins.add(login);
            }
        } catch (SQLException e) {

        }
        return logins;
    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }
}