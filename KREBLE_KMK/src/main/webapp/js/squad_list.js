$(document).ready(function(){
	$(".search_formation").addClass("hide")
	$(".search_select").change(function(){
		var search_val = $(this).val();
		if(search_val=="search_formation"){
			$(".search_formation").removeClass("hide");
			$(".search_text").addClass("hide");
		}
		else {
			$(".search_formation").addClass("hide");
			$(".search_text").removeClass("hide");
		}
	})
})