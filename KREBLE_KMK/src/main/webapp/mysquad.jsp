<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="utf-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="ud" class="use_data.Database"/>
<%@ page import="use_data.Player_Info"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>나만의 스쿼드</title>
	<link rel="stylesheet" type="text/css" href="css/Header_Footer_Aside_baseform.css">
	<link href="css/squad_style.css" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<script src="js/Header_Footer_Aside_baseform.js"></script>
<script src="js/squad.js" ></script>
<body>
	
  <jsp:include page="Header_baseform.jsp"/>
	<section>
		<div class="section_inner">
			<div class="mysquad">
				
				<div class="squad_wrap"> 
					<ul>
						<li class="director"><span class="player_image"></span><p class="ko_name">감독</p><p class="eng_name"></p><p class="posi"></p><span class="plus"></span></li>
						<li class="player"><span class="player_image"></span><p class="ko_name">선수1</p><p class="eng_name"></p><p class="posi"></p><span class="plus"></span></li>
						<li class="player"><span class="player_image"></span><p class="ko_name">선수2</p><p class="eng_name"></p><p class="posi"></p><span class="plus"></span></li>
						<li class="player"><span class="player_image"></span><p class="ko_name">선수3</p><p class="eng_name"></p><p class="posi"></p><span class="plus"></span></li>
						<li class="player"><span class="player_image"></span><p class="ko_name">선수4</p><p class="eng_name"></p><p class="posi"></p><span class="plus"></span></li>
						<li class="player"><span class="player_image"></span><p class="ko_name">선수5</p><p class="eng_name"></p><p class="posi"></p><span class="plus"></span></li>
						<li class="player"><span class="player_image"></span><p class="ko_name">선수6</p><p class="eng_name"></p><p class="posi"></p><span class="plus"></span></li>
						<li class="player"><span class="player_image"></span><p class="ko_name">선수7</p><p class="eng_name"></p><p class="posi"></p><span class="plus"></span></li>
						<li class="player"><span class="player_image"></span><p class="ko_name">선수8</p><p class="eng_name"></p><p class="posi"></p><span class="plus"></span></li>
						<li class="player"><span class="player_image"></span><p class="ko_name">선수9</p><p class="eng_name"></p><p class="posi"></p><span class="plus"></span></li>
						<li class="player"><span class="player_image"></span><p class="ko_name">선수10</p><p class="eng_name"></p><p class="posi"></p><span class="plus"></span></li>
						<li class="player"><span class="player_image"></span><p class="ko_name">선수11</p><p class="eng_name"></p><p class="posi"></p><span class="plus"></span></li>
					</ul>
					<form class="squad_form" name="squad_form">
						<button type="submit" class="open_squad">저장된 스쿼드 불러오기</button>
						<label for="squad_name" class="blind">스쿼드의 이름을 입력하세요</label>
						<input type="text" id="squad_name">
						<button type="submit" class="save_squad">스쿼드 저장</button>
						<button type="reset" class="reset_squad">스쿼드 초기화</button>
						<label for="formation" class="blind" >포메이션</label>
						<select id="formation" name="formation">
							<option>4-3-3</option>
							<option>4-2-3-1</option>
							<option>4-2-2-2</option>
							<option>4-1-2-3</option>
							<option>5-2-3</option>
						</select>
					</form>
				</div>



				</div>
			</div>
		</div>
	</section>
	
	<jsp:include page="Footer_baseform.jsp"/>
	<div class="player_wrap">
		<div class="player_inner">
			<span class="exit">나가기</span>
			<div class="list_header">
				<ul>
					<li><a href="#">All Players</a></li>
					<li><a href="#">FW</a></li>
					<li><a href="#">MF</a></li>
					<li><a href="#">DF</a></li>
					<li><a href="#">GK</a></li>
				</ul>	
			</div>
			<div class="player_list">
				<ul>
				<%
				ArrayList<Player_Info> pl = ud.player();
				
				for(int i=0; i<pl.size(); i++) {
				%>
					<li>
						<span class="p_img"><img src="image/player_img/<% pl.get(i).getPlayer_name(); %>.jpg"></span>
						<p class="p_name"><span class="name_ko"><% pl.get(i).getPlayer_ko_name(); %></span><br><span class="name_eng"><% pl.get(i).getPlayer_name(); %></span></p>
						<p class="p_profile"><% pl.get(i).getPlayer_birth(); %><br><% pl.get(i).getPlayer_gender(); %></p>
						<p class="p_position"><% pl.get(i).getPlayer_position(); %></p>
					</li>
				<% }%>
				</ul>
			</div>
		</div>
	</div>
</body>


</html>