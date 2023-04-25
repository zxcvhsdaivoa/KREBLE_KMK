$(function(){
	$('#pl_art_no1 > div > input[type=button]').click(function(){
			 location.href = "shop_prd_insert.sp";
	});
	
	$('.like_bt').click(function(){
		var pno = $(this).prev().val();
		var pid = $(this).next().val();
//		jquery안에 적어야됨
		
		$.ajax({
			url: "prd_like_ck.sp?p_no="+pno+"&p_id="+pid,
			type : "POST",
			async: false,
			success :function(re){
				result=re.trim();
			},
			error:function(e){   
                alert(e.responseText); 
            }
			});
			
		if(result === "del") {
				$(this).removeClass('like_on');
				$(this).addClass('like_bt');
			} else if(result === "in") {
				$(this).removeClass('like_bt');
				$(this).addClass('like_on');
			}else{
			alert("오류입니다.관리자에게 문의하십시요");
		}
	});
})