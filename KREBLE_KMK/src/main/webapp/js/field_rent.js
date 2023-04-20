$(function(){
	var today = new Date(); // 오늘 날짜
  var cells = document.querySelectorAll('.day2 td');
  
  // 지난 날짜에 대해 클래스 추가 및 "마감" 추가
  for (var i = 0; i < cells.length; i++) {
    var cellDate = new Date(today.getFullYear(), today.getMonth(), parseInt(cells[i].textContent));
    if (cellDate < today) {
      cells[i].innerHTML += '<span class="impossible">마감</span>';
    }
    else if(cellDate > today){
		cells[i].innerHTML += '<span class="possible">가능</span>';
	}
  }
	var todayCell = document.querySelector('.day2 td.today');
	if (todayCell > cellDate) {
	  todayCell.innerHTML += '<span class="possible">가능</span>';
	}
  
  
});