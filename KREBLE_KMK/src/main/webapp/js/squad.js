$(function(){
	var pl_img_src="image/player_img/";
	var pl_count= ($('.player_list ul li').length);
	var sq_count= ($('.squad_wrap ul li').length);
	$(".squad_wrap ul li:nth-of-type(1)").css({'top':'0','left':'-30px'})
	$(".squad_wrap ul li:nth-of-type(12)").css({'top':'580px','left':'555px'})
	$(".squad_wrap ul li:nth-of-type(2)").css({'top':'35px','left':'230px'})
	$(".squad_wrap ul li:nth-of-type(3)").css({'top':'35px','left':'555px'})
	$(".squad_wrap ul li:nth-of-type(4)").css({'top':'35px','left':'880px'})
	$(".squad_wrap ul li:nth-of-type(5)").css({'top':'240px','left':'310px'})
	$(".squad_wrap ul li:nth-of-type(6)").css({'top':'275px','left':'555px'})
	$(".squad_wrap ul li:nth-of-type(7)").css({'top':'240px','left':'800px'})
	$(".squad_wrap ul li:nth-of-type(8)").css({'top':'420px','left':'160px'})
	$(".squad_wrap ul li:nth-of-type(9)").css({'top':'435px','left':'390px'})
	$(".squad_wrap ul li:nth-of-type(10)").css({'top':'435px','left':'720px'})
	$(".squad_wrap ul li:nth-of-type(11)").css({'top':'420px','left':'960px'})
	$(".player_wrap").hide();
	$(".mysquad_wrap").hide();
	//$('.mysquad .squad_wrap ul li').draggable();

	//기본 이미지 지정
	for(var i=1; i<=pl_count; i++){
		var enname = $(".player_list ul li:nth-of-type("+i+")").find(".name_eng").text();
		$(".player_list ul li:nth-of-type("+i+")").find("img").attr("src",pl_img_src+enname+".jpg");
	}

	//n번 선수 선택
	$(".squad_wrap ul > li").click(function(){
		//선수선택페이지 오픈
		if($(this).find("span").hasClass("x_bu")==false){
			$(".squad_wrap ul > li").removeClass("on")
			$(this).addClass("on")
			if($(this).hasClass("director")==true) {
				$(".player_list").hide();
				$(".list_header").hide();
				$(".director_box").show();
			}
			else {
				$(".player_list").show();
				$(".list_header").show();
				$(".director_box").hide();
			}
			$(".player_wrap").show()
		}
		//등록된 선수 제거
		else if($(this).find("span").hasClass("x_bu")==true){
			$(this).find(".player_image").css({"background-image":'none'});
			for(var i=0; i<=sq_count; i++){
				if($(this).find("p.ko_name").text()==$(".squad_wrap ul li:nth-of-type("+i+")").find("p.ko_name").text()){
					if(i==1){
						$(this).find("p.ko_name").text("감독")
					}
					else {
						$(this).find("p.ko_name").text("선수"+(i-1))
					}
				}
				$(this).find("p.eng_name").text("")
				$(this).find("p.posi").text("")
				$(this).find("input[type=hidden]").val("");
			}
			$(this).find("span:eq(1)").removeClass("x_bu");
			$(this).find("span:eq(1)").addClass("plus");
			$(this).removeClass("on");
			$(this).find("p.posi").removeClass('on');
		}
	})
	//선수 선택
	$(".select_list li").click(function(){
		var pl_img=$(this).find("img").attr("src");
		var pl_name_ko=$(this).find(".name_ko").text();
		var pl_name_eng=$(this).find(".name_eng").text();
		var pl_position=$(this).find(".p_position").text();
		$(".squad_wrap ul li.on .player_image").css({"background-image":'url("' + pl_img + '")'});
		$(".squad_wrap ul li.on p.ko_name").text(pl_name_ko);
		$(".squad_wrap ul li.on p.eng_name").text(pl_name_eng);
		$(".squad_wrap ul li.on input[type=hidden]").val(pl_name_eng);
		$(".squad_wrap ul li.on p.posi").text(pl_position);
		$(".squad_wrap ul li.on span:eq(1)").removeClass("plus");
		$(".squad_wrap ul li.on span:eq(1)").addClass("x_bu");
		$(".squad_wrap ul li.on p.posi").addClass('on');
		$(".squad_wrap ul li.on").removeClass("on")
		$(".player_wrap").hide();
	})

	//창 닫기
	$(".exit").click(function(){
		$(".squad_wrap ul li.on").removeClass("on")
		$(".player_wrap").hide();

	})


	//포지션별로 표시
	$(".list_header ul li").click(function(){
		var fosi = $(this).text();
		if(fosi == "All Players") {
			$(".player_list ul li").show();
		}
		else {
			for(var i=1; i<=pl_count; i++){
				var pl_posi=$(".player_list ul li:nth-of-type("+i+") .p_position").text();
				if(pl_posi==fosi){
					$(".player_list ul li:nth-of-type("+i+")").show();
				}
				else {
					$(".player_list ul li:nth-of-type("+i+")").hide();
				}
			}
		}
	})

	//포메이션
	$("#formation").change(function(){
		var forma=$("#formation option:selected").val();
		$(".squad_wrap ul li:nth-of-type(1)").css({'top':'0','left':'-30px'})
		$(".squad_wrap ul li:nth-of-type(12)").css({'top':'580px','left':'555px'})
		if(forma=="4-3-3") {
			$(".squad_wrap ul li:nth-of-type(2)").css({'top':'35px','left':'230px'})
			$(".squad_wrap ul li:nth-of-type(3)").css({'top':'35px','left':'555px'})
			$(".squad_wrap ul li:nth-of-type(4)").css({'top':'35px','left':'880px'})
			$(".squad_wrap ul li:nth-of-type(5)").css({'top':'240px','left':'310px'})
			$(".squad_wrap ul li:nth-of-type(6)").css({'top':'275px','left':'555px'})
			$(".squad_wrap ul li:nth-of-type(7)").css({'top':'240px','left':'800px'})
			$(".squad_wrap ul li:nth-of-type(8)").css({'top':'420px','left':'160px'})
			$(".squad_wrap ul li:nth-of-type(9)").css({'top':'435px','left':'390px'})
			$(".squad_wrap ul li:nth-of-type(10)").css({'top':'435px','left':'720px'})
			$(".squad_wrap ul li:nth-of-type(11)").css({'top':'420px','left':'960px'})
		}
		else if(forma=="4-2-3-1") {
			$(".squad_wrap ul li:nth-of-type(2)").css({'top':'15px','left':'555px'})
			$(".squad_wrap ul li:nth-of-type(3)").css({'top':'135px','left':'310px'})
			$(".squad_wrap ul li:nth-of-type(4)").css({'top':'165px','left':'555px'})
			$(".squad_wrap ul li:nth-of-type(5)").css({'top':'135px','left':'800px'})
			$(".squad_wrap ul li:nth-of-type(6)").css({'top':'290px','left':'400px'})
			$(".squad_wrap ul li:nth-of-type(7)").css({'top':'290px','left':'710px'})
			$(".squad_wrap ul li:nth-of-type(8)").css({'top':'390px','left':'160px'})
			$(".squad_wrap ul li:nth-of-type(9)").css({'top':'450px','left':'400px'})
			$(".squad_wrap ul li:nth-of-type(10)").css({'top':'450px','left':'710px'})
			$(".squad_wrap ul li:nth-of-type(11)").css({'top':'390px','left':'950px'})
		}
		else if(forma=="4-2-2-2") {
			$(".squad_wrap ul li:nth-of-type(2)").css({'top':'30px','left':'455px'})
			$(".squad_wrap ul li:nth-of-type(3)").css({'top':'30px','left':'655px'})
			$(".squad_wrap ul li:nth-of-type(4)").css({'top':'200px','left':'230px'})
			$(".squad_wrap ul li:nth-of-type(5)").css({'top':'200px','left':'880px'})
			$(".squad_wrap ul li:nth-of-type(6)").css({'top':'290px','left':'435px'})
			$(".squad_wrap ul li:nth-of-type(7)").css({'top':'290px','left':'675px'})
			$(".squad_wrap ul li:nth-of-type(8)").css({'top':'390px','left':'170px'})
			$(".squad_wrap ul li:nth-of-type(9)").css({'top':'450px','left':'435px'})
			$(".squad_wrap ul li:nth-of-type(10)").css({'top':'450px','left':'675px'})
			$(".squad_wrap ul li:nth-of-type(11)").css({'top':'390px','left':'940px'})
		}
		else if(forma=="4-1-2-3") {
			$(".squad_wrap ul li:nth-of-type(2)").css({'top':'20px','left':'230px'})
			$(".squad_wrap ul li:nth-of-type(3)").css({'top':'40px','left':'555px'})
			$(".squad_wrap ul li:nth-of-type(4)").css({'top':'20px','left':'880px'})
			$(".squad_wrap ul li:nth-of-type(5)").css({'top':'230px','left':'380px'})
			$(".squad_wrap ul li:nth-of-type(6)").css({'top':'230px','left':'730px'})
			$(".squad_wrap ul li:nth-of-type(7)").css({'top':'305px','left':'555px'})
			$(".squad_wrap ul li:nth-of-type(8)").css({'top':'400px','left':'190px'})
			$(".squad_wrap ul li:nth-of-type(9)").css({'top':'430px','left':'380px'})
			$(".squad_wrap ul li:nth-of-type(10)").css({'top':'430px','left':'730px'})
			$(".squad_wrap ul li:nth-of-type(11)").css({'top':'400px','left':'920px'})
		}
		else if(forma=="5-2-3") {
			$(".squad_wrap ul li:nth-of-type(2)").css({'top':'20px','left':'200px'})
			$(".squad_wrap ul li:nth-of-type(3)").css({'top':'10px','left':'555px'})
			$(".squad_wrap ul li:nth-of-type(4)").css({'top':'20px','left':'910px'})
			$(".squad_wrap ul li:nth-of-type(5)").css({'top':'210px','left':'420px'})
			$(".squad_wrap ul li:nth-of-type(6)").css({'top':'210px','left':'700px'})
			$(".squad_wrap ul li:nth-of-type(7)").css({'top':'330px','left':'200px'})
			$(".squad_wrap ul li:nth-of-type(8)").css({'top':'390px','left':'350px'})
			$(".squad_wrap ul li:nth-of-type(9)").css({'top':'390px','left':'555px'})
			$(".squad_wrap ul li:nth-of-type(10)").css({'top':'390px','left':'760px'})
			$(".squad_wrap ul li:nth-of-type(11)").css({'top':'330px','left':'910px'})
		}
	})
	

	//스쿼드 저장
	$(".save_squad").click(function(){
		var login_Id = document.getElementById("user_id").value;
		if(login_Id=="null"){
			alert("로그인 후 이용해주세요");
			return false;
		}
		else {
			var sq_mem = document.querySelectorAll(".eng_name");
			for(var i=0; i<sq_mem.length; i++){
				var null_ch =sq_mem.item(i).innerText;
				if(null_ch == ''){
					alert('비어있는 칸이 없도록 선택해주세요');
					return false;
				}
				else if(i==sq_mem.length-1) {
					for(var j=1; j<sq_mem.length; j++){
						var ckj=sq_mem.item(j).innerText;
						for(var k=0; k<j; k++) {
							var ckk=sq_mem.item(k).innerText;
							if(ckj == ckk) { 
								alert('선수가 중복되지 않게 선택해주세요')
								i=sq_mem.length;
								j=sq_mem.length;
								return false;
					        } else if(j==sq_mem.length-1 && k==j-1) {
					            
					        }
						}
					}
				}
			}
		}
	})
})
//
