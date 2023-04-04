<%@page import="javax.websocket.Session"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.ArrayList" %>

<% request.setCharacterEncoding("utf-8"); %>
<% String id = (String) session.getAttribute("ID"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="css/Header_Footer_Aside_baseform.css">
	<link rel="stylesheet" type="text/css" href="css/shop_prd_detail.css">
	<link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css2?family=Gothic+A1:wght@500&family=Jua&display=swap" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css2?family=Gothic+A1:wght@500&family=Jua&family=Nanum+Myeongjo:wght@800&display=swap" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css2?family=Cute+Font&display=swap" rel="stylesheet">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
	<script type="text/javascript" src="slick/slick.min.js"></script>
	<script src="js/Header_Footer_Aside_baseform.js"></script>
	
	
	
<title>제품상세페이지</title>
</head>
<body>
    <!-- header -->
  
	<jsp:include page="Header_baseform.jsp"/>
	
	<!-- section -->
  
	<section>
		<!-- 제품정보 -->
		<article id="pd_detail_no1">
			<div>제품사진</div>
			<div>제품정보</div>
		</article>
		
		<!-- 제품소개 및 사진 -->
		<article id="pd_detail_no2">
			<div>제품소개 및 사진</div>
		</article>
		
		<!-- 구매/장바구니/상단버튼 -->
		<article id="pd_detail_no3">
			<div>구매</div>
			<div>장바구니</div>
			<div>상단으로이동</div>
		</article>
		
		<!-- 리뷰 -->
		<article id="pd_detail_no4">
			<div>(리뷰)이제품 참 좋네 1점</div>
			<div>(리뷰)이제품 왜씀 1점</div>
			<div>(리뷰)아 ㅅㅂ 1점이 최하점이야 1점</div>			
		</article>
		
		<!-- 여분 -->
		<article id="pd_detail_no5">
		</article>
	
	
	</section>
	
    <!-- footer -->
    <jsp:include page="Footer_baseform.jsp"/>
</body>
</html>