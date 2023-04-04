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
	<link rel="stylesheet" type="text/css" href="css/shop_prd_bak.css">
	<link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css2?family=Gothic+A1:wght@500&family=Jua&display=swap" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css2?family=Gothic+A1:wght@500&family=Jua&family=Nanum+Myeongjo:wght@800&display=swap" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css2?family=Cute+Font&display=swap" rel="stylesheet">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
	<script type="text/javascript" src="slick/slick.min.js"></script>
	<script src="js/Header_Footer_Aside_baseform.js"></script>
	
	
	
<title>장바구니</title>
</head>
<body>
    <!-- header -->
  
	<jsp:include page="Header_baseform.jsp"/>
	
	<!-- section -->
  
	<section>
		<div>
		<form>
		<article id="sb_art_no1"><!--아이디 / 보유캐시 타이틀 -->
			<div id="sb_subtitle">
				<div class="sb_subt1">장바구니 </div>
				<div class="sb_subt2"> <%=id %> 님의 보유 캐시는 xxxxx입니다.</div>
			</div>
		</article>
		<article id="sb_art_no2"><!-- 장바구니 리스트 -->
			<div class="no2_center"><!-- 장바구니 TH -->
				<input type="button" value ="제품 이미지" /> 
				<input type="button" value ="제품명" name = "prd_name" />
				<input type="button" value ="제품가격" name = "prd_price" />
				<input type="button" value ="제품수량" name = "prd_qunt" />
				<input type="button" value ="합계" name = "total" />
				<input type="button" value ="비고" /> 
			</div>
			
			<div><!-- 장바구니 TD -->
				사진 제품명 제품수량 제품가격 합계	삭제/제품보기
			</div>
		</article>
		<!-- 총금액 -->
		<article id="sb_art_no3">
			<div>총금액 / 구매하기 버튼 / 상단이동버튼(필요없을지도 모르곘네)</div>
		</article>	
	
		<!-- 여분 -->
		<article id="sb_art_no4">
		</article>	
	
		<!-- 여분 -->
		<article id="sb_art_no5">
		</article>
	</form>
	</div>
	</section>
	
    <!-- footer -->
    <jsp:include page="Footer_baseform.jsp"/>
</body>
</html>