package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.Shop_delete_service;
import svc.Shop_prd_lck_service;
import vo.ActionForward;


public class Shop_Prd_like_ck implements Action {

	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		String pno = request.getParameter("p_no");
		String pid = request.getParameter("p_id");
		ActionForward forward=null;		
		Shop_prd_lck_service aa = new Shop_prd_lck_service();
		aa.likeArticle(pno, pid);
		
		forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("shop_list_action.sp");
			
			
		return forward;
		
	}  	
	
}