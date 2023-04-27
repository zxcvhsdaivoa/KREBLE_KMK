package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.User_my_page_service;
import use_data.Shop_prd;
import use_data.UserData;
import vo.ActionForward;
import vo.SquadInfo;
import vo.field_save_Data;


public class User_my_page_action implements Action {

	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		String id = (String) request.getSession().getAttribute("ID");
		ArrayList<UserData> user_al = new ArrayList<UserData>();//유저정보
		ArrayList<field_save_Data> field_al = new ArrayList<field_save_Data>();//경기장대여
		ArrayList<Shop_prd> plike_al = new ArrayList<Shop_prd>();//관심상품
		ArrayList<SquadInfo> squad_al = new ArrayList<SquadInfo>();//마이스쿼드
		ArrayList<Shop_prd> pcart_al = new ArrayList<Shop_prd>(); //장바구니
		
		User_my_page_service mp = new User_my_page_service();
		user_al = mp.getUserInfo(id);
		squad_al = mp.getSquadInfo(id);
		pcart_al = mp.getCartInfo(id);
		field_al = mp.getFieldInfo(id);
		plike_al = mp.getLikeInfo(id);
		
		
		ActionForward forward=null;
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("mypage.jsp");
			request.setAttribute("field_al", field_al);
			request.setAttribute("user_al", user_al);
			request.setAttribute("plike_al", plike_al);
			request.setAttribute("pcart_al", pcart_al);
			request.setAttribute("squad_al", squad_al);
		return forward;
		
	}  	
	
}