package com.functionality;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jdbcdemo.DataConnection;

/**
 * Servlet implementation class Checkbalance
 */
public class Checkbalance extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Checkbalance() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection con = DataConnection.connect();
		String password = request.getParameter("password");
		System.out.println(password);
		
		String query = "select * from account where password = ?";
		PreparedStatement st;
		
			try {
				st = con.prepareStatement(query);
			
			st.setString(1, password);
			ResultSet rs = st.executeQuery();
			if(rs.next())
			{
				int id = rs.getInt(1);
				String username = rs.getString(3);
				int accountno = rs.getInt(2);
				int balance = rs.getInt(6);
				String name = rs.getString(5);
				setget.setAccountno(accountno);
				setget.setBalance(balance);
				setget.setName(name);
				setget.setUsername(username);
				response.sendRedirect("showbalance.jsp");
	
			}
			else
			{
				response.sendRedirect("index.html");
			}
			} 
			catch(SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		doGet(request, response);
	}

}
