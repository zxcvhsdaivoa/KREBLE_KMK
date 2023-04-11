package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.Shop_detail_service;
import use_data.Shop_prd;
import vo.ActionForward;

 public class Shop_detail_action implements Action {
	 
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{ 
	   	
		int board_num=Integer.parseInt(request.getParameter("board_num"));
		String page = request.getParameter("page");
		Shop_detail_service boardDetailService = new Shop_detail_service();
		Shop_prd article = boardDetailService.getArticle(board_num);
		ActionForward forward = new ActionForward();
		request.setAttribute("page", page);
	   	request.setAttribute("article", article);
   		forward.setPath("/qna_board_view.jsp");
   		return forward;

	 }
	 
}