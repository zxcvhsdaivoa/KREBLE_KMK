<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="data" class="use_data.Database"/>
<%@ page import="use_data.CommunityData"%>
<%
	String comu_no = request.getParameter("no");
	String id = (String) session.getAttribute("ID");
	data.commu_delete(comu_no, id);
	response.sendRedirect("community_after.jsp?after=delete"); 
%>