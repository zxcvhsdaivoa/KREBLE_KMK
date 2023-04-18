<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>구장 예약</title>
<link rel="stylesheet" type="text/css" href="css/Header_Footer_Aside_baseform.css">
<link rel="stylesheet" type="text/css" href="css/field_rent.css">
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<script src="js/Header_Footer_Aside_baseform.js"></script>
<script type="text/javascript" ></script>
<body>
	<jsp:include page="Header_baseform.jsp"/>
	<section>
		<div id="topbg">
			<div class="topinner">
				<p class="toptext">KREBLE
					<span class="toptext2">시민구장 예약</span>
				</p>
			</div>
		</div>
		<div id="main_content">
			<div class="content_top">
				<div class="top_text">
					<h1>예약신청</h1>
					<select>
						<option>지역 목록</option>
					</select>
					<select>
						<option>경기장 목록</option>
					</select>
				</div>
			</div>
			
			<ul class="rent_step">
				<li class="step1"><span class="step_txt">예약선택</span></li>
				<li class="step2"><span class="step_txt">약관동의</span></li>
				<li class="step3"><span class="step_txt">신청완료</span></li>
			</ul>
			
			<div id="content2">
				<div id="content2_box">
					<h3 class="box_text">날짜/시간선택</h3>
				</div>
				
				<div class="box_inner">
					<div class="date_selc">
						<select class="month_selc">
							<option>2023년 04월</option>
							<option>2023년 05월</option>
							<option>2023년 06월</option>
							<option>2023년 07월</option>
						</select>
						<select class="month_selc">
							<option>04월 01일 ~ 04월 30일</option>
							<option>05월 01일 ~ 05월 30일</option>
							<option>06월 01일 ~ 06월 30일</option>
							<option>07월 01일 ~ 07월 30일</option>
						</select>
					</div>
					
					<div class="calendar">
						<table class="tb_calendar">
							<tr class="day">
								<td>일</td>
								<td>월</td>
								<td>화</td>
								<td>수</td>
								<td>목</td>
								<td>금</td>
								<td>토</td>
							</tr>
							<tr class="day2">
								<td>26일</td>
								<td>27일</td>
								<td>28일</td>
								<td>29일</td>
								<td>30일</td>
								<td>31일</td>
								<td>01일</td>
							</tr>
							<tr class="day2">
								<td>02일</td>
								<td>03일</td>
								<td>04일</td>
								<td>05일</td>
								<td>06일</td>
								<td>07일</td>
								<td>08일
								<span class="possible">가능</span>
								</td>
								
							</tr>
						</table>
					</div>
				</div>		
			</div>
		</div>

	</section>
	 <jsp:include page="Footer_baseform.jsp"/>
</body>
</html>