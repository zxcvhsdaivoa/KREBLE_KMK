$(function(){
	var cate = document.getElementsByClassName("replace_cate");
	for(var i=0 ; i<cate.length; i++){
		var eng_cate= cate.item(i).innerText;
		var kor_cate = eng_cate.replace('free','자유').replace('debate','토론').replace('qna','질문').replace('info','정보');
		cate.item(i).innerText=kor_cate;
	}
})

function comment_write(){
	var commu_no=document.getElementById("commu_no").value;
	var comment=document.getElementById("comment").value;
	$.ajax({
		type : "POST",
		url : "commu_comment_write.jsp?commu_no="+commu_no+"&comment="+comment,
		async: false,
		success :function(re){
			result=re.trim();
		},
		error:function(e){   
            alert(e.responseText); 
        }
	});
	if(result=="success"){
		alert("댓글이 작성되었습니다");
	}
	else if(result=="fail") {
		alert("댓글 작성에 실패했습니다")
		
	}
}