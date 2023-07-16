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
 * Servlet implementation class Sendmoney
 */
public class Sendmoney extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sendmoney() {
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
	
		doGet(request, response);
		Connection con = DataConnection.connect();
		String rname = request.getParameter("rname");
		int raccountno = Integer.parseInt(request.getParameter("raccountno"));
		int ramt = Integer.parseInt(request.getParameter("ramt"));
		int password =Integer.parseInt(request.getParameter("password"));	
		if(password==Integer.parseInt(setget.getPassword()))
		{
			String query = "select balance from account where accountno = "+raccountno+"";
			try {
				
			PreparedStatement st;
			st = con.prepareStatement(query);
			ResultSet rs = st.executeQuery();
			rs.next();
			int obal = rs.getInt(1);
			int ubal = setget.getBalance();
			int acc = setget.getAccountno();
			ubal = ubal-ramt;
			obal = obal+ramt;
			query = "update account set balance="+ubal+" where accountno = "+acc+"";
			st = con.prepareStatement(query);
			st.executeUpdate();
			
      	   query = "update account set balance="+obal+" where accountno = "+raccountno+"";
			st = con.prepareStatement(query);
			st.executeUpdate();
			
			PrintWriter out=response.getWriter();
			out.println("Money Send Successfull");
			
			
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	
	
	
	
	
	
	
	
	
	
	
	
	}
	

}
