$(function(){
//	var today = new Date(); // 오늘 날짜
//  var cells = document.querySelectorAll('.day2 td');
//  
//  // 지난 날짜에 대해 클래스 추가 및 "마감" 추가
//  for (var i = 0; i < cells.length; i++) {
//    var cellDate = new Date(today.getFullYear(), today.getMonth(), parseInt(cells[i].textContent));
//    if (cellDate < today) {
//      cells[i].innerHTML += '<span class="impossible">마감</span>';
//    }
//    else if(cellDate >= today){
//		cells[i].innerHTML += '<span class="possible">가능</span>';
//	}
//  }
//	var todayCell = document.querySelector('.day2 td.today');
//	if (todayCell > cellDate) {
//	  todayCell.innerHTML += '<span class="possible">가능</span>';
//	}
	 $(".box_inner2").hide();
	 $(".day2 td > span").click(function(){
		$(".box_inner2").show();
	});
});
	function showCalendar(month) {
		  var calendar = document.getElementById("calendar");
		  var days = ["일", "월", "화", "수", "목", "금", "토"];
		
		  // 예외처리: month 인자가 없는 경우, 스타일 none해서 출력x , 있는경우 스타일 block으로 적용해서 출력
		  if (!month) {
		    calendar.style.display = "none"; 
		  }else {
		    calendar.style.display = "block";
		  }
		
		  var date = new Date(2023, month-1, 1); // 선택한 월의 첫 날짜
		  var lastDate = new Date(2023, month, 0).getDate(); // 선택한 월의 마지막 날짜
		
		  var html = "<table class='tb_calendar'>";
		  html += "<tr class='day'>";
		  for (var i = 0; i < days.length; i++) {
		    html += "<td>" + days[i] + "</td>";
		  }
		  html += "</tr>";
		
		  // 첫 주의 공백 칸 만들기
		  html += "<tr class='day2'>";
		  for (var i = 0; i < date.getDay(); i++) {
		    html += "<td></td>";
		  }
		
		  // 날짜 채우기
		  for (var i = 1; i <= lastDate; i++) {
		    if (date.getDay() == 0) { // 일요일이면 새로운 주 시작
		      html += "</tr><tr class='day2'>";
		    }
		    html += "<td>"+"<span style='cursor: pointer;'>" + i + "일</span>"+"</td>";
		    date.setDate(date.getDate() + 1);
		  }
		
		  // 마지막 주의 공백 칸 만들기
		  for (var i = date.getDay(); i < days.length; i++) {
		    html += "<td></td>";
		  }
		  html += "</tr>";
		  html += "</table>";
		
		  calendar.innerHTML = html;
		  
	}
		
	
