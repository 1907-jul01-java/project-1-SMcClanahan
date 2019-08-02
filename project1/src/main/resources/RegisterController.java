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

import com.revature.requests.*;
import com.revature.*;

/**
 * LoginController
 *
 * 
 */
@Path(value = "requests")
public class LoginController {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Requests> getAllRequestsJSON() {
		List<Requests> requests = null;

		try (Connection connection = new ConnectionUtil().getConnection()) {
			requestDAO dao = new requestDAO(connection);
			requestService service = new requestService(dao);
			requests = service.getAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return requests;
	}

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_HTML)
	public void insertRequest(@FormParam("id") String id, @FormParam("username") String username,@FormParam("password") String password, @FormParam("firstname") String firstname, @FormParam("lastname") String lastname,
			@Context HttpServletResponse resp) throws IOException {
		try (Connection connection = new ConnectionUtil().getConnection()) {
			requestDAO dao = new requestDAO(connection);
			requestService service = new requestService(dao);
			service.insert(new Requests(0, username, password, firstname, lastname));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		resp.sendRedirect("/requests-api");
	}
}