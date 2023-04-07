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
				int last_no = ud.commu_last();
				CommunityData comu = ud.commu_one(comu_no);
				if(comu_no<1){
					%>
					<script>
						alert("이전 페이지가 없습니다");
						location.href = "community_borde.jsp?no=1&go=next";
					</script>
					<%
				}
				if(comu_no>last_no){
					%>
					<script>
						alert("다음 페이지가 없습니다");
						location.href = "community_borde.jsp?no="+<%= last_no%>+"&go=next";
					</script>
					<%
				}
				if(comu.getId() == null) {
					String go = request.getParameter("go");
					if(go.equals("next")){
						%>
						<script>
							location.href = "community_borde.jsp?no="+<%=comu_no+1%>+"&go=next";
						</script>
						<%
					}
					else if(go.equals("prev")){
						%>
						<script>
							location.href = "community_borde.jsp?no="+<%=comu_no-1%>+"&go=prev";
						</script>
						<%
					}
				}
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
				
					<%
					if(login_id == null) {
						
					}
					else if(comu.getId()==null){
						
					}
					else if(comu.getId().equals(login_id)){
						out.println("<div class='writer_box'><a href='community_change.jsp?no="+comu_no+"' class='btn_change'><span>수정하기</span></a>");
						out.println("<a href='community_delete.jsp?no="+comu_no+"' class='btn_delete'><span>삭제하기</span></a></div>");
					}
					%>
					<div class="list_box">
						<a href="community_borde.jsp?no=<%= comu_no-1%>&go=prev" class="btn btn_prev"><span>이전글</span></a>
						<a href="community.jsp?cate=all" class="btn btn_list"><span>목록</span></a>
						<a href="community_borde.jsp?no=<%= comu_no+1%>&go=next" class="btn btn_next"><span>다음글</span></a>
					</div>
			
				</div>
			</div>
			
		</div>
	</section>
<jsp:include page="Footer_baseform.jsp"/>
</body>
</html>