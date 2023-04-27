<%@page import="javax.websocket.Session"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="use_data.Shop_prd"%>

<% request.setCharacterEncoding("utf-8"); %>
<% 
String id = (String) session.getAttribute("ID"); 
%>
	<jsp:useBean id="cash" class="use_data.Db_method_user"></jsp:useBean>
	<%
	int uc = cash.u_cash(id);
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="css/Header_Footer_Aside_baseform.css">
	<link rel="stylesheet" type="text/css" href="css/user_mypage.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
	<script type="text/javascript" src="slick/slick.min.js"></script>
	<script src="js/Header_Footer_Aside_baseform.js"></script>
	<script src="js/user_mypage.js"></script>
	<%
	Shop_prd aa = (Shop_prd)request.getAttribute("article");//유저로 바꿔야됨
    String nowPage = (String)request.getAttribute("page");
	%>
	
<title>MyPage</title>
</head>
<body>
		
    <!-- header -->
	<jsp:include page="Header_baseform.jsp"/>

	<!-- section -->
	<section>
		<!-- 활동현황/보유캐쉬 -->
		<article>
			MY KREBLE / My Squad 갯수 / 경기장 대여 현황 / 관심목록,장바구니 현황 / 보유캐쉬
		</article>
		
		<!-- 프로필사진 / 닉네임 / 마이스쿼드 -->
		<article>
			<div>
				<div> 프로필사진 / 사진수정 </div>
				<div> 닉네임 / 닉네임수정수정 </div>
			</div>
			<div> 
				<div> ID 님 환영합니다. </div>
				<div> My Squad / 선수사진 12 </div>
			</div>
		</article>
		
		<!-- 경기장 렌트 -->
		<article>
			경기장 대여 현황 라벨
			경기장 대여 리스트
		</article>
		
		<!-- 관심상품 -->
		<article>
			관심품목 라벨
			관심품목 리스트
		</article>
		
		<article>
			프로필 수정 버튼 / 탈퇴버튼
		</article>
		
	</section>
	
    <!-- footer -->
    <jsp:include page="Footer_baseform.jsp"/>
</body>
</html>