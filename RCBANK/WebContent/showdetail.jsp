<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.jdbcdemo.DataConnection" %>
<%@ page import="java.sql.*" %>
<%@ page import="com.functionality.setget" %>

<html>
<head>
<link rel="stylesheet" href="./styles.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Account Detail</title>
<style>
  .form-label {
  	padding:15px;
    font-weight: bold;
    font-size: 16px;
    margin-bottom: 5px;
  }

  .form-value {
    font-size: 16px;
    margin-bottom: 15px;
  }
</style>
</head>
<body>
  <div class="container">
    <div class="left">
      <div class="header">
        <h1 class="head"></h1>
        <header>
          <img src="./images/logo.png" alt="RC Bank Logo">
        </header>        
        <h2 class="animation a1">Account Detail</h2>
        <h4 class="animation a2">Your Details are - </h4>
      </div>
      <form action="Signin">
      <div class="form">
        <% 
        String name = setget.getName();
        String username = setget.getUsername();
        int accountno = setget.getAccountno();
        String password  = setget.getPassword();
		int balance = setget.getBalance();
		
         %>
        <label for="name" class="form-label animation a3 name">Name:  <%= name %></label>
        <label for="username" class="form-label animation a3 username">Username:  <%=  username %></label>
        <label for="accountno" class="form-label animation a3 accountno">Account number:  <%=  accountno %></label>
        <label for="password" class="form-label animation a4 password">Account Password:  <%=  password  %></label>
 		
      </div>
      </form>
    </div>
    <div class="right"></div>
  </div>
</body>
</html>
