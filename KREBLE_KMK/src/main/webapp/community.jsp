<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>유저 커뮤니티</title>
	<link rel="stylesheet" type="text/css" href="css/Header_Footer_Aside_baseform.css">
	<link rel="stylesheet" type="text/css" href="css/community.css">
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<script src="js/Header_Footer_Aside_baseform.js"></script>
<script src="js/community.js"></script>

<body>
<jsp:include page="Header_baseform.jsp"/>
	<section>
		<div class="section_inner">
			
			<div class="community">
				<div class="community_header">
					<h3>유저커뮤니티</h3><br>
					<span>전체게시판</span>
				</div>
				<div class="community_inner">
					<jsp:useBean id="ud" class="use_data.Database"/>
			
				    <%@ page import="use_data.CommunityData"%>
				    <%@ page import="java.util.ArrayList"%>
				    <%String cate = request.getParameter("cate"); %>
				    <div class="top_wrap">
						<span class="btn btn_write"><a href="community_check.jsp?do=ck">글쓰기</a></span>
						<ul class="cate">
							<li><a href="community.jsp?cate=all">전체</a></li>
							<li><a href="community.jsp?cate=free">자유</a></li>
							<li><a href="community.jsp?cate=debate">토론</a></li>
							<li><a href="community.jsp?cate=qna">질문</a></li>
							<li><a href="community.jsp?cate=info">정보</a></li>
						</ul>
				    </div>
				    <table>
					    <tr class="bg1">
					    	<th class="head1">글번호</th>
					    	<th class="head2">작성자</th>
					    	<th class="head2">카테고리</th>
					    	<th class="head3">제목</th>
					    	<th class="head5">조회수</th>
					    	<th class="head5">작성일</th>
					    </tr>
					    <tbody class="style2">
						<%
						ArrayList<CommunityData> comu;
						Date now = new Date();
						SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					    String search = request.getParameter("search_select");
						if(search==null){
						    search ="";
						}
						String search_text = request.getParameter("search_text");
						if(search==""){
							if(cate.equals("all")){
								comu = ud.commu_all();
							}
							else {
								comu = ud.commu_cate(cate);
							}
						}
						else {
							comu = ud.commu_search(search, search_text);
							
						}
						for(int i=0; i<comu.size(); i++){					
							out.println("<tr class='bt_border'><td>"+comu.get(i).getComu_num()+"</td>");
							out.println("<td>"+comu.get(i).getId()+"</td>");
							out.println("<td class='replace_cate'>"+comu.get(i).getCategory()+"</td>");
							out.println("<td><a href='community_borde.jsp?no="+comu.get(i).getComu_num()+"'>"+comu.get(i).getComu_title()+"</a></td>");
							out.println("<td>"+comu.get(i).getCount()+"</td>");
							String wdt;
							String writedate = comu.get(i).getComu_date();
							Date wd = fm.parse(writedate);
							long diff = now.getTime() - wd.getTime();
							int daysDiff = (int) (diff / (24 * 60 * 60 * 1000));
							SimpleDateFormat simpleDateFormat;
							if(daysDiff<2){
								simpleDateFormat = new SimpleDateFormat("HH:mm"); 
							}
							else {
								simpleDateFormat = new SimpleDateFormat("MM-dd"); 
							}
							String strNowDate = simpleDateFormat.format(wd); 
							out.println("<td>"+strNowDate +"</td>");
						}
						%>
						</tbody>
					</table>
					<div class="search_box">
						<form name="search" action="community.jsp?cate=<%= cate%>">
							<input type="hidden" name="cate" value="all">
							<select name="search_select" id="search_select" class="search_select">
								<option value="search_title" <% if(search.equals("search_title")){%>selected="selected"<%}%>>제목</option>
								<option value="search_title_write" <% if(search.equals("search_title_write")){%>selected="selected"<%}%>>제목+내용</option>
						    	<option value="search_name" <% if(search.equals("search_name")){%>selected="selected"<%}%>>작성자</option>
							</select>
							<input type="text" name="search_text" class="search_text" <% if(search_text!=null){%>value="<%= search_text%>"<%}%>>
							<input type="submit" value="검색" class="btn_search" >
						</form>
					</div>
				</div>
				
			</div>
		</div>
			
			
	</section>
<jsp:include page="Footer_baseform.jsp"/>
</body>
</html>