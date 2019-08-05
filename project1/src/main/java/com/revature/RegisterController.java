package com.revature;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.revature.*;
import com.revature.login.loginDAO;
import com.revature.login.Login;
import com.revature.ConnectionUtil;

/**
 * LoginController
 *
 * 
 */
@Path(value = "register")
public class RegisterController {

	public void doPost(HttpServletRequest req, HttpServletResponse response)
	throws IOException{
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			String firstname = req.getParameter("firstname");
			String lastname = req.getParameter("lastname");
			System.out.println(username);
			 try{
				 ConnectionUtil con = new ConnectionUtil();
				 loginDAO register = new loginDAO(con.getConnection());
				 Login registerinfo = new Login(username, password, firstname, lastname);
				 register.insert(registerinfo);

		} catch(NullPointerException e){
			e.printStackTrace();
		}
}
}