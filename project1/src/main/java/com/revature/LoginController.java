package com.revature;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// import javax.ws.rs.Consumes;
// import javax.ws.rs.FormParam;
// import javax.ws.rs.GET;
// import javax.ws.rs.POST;
import javax.ws.rs.Path;

// import javax.ws.rs.Produces;
// import javax.ws.rs.core.Context;
// import javax.ws.rs.core.MediaType;
import com.revature.login.Login;
import com.revature.login.loginDAO;
import com.revature.login.loginService;

import org.json.JSONObject;

/**
 * LoginController
 *
 * 
 */
@Path(value = "logins")
public class LoginController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	JSONObject currentUser;

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		PrintWriter out = resp.getWriter();
		out.println("Hello from get");
	}

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

	// @GET
	// @Path("/currentUser")
	// @Produces(MediaType.APPLICATION_JSON)
	// public JSONObject getInfo(String username){
	// 	return currentUser;

	// }

	public void doPost(HttpServletRequest req, HttpServletResponse response)
	throws IOException{
			List<Login> temp =  this.getAllLoginsJSON();
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			try{
			for (int i = 0; i < temp.size() ; i++) {
				if (temp.get(i).getUsername() == username){
					if(temp.get(i).getPassword() == password){
						currentUser
						.put("username", username)
						.put("firstname", temp.get(i).getFirstname())
						.put("lastname", temp.get(i).getLastname())
						.put("id", temp.get(i).getId());
							response.sendRedirect("/");
					
						
					}
					else{
						response.sendRedirect("invalidPassword.html");
						
					}
				}
				else{
					response.sendRedirect("invalidUsername.html");
				}
			}
		}catch(IOException e){
				e.printStackTrace();
			}
			

		}

	// @POST
	// @Path("/mklogin")
	// @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	// @Produces(MediaType.TEXT_HTML)
	// public void insertLogin(@FormParam("id") String id, @FormParam("username") String username,@FormParam("password") String password, @FormParam("firstname") String firstname, @FormParam("lastname") String lastname,
	// 		@Context HttpServletResponse resp) throws IOException {
	// 	try (Connection connection = new ConnectionUtil().getConnection()) {
	// 		loginDAO dao = new loginDAO(connection);
	// 		loginService service = new loginService(dao);
	// 		service.insert(new Login(0, username, password, firstname, lastname));
	// 	} catch (SQLException e) {
	// 		e.printStackTrace();
	// 	}

	// 	resp.sendRedirect("/login-api");
	// }
}