package com.functionality;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jdbcdemo.DataConnection;

/**
 * Servlet implementation class Withdrawl
 */
public class Withdrawl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Withdrawl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		Connection con = DataConnection.connect();
		int wamount = Integer.parseInt(request.getParameter("wamount"));
		int password = Integer.parseInt(request.getParameter("password"));
		System.out.println(wamount);
		if(password==Integer.parseInt(setget.getPassword()))
		{	try {
			System.out.println(wamount+" "+password);
			int accountno = setget.getAccountno();
			int balance = setget.getBalance();
			
			balance = balance-wamount;
			if(balance>=0)
			{
				String query = "update account set balance = ? where accountno = ?";
				
				PreparedStatement st = con.prepareStatement(query);
				st.setInt(1,balance);
				st.setInt(2,accountno);
				st.executeUpdate();
				System.out.println(balance+" Successfully deposited to bank account "+accountno);
				setget.setBalance(balance);
				PrintWriter out=response.getWriter();
				out.println("Withdrawl Successfull");
			}
			else
			{
				PrintWriter out=response.getWriter();
				out.println("Insufficient Balance	");
				System.out.println("Insufficient Balance");
			}
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
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
