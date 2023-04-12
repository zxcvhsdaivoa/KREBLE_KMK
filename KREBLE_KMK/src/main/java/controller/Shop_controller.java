package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import action.Action;
import action.Prd_mody_form_action;
import action.Shop_detail_action;
import action.Shop_list_action;
import action.Shop_prd_insert_action;
import action.Shop_re_delete_action;
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
//		@@샵메인 인덱스 / @@샵 상품리스트/ @@상품상세페이지/ @@상품수정페이지/ @@상품등록페이지/ 장바구니/구매내역/제작의뢰
//		리플관련도 필요
		
		//상품상세
		if(command.equals("/shop_prd_detail.sp")){
			action = new Shop_detail_action();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		//크래블샵
		else if(command.equals("/kreble.sp")){
			forward=new ActionForward();
			forward.setPath("/krebleshop.jsp");
		}
		//상품수정
		else if(command.equals("/shop_prd_mod.sp")){
			forward=new ActionForward();
			forward.setPath("/shop_prd_mod.jsp");
		}
		//장바구니
		else if(command.equals("/shop_bak.sp")){
			forward=new ActionForward();
			forward.setPath("/shop_prd_bak.jsp");
		}
		//구매내역
		else if(command.equals("/shop_prd_buy_list.sp")){
			forward=new ActionForward();
			forward.setPath("/shop_buy_list.jsp");
		}
		//주문제작
		else if(command.equals("/shop_re_board.sp")){
			forward=new ActionForward();
			forward.setPath("/shop_reform_board.jsp");
		}
		//상품등록페이지
		else if(command.equals("/shop_prd_insert.sp")){
			forward=new ActionForward();
			forward.setPath("/shop_prd_insert.jsp");
		}
		//상품등록메소드
		else if(command.equals("/prd_insert.sp")){
			action = new Shop_prd_insert_action();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		//상품수정페이지
		else if(command.equals("/shop_mody_form.sp")){
			action = new Prd_mody_form_action();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		//상품수정등록
		else if(command.equals("/Shop_prd_mody_action.sp")){
			action = new Prd_mody_form_action();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		//상품리스트
		else if(command.equals("/shop_list_action.sp")){
			action = new Shop_list_action();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		
		//여분
		else if(command.equals("/shop_prd_.sp")){
			forward=new ActionForward();
			forward.setPath("/shop_prd_.jsp");
		}
		//여분
		else if(command.equals("/shop_prd_.bo")){
			action = new Shop_re_delete_action();
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