package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.SquadSaveProService;
import vo.ActionForward;
import vo.SquadInfo;


public class SquadSaveProAction implements Action {

	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{

		ActionForward forward=null;
		SquadInfo squadinfo = new SquadInfo();
		HttpSession session=request.getSession();
		SquadSaveProService SquadSaveProService = new SquadSaveProService();
		squadinfo.setUser_id((String)session.getAttribute("ID"));
		System.out.println(request.getParameter("squad_name"));
		if(request.getParameter("squad_name")!=null) {
			squadinfo.setSquad_name(request.getParameter("squad_name"));
		}
		else {
			int last_no = SquadSaveProService.squadLastNo()+1;
			squadinfo.setSquad_name("squad"+last_no);
		}
		squadinfo.setFormation(request.getParameter("formation"));
		squadinfo.setDirector(request.getParameter("director"));
		squadinfo.setPlayer1(request.getParameter("player1"));
		squadinfo.setPlayer2(request.getParameter("player2"));
		squadinfo.setPlayer3(request.getParameter("player3"));
		squadinfo.setPlayer4(request.getParameter("player4"));
		squadinfo.setPlayer5(request.getParameter("player5"));
		squadinfo.setPlayer6(request.getParameter("player6"));
		squadinfo.setPlayer7(request.getParameter("player7"));
		squadinfo.setPlayer8(request.getParameter("player8"));
		squadinfo.setPlayer9(request.getParameter("player9"));
		squadinfo.setPlayer10(request.getParameter("player10"));
		squadinfo.setPlayer11(request.getParameter("player11"));
		boolean isWriteSuccess = SquadSaveProService.registArticle(squadinfo);
		System.out.println(isWriteSuccess);
		if(!isWriteSuccess){
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('fail')");
			out.println("history.back();");
			out.println("</script>");
		}
		else{
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("squad.sq");
		}

		return forward;
		
	}  	
	
}