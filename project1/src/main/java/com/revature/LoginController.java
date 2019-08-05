package com.revature;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ProtocolException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
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
import com.revature.ConnectionUtil;

import org.json.JSONArray;
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
	Connection connection;

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		PrintWriter out = resp.getWriter();
		out.println("Hello from get");
	}

	public ArrayList<Login> getAllLoginsJSON() {
		ArrayList<Login> logList = null;
		try  {
			ConnectionUtil con = new ConnectionUtil();
        System.out.println(con.getConnection());

        loginDAO tryDao = new loginDAO(con.getConnection());
		logList = tryDao.getAll();
		System.out.println(logList);
			//URL obj = new URL(url);
			//HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
			// connection.setRequestMethod("GET");
			// connection.setRequestProperty("Content-length", "0");
			// connection.setUseCaches(true);
			// connection.connect();
		// } catch (ProtocolException e) {
		// 	e.printStackTrace();
		// }catch (IOException e){
		// 	e.printStackTrace();
		}catch(NullPointerException e){
			e.printStackTrace();
		}

		return logList;
	}

	// @GET
	// @Path("/currentUser")
	// @Produces(MediaType.APPLICATION_JSON)
	// public JSONObject getInfo(String username){
	// 	return currentUser;

	// }

	public void doPost(HttpServletRequest req, HttpServletResponse response)
	throws IOException{
			ArrayList<Login> temp =  this.getAllLoginsJSON();
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			System.out.println(username);
			System.out.println(password);
			JSONArray jArray = new JSONArray();
			 try{
				 //JSONArray jData = new JSONArray().put(temp);
				//  JSONObject jData = new JSONObject();
				//  response.setContentType("application/json");
				//  response.getWriter().write(jData.toString());
				//  response.setContentType("text/html");
				//  response.getWriter().write(temp.toString());
			for (int i = 0; i < temp.size() ; i++) {
				jArray.put(temp.get(i));
				if (temp.get(i).getUsername() == username){
					
					if(temp.get(i).getPassword() == password){
						
						response.setContentType("application/json");
							response.getWriter().write(jArray.getString(i));
							break;
					
						
					}
					else{
						response.setContentType("html/text");
						response.getWriter().write("invalidPass");
						//response.sendRedirect("invalidPassword.html");
						
					}
				}
				else{
					response.setContentType("html/text");
						response.getWriter().write("invalidUser");
					//response.sendRedirect("invalidUsername.html");
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