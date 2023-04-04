$(function(){
	var cate = document.getElementsByClassName("replace_cate");
	for(var i=0 ; i<cate.length; i++){
		var eng_cate= cate.item(i).innerText;
		var kor_cate = eng_cate.replace('free','자유').replace('debate','토론').replace('qna','질문').replace('info','정보');
		cate.item(i).innerText=kor_cate;
	}
	$(document).ready(function(){
		$(".category").on('change',function(){
			location.href = "community.jsp?cate="+this.value;
		})
	})
	
	
})