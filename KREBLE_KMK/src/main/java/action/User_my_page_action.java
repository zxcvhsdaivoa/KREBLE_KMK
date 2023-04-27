package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.ActionForward;


public class User_my_page_action implements Action {

	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		ActionForward forward=null;
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("mypage.jsp");
		return forward;
		
	}  	
	
}