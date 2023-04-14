<%@page import="vo.PageInfo"%>
<%@page import="javax.websocket.Session"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="use_data.Shop_prd" %>
<%@ page import="java.util.ArrayList" %>

<%	request.setCharacterEncoding("utf-8"); %>
<%	String id = (String) session.getAttribute("ID");
	ArrayList<Shop_prd> articleList =(ArrayList<Shop_prd>) request.getAttribute("articleList");
	PageInfo pageInfo = (PageInfo) request.getAttribute("pageInfo");
	int listCount=pageInfo.getListCount();
	int nowPage=pageInfo.getPage();
	int maxPage=pageInfo.getMaxPage();
	int startPage=pageInfo.getStartPage();
	int endPage=pageInfo.getEndPage();%>
	<jsp:useBean id="cash" class="use_data.Db_method_user"></jsp:useBean>
	<%
	int uc = cash.u_cash(id);
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="css/Header_Footer_Aside_baseform.css">
	<link rel="stylesheet" type="text/css" href="css/shop_prd_list.css">
    <link rel="stylesheet" href="css/colorbox.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
	<script type="text/javascript" src="slick/slick.min.js"></script>
	<script src="js/Header_Footer_Aside_baseform.js"></script>
	<script src="js/shop_prd_list.js"></script>
	<script src="js/jquery.colorbox-min.js"></script>
	
	
<title>제품리스트</title>
</head>
<body>
    <!-- header -->
  
	<jsp:include page="Header_baseform.jsp"/>
	<!-- section -->
  
	<section>
	<div id="section_inner"> <!-- 내용 중앙정렬용 -->
	<form>
<!-- 		셀렉문을 여기에 호출? -->
<!-- 			use_date.loadboard(); -->

		<article id="pl_art_no1"><!-- 페이지타이틀/카테고리 예정 -->
			<div>SHOPPING MALL
			<%
			if(id == null){
			}
			else
			{
			%>
				<input type="button" value = "상품등록하기">
			<%
			}
			%>
				
			</div>
		</article>
		<article id="pl_art_no2"><!-- 품목 버튼 -->
			<div class="no2_center">
				<a href="shop_list_action.sp"><input type="button" value ="All" name = "all_button" /></a>
				<a href="shop_calist_action.sp?prd_cata=uni"><input type="button" value ="Uniform" name = "uni_button" /></a>
				<a href="shop_calist_action.sp?prd_cata=sho"><input type="button" value ="shoes" name = "shoes_button" /></a>
				<a href="shop_calist_action.sp?prd_cata=ball"><input type="button" value ="Ball" name = "ball_button" /></a>
				<a href="shop_calist_action.sp?prd_cata=etc"><input type="button" value ="ETC" name = "etc_button" /></a>
			</div>
		</article>
		<!-- 	사진 / 상품명 / 상품가격 / 색상 / 등록자	 -->
		<!-- 제품리스트 -->
		<article id="pl_art_no3">
			<div class="pl_no3_center">
		<table>
			<%
			if(articleList != null && listCount > 0){
			%>

			<tr id="tr_top">
				<td class ="td_hide">번호</td>
				<td>사진</td>
				<td>상품명</td>
				<td>가격</td>
				<td>색상</td>
				<td>등록자</td>
				<td>등록일</td>
				<td>비고 </td>
			</tr>

			<%
			for(int i=0;i<articleList.size();i++){
			%>
			<tr>
				<td><input type="text" value="<%=articleList.get(i).getPrd_img() %>" class="w149" readonly name = "prd_img"></td>
				<td><a href = "shop_prd_detail.sp?prd_no=<%=articleList.get(i).getPrd_no()%>&page=<%=nowPage%>"><input type="text" value="<%=articleList.get(i).getPrd_name() %>" class="w396" readonly name = "prd_name"></a></td>
				<td><input type="text" value="<%=articleList.get(i).getPrd_price() %>" class="w99" readonly name = "prd_price"></td>
				<td><input type="text" value="<%=articleList.get(i).getPrd_color() %>" class="w99" readonly name = "prd_color"></td>
				<td><input type="text" value="<%=articleList.get(i).getPrd_id() %>" class="w149" readonly name="prd_id"><input type="hidden" value="<%=id %>" name="prd_re_id"></td>
				<td><input type="text" value="<%=articleList.get(i).getPrd_date() %>" class="w99" readonly><input type="hidden" value="<%=nowPage %>" name="page"></td>
				
				<%
				if(id == null){
				%>
					<td></td>
				<%	
				}else{
				%>
				<td class="w99"><a href="shop_bak.sp?prd_no=<%=articleList.get(i).getPrd_no()%>&b_id=<%=id%>&page=<%=nowPage%>"><input type="button" value="장바구니담기"></a></td>
				<%
				}
				%>
			</tr>
			<%} %>
		</table>
			</div>
		</article>
		<%
		String prd_cata="";
		if(request.getParameter("prd_cata")==null||request.getParameter("prd_cata")==""){
			prd_cata="shop_list_action.sp?page=";
		}else{
			prd_cata="shop_calist_action.sp?prd_cata="+request.getParameter("prd_cata")+"&page=";
		}
			
		
		%>
		<!-- 페이지 이전/다음 넘김 -->
		<article id="pl_art_no5">
				<%if(nowPage<=1){ %>
				[이전]&nbsp;
				<%}else{ %>
			<a href="<%=prd_cata %><%=nowPage-1%>">[이전]</a>&nbsp;
				<%} %>
		
				<%for(int a=startPage;a<=endPage;a++){
						if(a==nowPage){%>
				[<%=a %>]
				<%}else{ %>
			<a href="<%=prd_cata %><%=a %>">[<%=a %>]
			</a>&nbsp;
				<%} %>
				<%} %>
		
				<%if(nowPage>=maxPage){ %>
				[다음]
				<%}else{ %>
			<a href="<%=prd_cata %><%=nowPage+1 %>">[다음]</a>
				<%} %>
		</article>
				<%
			    }
				else
				{
				%>
		<article id="emptyArea">
			<div>
				등록된 글이 없습니다.
			</div>
		</article>
				<%
				}
				%>
	
		
	</form>
	</div>
	</section>
	
    <!-- footer -->
    <jsp:include page="Footer_baseform.jsp"/>
</body>
</html>