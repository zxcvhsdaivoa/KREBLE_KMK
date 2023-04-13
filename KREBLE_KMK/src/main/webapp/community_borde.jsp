<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
				<jsp:useBean id="ud" class="use_data.Db_method_commu"/>
				<%@ page import="use_data.CommunityData"%>
				<%@ page import="java.util.ArrayList"%>
				<%
				String login_id = (String) session.getAttribute("ID");
				int comu_no = Integer.parseInt(request.getParameter("no"));
				int read_count = ud.getReadCount(comu_no);
				ud.updateReadCount(read_count, comu_no);
				CommunityData comu = ud.commu_one(comu_no);
				CommunityData next_board=null;
				next_board=ud.next_board(comu_no);
				CommunityData prev_board=null;
				prev_board=ud.prev_board(comu_no);
				
				%>
				<div class="community_inner">
					<div class="top_box">
						<span class="writer"><%= comu.getId()%></span>
						<span class="writing_time"><%= comu.getComu_date()%></span>
						<span class="category replace_cate">[<%= comu.getCategory()%>]</span>
						
					</div>
					<div class="content_box">
						<span class="title"><%= comu.getComu_title()%></span>
						<textarea class="write" readonly><%= comu.getComu_write()%></textarea>
					</div>
				
					<div class="btn_box">
						<a href="community.jsp?cate=all" class="btn btn_list"><span>목록</span></a>
					<%
					if(login_id == null) {
						
					}
					else if(comu.getId()==null){
						
					}
					else if(comu.getId().equals(login_id)){
						out.println("<a href='community_delete.jsp?no="+comu_no+"' class='btn btn_delete'><span>삭제하기</span></a>");
						out.println("<a href='community_change.jsp?no="+comu_no+"' class=' btn btn_change'><span>수정하기</span></a>");
					}
					%>
					</div>
			
			
					<table class="nextprev">
					<tr>
						<td>다음글</td>
						<td><%if(next_board.getComu_title()!=null){ %><a href="community_borde.jsp?no=<%= next_board.getComu_num()%>" class="btn_next"><%= next_board.getComu_title() %></a><%}else{ %>다음글이 없습니다<%} %><td>
					</tr>
					<tr>
						<td>이전글</td>
						<td><%if(prev_board.getComu_title()!=null){ %><a href="community_borde.jsp?no=<%= prev_board.getComu_num()%>" class="btn_prev"><%= prev_board.getComu_title() %></a><%}else{ %>이전글이 없습니다<%} %></td>
					<td>
					</table>
				</div>
			</div>
			
		</div>
	</section>
<jsp:include page="Footer_baseform.jsp"/>
</body>
</html>