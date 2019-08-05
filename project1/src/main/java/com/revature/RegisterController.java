package com.revature;

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
public class RegisterController {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Requests> getAllRequestsJSON() {
		List<Requests> requests = null;

		try (Connection connection = new ConnectionUtil().getConnection()) {
			requestsDAO dao = new requestsDAO(connection);
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
	public void insertRequest(@FormParam("id") int id, @FormParam("descriptor") String descriptor,@FormParam("amount") double amount, @FormParam("image") String image,
			@Context HttpServletResponse resp) throws IOException {
		try (Connection connection = new ConnectionUtil().getConnection()) {
			requestsDAO dao = new requestsDAO(connection);
			requestService service = new requestService(dao);
			service.insert(new Requests(id, descriptor, amount, image ));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		resp.sendRedirect("/requests-api");
	}
}