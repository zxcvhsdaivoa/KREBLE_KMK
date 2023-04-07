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

		System.out.println("==================================");
		HttpSession session=request.getSession();
		squadinfo.setUser_id((String)session.getAttribute("ID"));
		System.out.println((String)session.getAttribute("ID"));
		squadinfo.setSquad_name(request.getParameter("squad_name"));
		System.out.println(request.getParameter("squad_name"));
		squadinfo.setFormation(request.getParameter("formation"));
		System.out.println(request.getParameter("formation"));
		squadinfo.setDirector(request.getParameter("director"));
		System.out.println(request.getParameter("director"));
		squadinfo.setPlayer1(request.getParameter("player1"));
		System.out.println(request.getParameter("player1"));
		squadinfo.setPlayer2(request.getParameter("player2"));
		System.out.println(request.getParameter("player2"));
		squadinfo.setPlayer3(request.getParameter("player3"));
		System.out.println(request.getParameter("player3"));
		squadinfo.setPlayer4(request.getParameter("player4"));
		System.out.println(request.getParameter("player4"));
		squadinfo.setPlayer5(request.getParameter("player5"));
		System.out.println(request.getParameter("player5"));
		squadinfo.setPlayer6(request.getParameter("player6"));
		System.out.println(request.getParameter("player6"));
		squadinfo.setPlayer7(request.getParameter("player7"));
		System.out.println(request.getParameter("player7"));
		squadinfo.setPlayer8(request.getParameter("player8"));
		System.out.println(request.getParameter("player8"));
		squadinfo.setPlayer9(request.getParameter("player9"));
		System.out.println(request.getParameter("player9"));
		squadinfo.setPlayer10(request.getParameter("player10"));
		System.out.println(request.getParameter("player10"));
		squadinfo.setPlayer11(request.getParameter("player11"));
		System.out.println(request.getParameter("player11"));
		System.out.println("==================================");
		SquadSaveProService SquadSaveProService = new SquadSaveProService();
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