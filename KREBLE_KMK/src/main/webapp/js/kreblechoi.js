$(function(){
	var default_no=1;
	
	const urlParams = new URLSearchParams(window.location.search);
	const field_no = urlParams.get('field_id');
	$(".local").removeClass("on");
	$("#"+field_no).parents(".local").addClass("on");
	$('.local ul li').removeClass('on');
	$("#"+field_no).addClass("on");
	
	$(".local").click(function(){
		$(".local").removeClass("on");
		$(this).addClass("on");
	})
	$('.local ul li').click(function(){
		$('.local ul li').removeClass('on');
		$(this).addClass("on");
		if($('.favorite_stadium > ul li:nth-child('+ default_no +')').hasClass('select')==true) {
			$('.select a').text($(this).find('a').text())
			$('.favorite_stadium > ul .default:nth-child('+ default_no +')').addClass('favorite');
			$('.favorite_stadium > ul .favorite').removeClass('select');
			$('.favorite_stadium > ul .favorite').removeClass('default');
			default_no+=1;
			
			console.log(default_no);
		}
	});
	$(".rentbutton > a > img").click(function(){
		var result= confirm("로그인이 필요한 서비스입니다.\n로그인 페이지로 이동하시겠습니까?")
		if (result==true) {
			location.replace("login.html");
		} else{}
	});

	$('#plusbu').click(function(){
		if (default_no==5){
			console.log(default_no);
			alert('더이상 추가할수 없습니다');
		}
		else {
			console.log(default_no);
			$('.favorite_stadium > ul li:nth-child('+ default_no +')').addClass('select');
		}
	})
	$('#minusbu').click(function(){
		if (default_no==1){
			console.log(default_no);
			alert('더이상 제거할수 없습니다');
		}
		else {
			console.log(default_no);
			if(default_no==5) {
				default_no=4;
			}
			else {
				default_no-=1;
			}
			console.log(default_no);
			console.log(default_no);
			$('.favorite_stadium > ul li:nth-child('+ default_no +')').addClass('delete');
			$('.delete a').text("구장"+default_no);
			$('.delete').addClass('default');
			$('.delete').removeClass('favorite');
			$('.delete').removeClass('delete');
		}
	})
	$('ul.local_stadium > li > ul > li').click(function(){
	    var field_num=$(this).attr('id');
	    location.href="kreblechoi.jsp?field_id="+field_num;
	});
	
});
