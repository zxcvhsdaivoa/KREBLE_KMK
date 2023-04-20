<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="vo.SquadInfo"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나만의 스쿼드 목록</title>
	<link rel="stylesheet" type="text/css" href="css/Header_Footer_Aside_baseform.css">
	<link href="css/squad_style.css" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<script src="js/Header_Footer_Aside_baseform.js"></script>
<body>
  <jsp:include page="Header_baseform.jsp"/>
	<section>
		<div class="section_inner">
			<div class="squad_list">
			
				<%
				//paging
				int listCount=0;
				int page_no=1;
				int limit=15;
				if(request.getParameter("page")!=null){
					page_no=Integer.parseInt(request.getParameter("page"));
				}
				
				
				ArrayList<SquadInfo> allList =null; 
				allList = (ArrayList<SquadInfo>) request.getAttribute("allList");
				listCount =(int) request.getAttribute("count");
				
				//paging2
		   		int maxPage=(int)((double)listCount/limit+0.95); 
		   		int startPage = (((int) ((double)page_no / 10 + 0.9)) - 1) * 10 + 1;
		   	    int endPage = startPage+10-1;

		   		if (endPage> maxPage) endPage= maxPage;
		   		
				
				
				
				
				if(allList==null){
					out.println("공개된 스쿼드가 없습니다");
				}
				else {
				%><table>
					<tr>
						<th class='width1'>스쿼드 번호</th>
						<th class='width1'>작성자</th>
						<th class='width2'>스쿼드 이름</th>
						<th class='width1'>포메이션</th>
						<th class='width1'>조회수</th>
						<th class='width1'>작성일</th>
					</tr>
				<%
					for(int i=0; i<allList.size(); i++){
						out.println("<tr><td>"+allList.get(i).getSquad_num()+"</td>");
						out.println("<td>"+allList.get(i).getUser_id()+"</td>");
						out.println("<td><a href='squad.sq?no="+allList.get(i).getSquad_num()+"'>"+allList.get(i).getSquad_name()+"</a></td>");
						out.println("<td>"+allList.get(i).getFormation()+"</td>");
						out.println("<td>"+allList.get(i).getView_count()+"</td>");
						out.println("<td>"+allList.get(i).getMake_date()+"</td></tr>");
						
					}%></table>
				<div class="paging">
				
					<%if(page_no<=1){ %>
					[이전]&nbsp;
					<%}else{ %>
					<a href="squad_list.sq?page=<%=page_no-1%>">[이전]</a>&nbsp;
					<%} %>
				
					<%for(int a=startPage;a<=endPage;a++){
						if(a==page_no){%>
						<span class="select">[<%=a %>]</span>&nbsp;
						<%}else{ %>
							<a href="squad_list.sq?page=<%=a %>">[<%=a %>]</a>&nbsp;
						<%} %>
					<%} %>
				
					<%if(page_no>=maxPage){ %>
					[다음]
					<%}else{ %>
					<a href="squad_list.sq?page=<%=page_no+1 %>">[다음]</a>
					<%
					}
				    }
					%>
				
				</div>
			</div>
		</div>
	</section>
	
	<jsp:include page="Footer_baseform.jsp"/>
</body>
</html>