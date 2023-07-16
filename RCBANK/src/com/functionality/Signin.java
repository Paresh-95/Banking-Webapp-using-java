package com.functionality;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jdbcdemo.DataConnection;


/**
 * Servlet implementation class Signin
 */
public class Signin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection con = DataConnection.connect();
		String name = request.getParameter("name");
		int accountno = Integer.parseInt(request.getParameter("accountno"));
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		int balance = Integer.parseInt(request.getParameter("balance"));
		System.out.println(name+" "+accountno+" "+username+" "+password+" "+balance);
		
		PreparedStatement st;
		String query = "insert into account (name,accountno,username,password,balance) values(?,?,?,?,?)";

		try {
			st = con.prepareStatement(query);
			st.setString(1,name);
			st.setInt(2,accountno);
			st.setString(3,username);
			st.setString(4,password);
			st.setInt(5,balance);
			int i = st.executeUpdate();
			System.out.println("Record inserted");
			if(i>0)
			{	
				
				setget.setName(name);
				setget.setAccountno(accountno);
				setget.setUsername(username);
				setget.setPassword(password);
				setget.setBalance(balance);
				response.sendRedirect("home.html");
			}
			else
			{
				response.sendRedirect("index.html");
			}
			
			
			
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
