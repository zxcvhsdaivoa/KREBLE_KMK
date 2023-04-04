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
	<link rel="stylesheet" type="text/css" href="css/shop_prd_list.css">
	<link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css2?family=Gothic+A1:wght@500&family=Jua&display=swap" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css2?family=Gothic+A1:wght@500&family=Jua&family=Nanum+Myeongjo:wght@800&display=swap" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css2?family=Cute+Font&display=swap" rel="stylesheet">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
	<script type="text/javascript" src="slick/slick.min.js"></script>
	<script src="js/Header_Footer_Aside_baseform.js"></script>
	
	
	
<title>제품리스트</title>
</head>
<body>
    <!-- header -->
  
	<jsp:include page="Header_baseform.jsp"/>
	
	<!-- section -->
  
	<section>
	<div id="section_inner"> <!-- 내용 중앙정렬용 -->
	<form>
		
		<article id="pl_art_no1"><!-- 페이지타이틀/카테고리 예정 -->
			<div>(가제)KREBLE SHOP</div>
		</article>
		<article id="pl_art_no2"><!-- 품목 버튼 -->
			<div class="no2_center">
				<input type="button" value ="All" name = "all_button" />
				<input type="button" value ="Uniform" name = "uni_button" />
				<input type="button" value ="shoes" name = "shoes_button" />
				<input type="button" value ="Ball" name = "ball_button" />
				<input type="button" value ="ETC" name = "etc_button" />
			</div>
			<div>
				<div>금액대별 제품 보기</div>
				<div>
					<input type="radio" value="30000" name = "price" />~\30,000
					<input type="radio" value="60000" name = "price" />~\60,000
					<input type="radio" value="90000" name = "price" />~\90,000
					<input type="radio" value="120000" name = "price" />~\120,000
					<input type="radio" value="120001" name = "price" />\120,000~
				</div>
			</div>
		</article>
		
		<!-- 제품리스트 -->
		<article id="pl_art_no3">
			<div> 제품리스트</div>
		</article>
		
		
		<!-- 뭐...기타버튼들 모아두는걸로할까? -->
		<article id="pl_art_no4">
			<div> 상단으로</div>
		</article>
	
		
		<!-- 혹시 몰라 여분 -->
		<article id="pl_art_no5">
		</article>
	</form>
	</div>
	</section>
	
    <!-- footer -->
    <jsp:include page="Footer_baseform.jsp"/>
</body>
</html>