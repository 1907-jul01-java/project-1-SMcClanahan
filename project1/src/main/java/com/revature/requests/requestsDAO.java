package com.revature.requests;

import com.revature.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class requestsDAO implements DAO<Requests> {
    Connection connection;
    
    public requestsDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Requests request) {
        try {
            PreparedStatement pStatement = connection.prepareStatement("insert into requests(amount, descriptor, image) values(?, ?, ?)");
            pStatement.setDouble(1, request.getAmount());
            pStatement.setString(2, request.getDescriptor());
            pStatement.setString(3, request.getImage());
            pStatement.executeUpdate();
        } catch (SQLException e) {

        }
    }

    @Override
    public List<Requests> getAll() {
        Requests request;
        List<Requests> requests = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from requests");
            while (resultSet.next()) {
                request = new Requests();
                request.setId(resultSet.getInt("id"));
                request.setAmount(resultSet.getDouble("amount"));
                request.setDescriptor(resultSet.getString("descriptor"));
                request.setImage(resultSet.getString("image"));
                requests.add(request);
            }
        } catch (SQLException e) {

        }
        return requests;
    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }
}