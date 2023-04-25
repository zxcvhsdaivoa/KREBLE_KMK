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
	});
})