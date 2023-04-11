<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="utf-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="ud" class="use_data.Db_method_player"/>
<%@ page import="use_data.Player_Info"%>
<%@ page import="vo.SquadInfo"%>
<%@ page import="use_data.Director_Info"%>
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
				<%
				SquadInfo squad =null; 
				squad = (SquadInfo) request.getAttribute("squad");
				boolean nullck = false;
				if(squad==null){
					nullck = false;
				}
				else {
					nullck = true;
				}
				%>
					<form class="squad_form" name="squad_form" action="squadSavePro.sq" method="post" onsubmit="return memberjoin()">
						<input type="hidden" id="user_id" name="user_id" value="<%= (String) session.getAttribute("ID")%> ">
						<ul>
							<%
							if(nullck==true){
							Director_Info director = ud.squad_director(squad);
							%>
							<li class="director">
								<input type="hidden" value="<%=director.getDirector_name()%>"name="director" id="director" class="squad_member">
								<img src="image/player_img/<%= director.getDirector_name() %>.jpg" class="player_image">
								<p class="ko_name"><%=director.getDirector_ko_name()%></p>
								<p class="eng_name"><%=director.getDirector_name()%></p>
								<span class="x_bu"></span>
							</li>
							<%
							} else{
							%>
							<li class="director">
								<input type="hidden" value="" name="director" id="director" class="squad_member">
								<img src="image/player_img/null_image.png" class="player_image">
								<p class="ko_name">감독</p>
								<p class="eng_name"></p>
								<span class="plus"></span>
							</li>
							<%
							}
							for(int i=1; i<=11; i++){
								if(nullck==true) {
								Player_Info player = ud.squad_player(squad, i);
							%> 
								<li class="player">
									<input type="hidden" value="<%= player.getPlayer_name() %>" name="player<%=i %>" id="player<%=i %>" class="squad_member">
									<img src="image/player_img/<%= player.getPlayer_name() %>.jpg" class="player_image">
									<p class="ko_name"><%= player.getPlayer_ko_name() %></p>
									<p class="eng_name"><%= player.getPlayer_name() %></p>
									<p class="posi on"><%= player.getPlayer_position() %></p>
									<span class="x_bu"></span>
								</li>
							<%
								}
								else {
							%>
								<li class="player">
									<input type="hidden" value="" name="player<%=i %>" id="player<%=i %>" class="squad_member">
									<img src="image/player_img/null_image.png" class="player_image">
									<p class="ko_name">선수<%=i %></p>
									<p class="eng_name"></p>
									<p class="posi"></p>
									<span class="plus"></span>
								</li>
							<%
								}
							}
							%>
						</ul>
						<button type="button" class="open_squad">나의 스쿼드 불러오기</button>
						<label for="squad_name" class="blind">스쿼드의 이름을 입력하세요</label>
						<input type="text" id="squad_name" name="squad_name" <% if(nullck==true){%> value="<%= squad.getSquad_name()%>"<%} %>>
						<%if(nullck==true){%><input type="hidden" id="squad_no" name="squad_no" value="<%= squad.getSquad_num() %>"><%} %>
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
			<div class="player_list select_list">
				<ul>
				<%
				ArrayList<Player_Info> pl = ud.player();
				
				for(int i=0; i<pl.size(); i++) {
				%>
					<li>
						<span class="p_img"><img src="image/player_img/<%= pl.get(i).getPlayer_name() %>.jpg"></span>
						<p class="p_name"><span class="name_ko"><%= pl.get(i).getPlayer_ko_name() %></span><br><span class="name_eng"><%= pl.get(i).getPlayer_name() %></span></p>
						<p class="p_profile"><%= pl.get(i).getPlayer_birth() %><br><%= pl.get(i).getPlayer_gender() %></p>
						<p class="p_position"><%= pl.get(i).getPlayer_position() %></p>
					</li>
				<% }%>
				</ul>
			</div>
			<div class="director_box select_list">
				<ul>
				<%
				ArrayList<Director_Info> dl = ud.director();
				for(int i=0; i<dl.size(); i++) {
				%>
					<li>
						<span class="p_img"><img src="image/player_img/<%= dl.get(i).getDirector_name() %>.jpg"></span>
						<p class="p_name">이름 : <span class="name_ko"><%= dl.get(i).getDirector_ko_name() %></span>(<span class="name_eng"><%= dl.get(i).getDirector_name() %></span>)<br></p>
						<p class="p_profile">생일 : <%= dl.get(i).getDirecotr_birth() %><br><br>성별 : <%= dl.get(i).getDirector_gender() %><br><br>국적 : <%= dl.get(i).getDirector_nation() %></p>
						<p class="nation"></p>
						<p class="period">부임기간<br><br><%= dl.get(i).getDirector_date_in() %> <br>~<br> <%= dl.get(i).getDirector_date_end() %></p>
					</li>
				<% }%>
				</ul>
			</div>
		</div>
	</div>
	<div class="mysquad_wrap">
		<div class="mysquad_inner">
			<span class="exit">나가기</span>
			
			<%
			ArrayList<SquadInfo> squadlist =null; 
			squadlist = (ArrayList<SquadInfo>) request.getAttribute("squadList");
			
			if(squadlist==null){
				out.println("저장된 스쿼드가 없습니다");
			}
			else {
			%>
			<table>
				<tr>
					<th class='width1'>스쿼드 번호</th>
					<th class='width2'>스쿼드 이름</th>
					<th class='width1'>포메이션</th>
					<th class='width1'>공개 여부</th>
				</tr>
			<%
				for(int i=0; i<squadlist.size(); i++){
					out.println("<tr><td>"+squadlist.get(i).getSquad_num()+"</td>");
					out.println("<td><a href='squad.sq?no="+squadlist.get(i).getSquad_num()+"'>"+squadlist.get(i).getSquad_name()+"</a></td>");
					out.println("<td>"+squadlist.get(i).getFormation()+"</td>");
					out.println("<td>"+squadlist.get(i).getDisclose()+"</td></tr>");
				}
			}
			%>
			</table>
		</div>
	</div>
</body>


</html>