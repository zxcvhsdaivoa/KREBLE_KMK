package action;

import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.UserSquadListService;
import vo.ActionForward;
import vo.SquadInfo;

 public class UserSquadListAction implements Action {
	 
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		 
		ArrayList<SquadInfo> squadList=new ArrayList<SquadInfo>();
		HttpSession session=request.getSession();
		String user_id = (String)session.getAttribute("ID");
		System.out.println(user_id);
		if(user_id!=null) {
			UserSquadListService userSquadListService = new UserSquadListService();
			squadList = userSquadListService.getArticleList(user_id);
			System.out.println(squadList.get(1).getSquad_num());
			request.setAttribute("squadList", squadList);
		}
		
		ActionForward forward= new ActionForward();
   		forward.setPath("/mysquad.jsp");
   		return forward;
   		
	 }
	 
 }