$(function(){
	$(".del_check").click(function(){
		if(confirm("댓글을 삭제하겠습니까?")){
		}else{
			return false;
		}
	})
	
	
	$(".pd_bt > input[type=button]").click(function(){
		 location.href = "shop_list_action.sp";
	})
	
})