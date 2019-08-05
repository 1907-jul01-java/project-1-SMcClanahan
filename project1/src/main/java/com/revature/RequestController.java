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
import com.revature.requests.Requests;
import com.revature.requests.requestsDAO;
import com.sun.research.ws.wadl.Request;
import com.revature.ConnectionUtil;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * LoginController
 *
 * 
 */
@Path(value = "requests")
public class RequestController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	JSONObject currentUser;
	Connection connection;

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		PrintWriter out = resp.getWriter();
        out.println("Hello from get");
        ArrayList<Requests> reqList = null;
        try{
            ConnectionUtil conn = new ConnectionUtil();
            requestsDAO tryDao = new requestsDAO(conn.getConnection());
            reqList = tryDao.getAll();
            JSONArray jData = new JSONArray();
            
            jData.put(reqList);
            resp.getWriter().write(jData.toString());
        } catch(NullPointerException e){
            e.printStackTrace();
        }
	}

	// @GET
	// @Path("/currentUser")
	// @Produces(MediaType.APPLICATION_JSON)
	// public JSONObject getInfo(String username){
	// 	return currentUser;

	// }

	public void doPost(HttpServletRequest req, HttpServletResponse response)
	throws IOException{
        Requests requestList = null;
        String id  = req.getParameter("id");
        requestList.setDescriptor(req.getParameter("descriptor"));
        String amount = req.getParameter("amount");
        requestList.setAmount(Double.parseDouble(amount));
        requestList.setId(Integer.parseInt(id));
        try{
            ConnectionUtil conn = new ConnectionUtil();
            requestsDAO Req = new requestsDAO(conn.getConnection());
            Req.insert(requestList);
        } catch(NullPointerException e){
            e.printStackTrace();
        }
    }
    }