<%@page import="java.util.HashMap"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDate"%>
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
	int endPage=pageInfo.getEndPage();
	
	String asdf ="all";
	if(request.getParameter("prd_cata")!=null&&request.getParameter("prd_cata")!="null"&&!request.getParameter("prd_cata").equals("null")){
	asdf= (String) request.getParameter("prd_cata");
	}
	%>
	<jsp:useBean id="cash" class="use_data.Db_method_user"></jsp:useBean>
	<jsp:useBean id="shop_m1" class="use_data.Db_method_shop" />
	<!-- 캐시호출/파워딜러/고객만족우수아이디 선별 -->
	<%
	int uc = cash.u_cash(id);
	String [] crs = shop_m1.rank_seller();
	String rankid1 = crs[0];
	String rankid2 = crs[1];
	String rankid3 = crs[2];
	%>
	
	<!-- 평점호출 -->
	<%
	HashMap<String, Integer> hssc = shop_m1.re_score();
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
		<article id="pl_art_no1"><!-- 페이지타이틀/카테고리 예정 -->
			<div>SHOPPING MALL
			<%
			if(id == null){
			}
			else
			{
			%>
				<input type="button" value = "상품등록하기" class="td_hide">
			<%
			}
			%>
				
			</div>
		</article>
		<article id="pl_art_no2"><!-- 품목 버튼 -->
			<div class="no2_center">
				<a href="shop_list_action.sp"><input type="button" value ="All" name = "all_button" /></a>
				<a href="shop_calist_action.sp?prd_cata=uni"><input type="button" value ="Uniform" name = "uni_button" <%if(asdf.equals("uni")){ %>class="select"<%} %>/></a>
				<a href="shop_calist_action.sp?prd_cata=sho"><input type="button" value ="shoes" name = "shoes_button" <%if(asdf.equals("sho")){ %>class="select"<%} %> /></a>
				<a href="shop_calist_action.sp?prd_cata=ball"><input type="button" value ="Ball" name = "ball_button" <%if(asdf.equals("ball")){ %>class="select"<%} %>/></a>
				<a href="shop_calist_action.sp?prd_cata=etc"><input type="button" value ="ETC" name = "etc_button" <%if(asdf.equals("etc")){ %>class="select"<%} %>/></a>
			</div>
		</article>
		<!-- 	사진 / 상품명 / 상품가격 / 색상 / 등록자	 -->
		<!-- 제품리스트 -->
		<article id="pl_art_no3">
			<div class="pl_no3_center">
				<table>
					<%
					/////////////////////사진경로///////////////////
					if(articleList != null && listCount > 0){
					for(int i=0;i<articleList.size();i++){
						String impath = "";
						String aa = articleList.get(i).getPrd_no();
						char p_no = aa.charAt(0);
						switch(p_no){
						case 's':
							impath = "image/shopimg/sue/";
							break;
						case 'u':
							impath = "image/shopimg/uni/";
							break;
						case 'b':
							impath = "image/shopimg/ball/";
							break;
						case 'e':
							impath = "image/shopimg/etc/";
							break;
						}
					%>
					<tr><!-- 1행 -->
						<!--사진 -->
						<td rowspan="4"><img class = "aa" alt="Image not uploaded" src="<%=impath+articleList.get(i).getPrd_no()%>.jpg"></td>
						<!-- 가격 -->
						<td colspan="3"><a href = "shop_prd_detail.sp?prd_no=<%=articleList.get(i).getPrd_no()%>&page=<%=nowPage%>"><input type="text" value="&#x20a9;<%=articleList.get(i).getPrd_price() %>" class="prd_priceC"  readonly name = "prd_price"></a></td>
						
						<!-- 등록일/(히든)현재페이지 -->
						<td><a href = "shop_prd_detail.sp?prd_no=<%=articleList.get(i).getPrd_no()%>&page=<%=nowPage%>"><input type="text" value="<%=articleList.get(i).getPrd_date() %>" class="s_id" readonly><input type="hidden" value="<%=nowPage %>" name="page"></a></td>
						<!-- 판매자아이디 -->
						<td rowspan="3" class = "bb">
						<!-- 우수판매자 -->
						<% String aid = articleList.get(i).getPrd_id(); %>
						<%
						if(aid.equals(rankid1)/*||aid.equals(rankid2)*/){
							%>
							<div class ="power_D"><img src="image/shopimg/bestseller.png">파워딜러</div>
							<div class="s_id">
							<%= aid %>
							</div>
							
						<%
						} else if(aid.equals(rankid3)){
						%>
							<div class= "cs_D"><img  src="image/shopimg/bestcs.png">고객만족우수 </div>
							<div class="s_id">
							<%= aid %>
							</div>
						<%} else {%>
						<div class= "se_D">판매자 </div>
						<div class="s_id">
						<%= aid %>
						</div>
						<%}%>
						<!-- 오늘날자로부터 최대 2일 내 도착예정 -->
						<%
						LocalDate now = LocalDate.now();
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d");
						String formattedDate = now.format(formatter);
						LocalDate date;
						   int num = i%3;
						   if (num == 0) {
						     date = now;
						   } else if (num == 1) {
						     date = now.plusDays(1);
						   } else {
						     date = now.minusDays(1);
						   }
						   String dateString = date.format(formatter);
						%>
						<div class= "date_A">~ <%=dateString%> 내 도착예정</div>
						</td>
					</tr>
					
					<tr><!-- 2행 -->
						<!-- 색상 -->
						<td colspan="4" class="td_le_b td_ri_b"><a href = "shop_prd_detail.sp?prd_no=<%=articleList.get(i).getPrd_no()%>&page=<%=nowPage%>"><input type="text" value="<%=articleList.get(i).getPrd_color() %>"  readonly name = "prd_color"></a></td>
					</tr>
					
					<tr><!-- 3행 -->
						<td colspan="4" class="td_le_b td_ri_b"></td>
					</tr>
					
					<tr><!-- 4행 -->
					</tr>
					<tr>
					<!-- 상품명 -->
					<td class="td_bo_b"><a href = "shop_prd_detail.sp?prd_no=<%=articleList.get(i).getPrd_no()%>&page=<%=nowPage%>">
					<input type="text" class="prd_title" value="<%=articleList.get(i).getPrd_name() %>" readonly name = "prd_name">
					</a></td>
					<!-- 별점 -->
					<td colspan="3" class="td_bo_b">
					
					</td>
					<!-- 관심상품 -->
					<td class="td_bo_b"><input type="button" value="관심상품" onclick="likethis()">
					<input type="hidden" value="<%= id %>" name="prd_re_id">
					</td>
					
						<!-- 장바구니 로그인시 보임 -->
						<%
						if(id == null){
						%>
						<td></td>
						<%	
						}else{
						%>
						<td><a href="shop_bak.sp?prd_no=<%=articleList.get(i).getPrd_no()%>&b_id=<%=id%>&page=<%=nowPage%>"><input type="button" value="장바구니"></a></td>
						<%
						}
						%>
					</tr>
					<%} %><!-- for 문 종료 -->
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
				<span>[<%=a%>]</span>&nbsp;
				<%}else{ %>
				<a href="<%=prd_cata %><%=a %>">[<%=a %>]</a>&nbsp;
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
</body>
</html>