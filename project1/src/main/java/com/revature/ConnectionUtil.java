package com.revature;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ConnectionUtil {
    private Connection connection;
    private DataSource dataSource = null;
    private String url;
    private String user;
    private String password;

    public ConnectionUtil() {
        try {
            System.out.println("KennyWussy");
            //Properties properties = new Properties();
            //properties.load(new FileReader( new File(getClass().getClassLoader().getResource("project1/src/main/resources/connection.properties").getFile())));
            //properties.load(new FileReader("resources/connection.properties"));
            this.url = "jdbc:postgresql://localhost:5432/postgres";
            this.user = "postgres";
            this.password = "";
            
            //System.out.println(this.url);
            //System.out.println(this.password);
            //System.out.println(this.user);
            try{        
                Class.forName("org.postgresql.Driver");
                // Context initContext = new InitialContext();
                // Context envContext = (Context) initContext.lookup("java:/comp/env/jdbc/postgres");
                // dataSource = (DataSource) envContext.lookup("jdbc/postgres");
                // this.connection = dataSource.getConnection();
                
                this.connection = DriverManager.getConnection(this.url, this.user, this.password);
            } catch(NullPointerException e){
                e.getMessage();
                System.out.println(connection);
            }catch(ClassNotFoundException e){
                e.getMessage();
            }
            //PrintStream connectionInfo = DriverManager.getLogStream();
            //connectionInfo.print(connectionInfo);
        } catch(SQLException e){
            e.getMessage();
        }  catch(NullPointerException e){
            e.getMessage();
        }
        System.out.println(connection);

    }

    public void close(){
        try{
            this.connection.close();
        }catch(SQLException e){

        }
    }

    public Connection getConnection(){
        return connection;
    }
}