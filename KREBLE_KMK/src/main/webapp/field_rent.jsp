<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<script src="js/field_rent.js"></script>
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
						<option>지역 목록111</option>
					</select>
					<select>
						<option>경기장 목록</option>
					</select>
				</div>
			</div>
			
			<ul class="rent_step">
				<li class="step1"><span class="step_txt1" style="color:#009ce1;">예약선택</span></li>
				<li class="step2"><span class="step_txt">약관동의</span></li>
				<li class="step3"><span class="step_txt">신청완료</span></li>
			</ul>
			<form>
			<div id="content2">
				<div class="content2_box">
					<h3 class="box_text">날짜/시간선택</h3>
				</div>
				
				<div class="box_inner">
				  <div class="date_selc">
				    <select class="month_selc" onchange="showCalendar(this.value)">
				      <option value="">날짜를 선택해주세요</option>
				      <option value="4">2023년 04월</option>
				      <option value="5">2023년 05월</option>
				      <option value="6">2023년 06월</option>
				      <option value="7">2023년 07월</option>
				    </select>
				  </div>
				
				  <div class="calendar" id="calendar">
				  </div>
				</div>
				
<!-- 					<div class="calendar"> js를 이용해서 달력 출력하기 전 수작업 ver --> 
<!-- 						<table class="tb_calendar"> -->
<!-- 							<tr class="day"> -->
<!-- 								<td>일</td> -->
<!-- 								<td>월</td> -->
<!-- 								<td>화</td> -->
<!-- 								<td>수</td> -->
<!-- 								<td>목</td> -->
<!-- 								<td>금</td> -->
<!-- 								<td>토</td> -->
<!-- 							</tr> -->
<!-- 							<tr class="day2"> -->
<%-- 								<c:forEach begin="26" end="31" var="day"> --%>
<%-- 							            <td>${day}일</td> --%>
<%-- 							    </c:forEach> --%>
<!-- 							    <td>1일</td> -->
<!-- 							</tr> -->
<!-- 							<tr class="day2"> -->
<%-- 								<c:forEach begin="2" end="8" var="day"> --%>
<%-- 							            <td>${day}일</td> --%>
<%-- 							    </c:forEach> --%>
<!-- 							    forEach를 사용하기위해 JSTL(Core) 라이브러리를 추가 해야함. 위에 코드 있음 -->
<!-- 							</tr> -->
<!-- 							<tr class="day2"> -->
<%-- 								<c:forEach begin="9" end="15" var="day"> --%>
<%-- 									<td>${day}일</td>  --%>
<%-- 								</c:forEach> --%>
<!-- 							</tr> -->
<!-- 							<tr class="day2"> -->
<%-- 								<c:forEach begin="16" end="22" var="day"> --%>
<%-- 							            <td>${day}일</td> --%>
<%-- 							    </c:forEach> --%>
<!-- 							</tr> -->
<!-- 							<tr class="day2"> -->
<%-- 								<c:forEach begin="23" end="29" var="day"> --%>
<%-- 							            <td>${day}일</td> --%>
<%-- 							    </c:forEach> --%>
<!-- 							</tr> -->
<!-- 						</table> -->
<!-- 					</div> -->
<!-- 				</div> -->
				
				<div id="info_box">
					<h3 class="box_text">신청정보</h3>
				</div>
				<div class="box_inner2">
					<input type="radio"><span>09시(09:00~11:00) 대여료 165,000</span>
					<input type="radio"><span>11시(11:00~13:00) 대여료 165,000</span>
					<input type="radio"><span>14시(14:00~16:00) 대여료 165,000</span>
					<input type="radio"><span>16시(16:00~18:00) 대여료 165,000</span>
					<input type="radio"><span>18시(18:00~20:00) 대여료 165,000</span>
				</div>
				<div class="content2_box">
					<h3 class="box_text">합계:<span style="color: #f24400;"> 0 원</span></h3>
				</div>
				<div class="btn_area">
					<a class="payment_btn" href="field_rent_agree.jsp">결제하기</a>
				</div>
			</div>
			</form>
		</div>

	</section>
	 <jsp:include page="Footer_baseform.jsp"/>
</body>
</html>