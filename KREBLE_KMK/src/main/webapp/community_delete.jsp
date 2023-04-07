<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>삭제하기</title>
	<link rel="stylesheet" type="text/css" href="css/Header_Footer_Aside_baseform.css">
	<link rel="stylesheet" type="text/css" href="css/community.css">
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<script src="js/Header_Footer_Aside_baseform.js"></script>
<body>
<jsp:include page="Header_baseform.jsp"/>
	<section>
		<div class="section_inner">
			<div class="community">
				<div class="community_inner">
					<%
					String comu_no = request.getParameter("no");
					String id = (String) session.getAttribute("ID");
					
					%>
				        
					<div class="community">
						<p>정말 삭제하시겠습니까?<br></p>
						<a href="community_deleting.jsp?no=<%= comu_no%>&id=<%= id%>">예</a>   <a href="community_borde.jsp?no=<%= comu_no%>">아니요</a>
					</div>
				</div>
			</div>
		</div>
	</section>
<jsp:include page="Footer_baseform.jsp"/>
</body>
</html>