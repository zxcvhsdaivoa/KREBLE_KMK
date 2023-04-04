<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="css/Header_Footer_Aside_baseform.css">
	<link rel="stylesheet" type="text/css" href="css/community.css">
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<script src="js/Header_Footer_Aside_baseform.js"></script>
<%
	String after= request.getParameter("after").trim();
	if(after.equals("write")) {
		%>
		<script>
		$(function(){
			$(".community_inner > span").text("게시글 작성이 완료되었습니다");
		})
		</script>
		<%
	}
	else if (after.equals("change")){
		%>
		<script>
		$(function(){
			$("span").text("게시글 수정이 완료되었습니다");
		})
		</script>
		<%
	}
	else if	(after.equals("delete")){
		%>
		<script>
		$(function(){
			$("span").text("게시글 삭제가 완료되었습니다");
		})
		</script>
		<%
	}
	
%>
<body>
<jsp:include page="Header_baseform.jsp"/>
	<section>
		<div class="section_inner">
			<div class="community2">
				<div class="community_inner">
					<span class="after_text"></span><br>
					<a href="community.jsp?cate=all">바로가기</a>
				</div>
			</div>
		</div>
			
			
	</section>

<jsp:include page="Footer_baseform.jsp"/>
</body>
</html>