package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import action.Action;
import vo.ActionForward;

@SuppressWarnings("serial")
@WebServlet("*.sp")
public class Shop_controller extends javax.servlet.http.HttpServlet 
{
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String RequestURI=request.getRequestURI();
		String contextPath=request.getContextPath();
		String command=RequestURI.substring(contextPath.length());
		ActionForward forward=null;
		Action action=null;

//		필요한게
//		뭐있나하면?
//		@@샵메인 인덱스 / @@샵 상품리스트/ @@상품상세페이지/ @@상품수정페이지/ @@상품등록페이지/ 장바구니/구매내역/제작의뢰/
		if(command.equals("/shop_prd_detail.sp")){
			forward=new ActionForward();
			forward.setPath("/shop_prd_detail.jsp");
		}else if(command.equals("/shop_prd_list.sp")){
			forward=new ActionForward();
			forward.setPath("/shop_prd_list.jsp");
		}else if(command.equals("/kreble_sp.sp")){
			forward=new ActionForward();
			forward.setPath("/Krebleshop.jsp");
		}else if(command.equals("/shop_prd_mod.sp")){
			forward=new ActionForward();
			forward.setPath("/shop_prd_mod.jsp");
		}else if(command.equals("/shop_prd_insert.sp")){
			forward=new ActionForward();
			forward.setPath("/shop_prd_.jsp");
		}
		else if(command.equals("/commuList.cm")){
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