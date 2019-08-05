package com.revature.login;

import com.revature.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class loginDAO {
    Connection connection;
    
    public loginDAO(Connection connection) {
        this.connection = connection;
    }


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


    public ArrayList<Login> getAll() {
        Login login;
        ArrayList<Login> logins = new ArrayList<>();
        try {
            System.out.println(this.connection);
            PreparedStatement pstatement = connection.prepareStatement("select * from logins");
            ResultSet resultSet = pstatement.executeQuery();
            while (resultSet.next()) {
                login = new Login();
                login.setId(resultSet.getInt("id"));
                login.setUsername(resultSet.getString("username"));
                login.setFirstname(resultSet.getString("firstname"));
                login.setLastname(resultSet.getString("lastname"));
                System.out.println(resultSet.getString("lastname"));
                logins.add(login);
            }
        } catch (SQLException e) {

        }catch  (NullPointerException e){
            e.printStackTrace();
        }
        
        return logins;
    }
    //TODO update logic for the table
    
    public void update() {

    }

    
    public void delete() {

    }
}