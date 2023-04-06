<%@page import="javax.websocket.Session"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="use_data.Shop_prd" %>
<%@ page import="java.util.ArrayList" %>

<% request.setCharacterEncoding("utf-8"); %>
<%	String id = (String) session.getAttribute("ID");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="css/Header_Footer_Aside_baseform.css">
	<link rel="stylesheet" type="text/css" href="css/shop_prd_list.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
	<script type="text/javascript" src="slick/slick.min.js"></script>
	<script src="js/Header_Footer_Aside_baseform.js"></script>
	
<title>제품리스트</title>
</head>
<body>
    <!-- header -->
  
	<jsp:include page="Header_baseform.jsp"/>
	<jsp:useBean id="sp_list" class="use_data.Database"></jsp:useBean>
	<%
	ArrayList<Shop_prd> al = new ArrayList<Shop_prd>();
	al = sp_list.shop_prd_list();
	%>
	<!-- section -->
  
	<section>
	<div id="section_inner"> <!-- 내용 중앙정렬용 -->
	<form>
<!-- 		셀렉문을 여기에 호출? -->
<!-- 			use_date.loadboard(); -->

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
				<div class = "pr_label">금액대별 제품 보기</div>
				<div class = "pr_radio">
					<input type="radio" value="30000" name = "price" />~\30,000
					<input type="radio" value="60000" name = "price" />~\60,000
					<input type="radio" value="90000" name = "price" />~\90,000
					<input type="radio" value="120000" name = "price" />~\120,000
					<input type="radio" value="120001" name = "price" />\120,000~
				</div>
			</div>
		</article>
		<!-- 	사진 / 상품명 / 상품가격 / 색상 / 등록자	 -->
		<!-- 제품리스트 -->
		<article id="pl_art_no3">
			<div class="pl_no3_center">
				<table border="1">
					<colgroup>
						<col style ="width: 90px">
						<col style ="width: 120px">
						<col style ="width: 460px">
						<col style ="width: 110px">
						<col style ="width: 100px">
						<col style ="width: 100px">
						<col style ="width: 120px">
					</colgroup>
					<tr id = "tr_cr">
						<td>카테고리</td>
						<td>사진</td>
						<td>상품명</td>
						<td>상품가격</td>
						<td>색상</td>
						<td>등록자</td>
						<td>작성일</td>
					</tr>
				</table>
			</div>
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