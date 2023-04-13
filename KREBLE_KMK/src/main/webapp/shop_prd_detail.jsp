<%@page import="javax.websocket.Session"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="use_data.Shop_prd"%>

<% request.setCharacterEncoding("utf-8"); %>
<% String id = (String) session.getAttribute("ID"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="css/Header_Footer_Aside_baseform.css">
	<link rel="stylesheet" type="text/css" href="css/shop_prd_detail.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
	<script type="text/javascript" src="slick/slick.min.js"></script>
	<script src="js/Header_Footer_Aside_baseform.js"></script>
	<script src="js/shop_prd_detail.js"></script>
	<jsp:useBean id="sp_de" class="use_data.Db_method_shop"></jsp:useBean>
	<%
	Shop_prd aa = (Shop_prd)request.getAttribute("article");
    String nowPage = (String)request.getAttribute("page");
	ArrayList<Shop_prd> spr = sp_de.shop_prde_reply(aa.getPrd_no());
	%>
	
<title>제품상세페이지</title>
</head>
<body>
			
    <!-- header -->
  
	<jsp:include page="Header_baseform.jsp"/>
	
	<!-- section -->
  
	<section>
	<form action="prd_re_insert.sp?page=<%=nowPage %>" method="post">
	<input type="hidden" name="prd_no" value="<%=aa.getPrd_no()%>">
		<!-- 제품정보 -->
		<article id="pd_detail_no1">
			<div class = "no1_img_info1"><!-- 상품사진 및 필수정보 -->
				<div class="info1_img"><!-- 상품사진 width 400 x 300-->
					<span><!-- 큰사진(호버에서 나오는 사진) -->
						<%=aa.getPrd_img()%>300x250 image
					</span>
					<span><!-- 작은사진(호버용) -->
						<span><%=aa.getPrd_img() %> 100x30 image</span>
						<span><%=aa.getPrd_img() %> 100x30 image</span>
					</span>
				</div>
				<div class="info1_info1"><!-- 필수정보 -->
					<table>
					<colgroup>
						<col style = "width: 150px;">
						<col style = "width: 400px;">
					</colgroup>
						<tr>
						<td>상품이름</td>
						<td><%=aa.getPrd_name() %></td>
						</tr>
						
						<tr>
						<td>등록자</td>
						<td><%=aa.getPrd_id() %></td>
						</tr>
						
						<tr>
						<td>제품 종류</td>
						<td><%=aa.getPrd_cata() %></td>
						</tr>
						
						<tr>
						<td>가격</td>
						<td><%=aa.getPrd_price() %></td>
						</tr>
						
						<tr>
						<td>사이즈</td>
						<td><%=aa.getPrd_size() %></td>
						</tr>
						
						<tr>
						<td>등록일</td>
						<td><%=aa.getPrd_date() %></td>
						</tr>
						
						<tr>
						<td>남은 수량</td>
						<td><%=aa.getPrd_qant() %></td>
						</tr>
						
					</table>
				</div>
			</div>
			<div class="no1_img_info2"><!-- 추가정보 -->
				<table>
					<colgroup>
						<col style = "width: 150px;">
						<col style = "width: 800px;">
					</colgroup>
					<tr>
						<td>재질</td>
						<td><%=aa.getPrd_meter() %></td>
					</tr>
					<tr>
						<td>색상</td>
						<td><%=aa.getPrd_color() %></td>
					</tr>
					<tr>
						<td>제조사</td>
						<td><%=aa.getPrd_create() %></td>
					</tr>
					<tr>
						<td>품질검사</td>
						<td><%=aa.getPrd_qaul() %></td>
					</tr>
					<tr>
						<td>AS연락처</td>
						<td><%=aa.getPrd_as() %></td>
					</tr>
				</table>
			</div>
		</article>
		
		<!-- 제품소개 및 사진 -->
		<article id="pd_detail_no2">
			<div>
				<input type="text" value="<%=aa.getPrd_note() %>" readonly>
				<textarea readonly><%=aa.getPrd_content() %></textarea>
			</div>
		</article>
		
		<!-- 수정/삭제/리뷰 -->
		<%
		if(aa.getPrd_id().equals(id)){
		%>
			
			<article id="pd_detail_no3">
				<div class="pd_bt">
					<a href = "shop_mody_form.sp?prd_no=<%=aa.getPrd_no()%>&page=<%=nowPage%>">
						<input type="button" value="수정">
					</a>
					<a href = "Prd_delete_action.sp?prd_no=<%=aa.getPrd_no()%>&page=<%=nowPage%>">
						<input type="button" value="삭제">
					</a>
					<input type="button" value="목록">				
				</div>
			</article>
		<%
		}else{
		%>
			<article id="pd_detail_no3">
				<div class="pd_review_ti">
					<input type="button" value="구매">
					<input type="button" value="장바구니">
					<input type="button" value="목록">	
				</div>
			</article>
		<%
		}
		%>
		
		
		<!-- 리뷰 -->
		<article id="pd_detail_no4">
			<div>
				<table>
					<colgroup>
					<col style="width:110px" />
					<col style="width:80px" />
					<col style="width:620px" />
					<col style="width:160px" />
					</colgroup>
					<tr>
					<td colspan="4">&#x203B;댓글은 최근 순으로 5개만 표기됩니다.</td>
					</tr>
					<tr class = "re_title">
					<td>작성자</td>
					<td>평점</td>
					<td>내용</td>
					<td>삭제</td>
					</tr>
					<%
					int i = spr.size();
					int cnt = 0;
					for (i = i-1; cnt < 5; i = i-1) {
					    out.println("<tr>");
					    out.println("<td>"+spr.get(i).getPrd_re_id()+"</td>");
					    out.println("<td>"+spr.get(i).getPrd_re_sc()+"</td>");
					    out.println("<td>"+spr.get(i).getPrd_re_text()+"</td>");
					    
					    if(spr.get(i).getPrd_re_id().equals(id)){
					    	out.println("<td><a href='shop_re_del.sp?re_no="+spr.get(i).getPrd_re_num()+"&prd_no="+aa.getPrd_no()+"'><input type='button' class='del_check' value='댓글삭제'></a></td>");
					    }else{
					    	out.println("<td></td>");	
					    }
					    
					    out.println("</tr>");
					    cnt++;
					}
					%>
				</table>		
			</div>
		</article>		
		
		
		<!-- 댓글작성 -->
		<article id="pd_detail_no5">
		<div>
			<div>
				<p>작성자 : </p>
				<input type="text" value="<%= id %>" readonly name="prd_re_id">
				<p>평점 : </p>
				<input type="number" name="prd_re_sc" min="1" max ="10">
			</div>
			<div>
				<p>내용 : </p>
				<textarea name="prd_re_text"></textarea>
				<input type="hidden" name="prd_no" value="<%=aa.getPrd_no()%>">
				<input type="submit" value="등록">
			</div>
		</div>
		</article>
		
	</form>	
	</section>
	
    <!-- footer -->
    <jsp:include page="Footer_baseform.jsp"/>
</body>
</html>