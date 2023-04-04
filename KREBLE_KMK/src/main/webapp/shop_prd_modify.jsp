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
	
	
	
<title>제품수정페이지</title>
</head>
<body>
    <!-- header -->
  
	<jsp:include page="Header_baseform.jsp"/>
	
	<!-- section -->
  
	<section>
<!-- 		중앙정렬용 div -->
		<div id = "center_div">
			<!-- 제품정보 -->
			<article id="pd_detail_no1">
<!-- 				아티클 내 중앙정렬 -->
				<div id="no_table_center">
					<table style="border: 1px solid">
					<colgroup>
					<col style="width:200px">
					<col style="width:295px">
					<col style="width:200px">
					<col style="width:295px">
					</colgroup>
					<tr>
						<td colspan="2" rowspan="6">사진</td>
						<td>등록자 : </td>
						<td>아이디</td>
					</tr>
					<tr>
						<td>제품카테고리</td>
						<td>셀렉박스</td>
					</tr>
					<tr>
						<td>가격</td>
						<td>얼마임?</td>
					</tr>
					<tr>
						<td>사이즈</td>
						<td>알빠?</td>
					</tr>
					<tr>
						<td>등록일</td>
						<td>몇시?</td>
					</tr>
					<tr>
						<td>수량</td>
						<td>없다</td>
					</tr>
					<tr>
						<td>재질</td>
						<td>구려</td>
						<td>색상</td>
						<td>몰라</td>
					</tr>
					<tr>
						<td>제조사</td>
						<td>너</td>
						<td>품질보증기준</td>
						<td>몰라</td>
					</tr>
					<tr>
						<td>AS담당자</td>
						<td colspan="3">몰라</td>
					</tr>
					</table>
				</div>
			</article>
			
			<!-- 제품소개 및 사진 -->
			<article id="pd_detail_no2">
				<textarea placeholder="제품에 대한 상세정보를 입력해주세요" style="width:990px; height: 400px;"></textarea>
				
				<div style="width: 990px; height:40px; background-color: skyblue;">사진등록</div>
				<div style="width: 990px; height:40px; background-color: red">사진등록</div>
				<div style="width: 990px; height:40px; background-color: skyblue;">사진등록</div>
			</article>
			
			<!-- 구매/장바구니/상단버튼 -->
			<article id="pd_detail_no3">
				<div>
					<input type="submit" value="제품등록" />
					<input type="reset" value="다시입력" />
					<input type="button" value="목록으로 이동" />
				</div>
			</article>
			
			<!-- 여분 -->
			<article id="pd_detail_no4">
			</article>
	
		</div>
	</section>
	
    <!-- footer -->
    <jsp:include page="Footer_baseform.jsp"/>
</body>
</html>