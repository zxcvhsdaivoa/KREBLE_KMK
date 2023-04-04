<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<%@page import="java.sql.*"%>
<%@ page import="java.util.ArrayList" %>
<%
	ArrayList<String> idList = new ArrayList<String>();
	Connection con = null;
	Statement stm = null;
	try{
		Class.forName("com.mysql.jdbc.Driver");
		con= DriverManager.getConnection("jdbc:mysql://localhost:3306/loginpage","root","knight");
		if(con == null){
			throw new Exception("데이터베이스에 연결할 수 없습니다.");
		}
		stm=con.createStatement();
		ResultSet rs= stm.executeQuery("select * from user;");
		while(rs.next()){
			idList.add(rs.getString("address"));
		}
	}finally {
		try{
			stm.close();
		}catch(Exception ignored){

		}
		try{
			con.close();
		}catch(Exception ignored){

		}
	}
	// RequestDispatcher dp = request.getRequestDispatcher("login.jsp");
	// dp.forward(request, response);
%>
<%
out.println(idList+"<br>");



%>