package com.revature;

import java.util.List;

import com.revature.login.Login;
import com.revature.login.loginDAO;
import com.revature.ConnectionUtil;

public class TrySQL {
    public static void main(String args[]){
        System.out.println("DIllonTry");
        ConnectionUtil con = new ConnectionUtil();
        System.out.println(con.getConnection());

        loginDAO tryDao = new loginDAO(con.getConnection());
        List<Login> logList = tryDao.getAll();
        System.out.println(logList);
        System.out.println("KennyBenjamin");
    }
}