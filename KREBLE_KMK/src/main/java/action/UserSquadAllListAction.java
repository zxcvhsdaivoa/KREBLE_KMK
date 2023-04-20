package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.UserSquadAllListService;
import vo.ActionForward;
import vo.SquadInfo;

public class UserSquadAllListAction implements Action {
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		int page=1;
		int limit=15;
		
		if(request.getParameter("page")!=null){
			page=Integer.parseInt(request.getParameter("page"));
		}
		ArrayList<SquadInfo> allList=null;
		UserSquadAllListService userSquadAllListService = new UserSquadAllListService();
		allList = userSquadAllListService.getAllList(page,limit);
		int count= userSquadAllListService.getAllListCount();
		request.setAttribute("allList", allList);
		request.setAttribute("count", count);
		ActionForward forward= new ActionForward();
  		forward.setPath("/mysquad_list.jsp");
  		return forward;
  		
	 }
	 
}
