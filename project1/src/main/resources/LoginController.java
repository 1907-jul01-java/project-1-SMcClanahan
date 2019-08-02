package com.revature.resources;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.revature.login.*;
import com.revature.*;

/**
 * LoginController
 *
 * 
 */
@Path(value = "logins")
public class LoginController {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Login> getAllLoginsJSON() {
		List<Login> logins = null;

		try (Connection connection = new ConnectionUtil().getConnection()) {
			loginDAO dao = new loginDAO(connection);
			loginService service = new loginService(dao);
			logins = service.getAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return logins;
	}

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_HTML)
	public void insertLogin(@FormParam("id") String id, @FormParam("username") String username,@FormParam("password") String password, @FormParam("firstname") String firstname, @FormParam("lastname") String lastname,
			@Context HttpServletResponse resp) throws IOException {
		try (Connection connection = new ConnectionUtil().getConnection()) {
			loginDAO dao = new loginDAO(connection);
			loginService service = new loginService(dao);
			service.insert(new Login(0, username, password, firstname, lastname));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		resp.sendRedirect("/login-api");
	}
}