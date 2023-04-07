package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import action.Action;
import action.SquadSaveProAction;
import vo.ActionForward;

@SuppressWarnings("serial")
@WebServlet("*.sq")
public class SquadController extends javax.servlet.http.HttpServlet 
{
	@SuppressWarnings("null")
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String RequestURI=request.getRequestURI();
		String contextPath=request.getContextPath();
		String command=RequestURI.substring(contextPath.length());
		ActionForward forward=null;
		Action action=null;

		if(command.equals("/squad.sq")){
			forward=new ActionForward();
			forward.setPath("/mysquad.jsp");
		}else if(command.equals("/squadSavePro.sq")){
			action  = new SquadSaveProAction();
			try {
				forward=action.execute(request, response );
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/squadList.sq")){
			action = null;
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		else if(command.equals("/squadDetail.sq")){
			action = null;
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		else if(command.equals("/squadModifyForm.sq")){
			action = null;
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(command.equals("/squadModifyPro.sq")){
			action = null;
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(command.equals("/squadDeleteForm.sq")){
			String nowPage = request.getParameter("page");
			request.setAttribute("page", nowPage);
			int squad_no=Integer.parseInt(request.getParameter("squad_no"));
			request.setAttribute("squad_no",squad_no);
			forward=new ActionForward();
			forward.setPath("/squad_delete.jsp");
		}
		else if(command.equals("/squadDeletePro.sq")){
			action = null;
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		if(forward != null){
			
			if(forward.isRedirect()){
				response.sendRedirect(forward.getPath());
			}else{
				RequestDispatcher dispatcher=
						request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
			
		}
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doProcess(request,response);
	}  	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doProcess(request,response);
	}   
	
}