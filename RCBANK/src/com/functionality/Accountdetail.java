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
 * Servlet implementation class Accountdetail
 */
public class Accountdetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Accountdetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		Connection con = DataConnection.connect();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username+" "+password);
		
		String query = "select * from account where username = ? and password = ?";
		PreparedStatement st;
		try {
			st = con.prepareStatement(query);
			st.setString(1,username);
			st.setString(2,password);
			ResultSet rs = st.executeQuery();
			if(rs.next())
			{
				int id = rs.getInt(1);
				int accountno = rs.getInt(2);
				String name = rs.getString(5);
				int balance = rs.getInt(6);
				setget.setId(id);
				setget.setName(name);
				setget.setAccountno(accountno);
				setget.setBalance(balance);
				setget.setUsername(username);
				setget.setPassword(password);
				response.sendRedirect("showdetail.jsp");
				
				
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

}
