package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.Field_list_Service;
import svc.Field_rent_Service;
import vo.ActionForward;
import vo.KreblechoiData;
import vo.Rent_info;


public class Field_rent_select_action implements Action {
	
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		KreblechoiData cate_list=null;
		Rent_info rent_info=null;
		
		Field_rent_Service fieldrentService= new Field_rent_Service();
		
		rent_info = fieldrentService.getrent_list_check();
		cate_list = fieldrentService.getfield_cate_list();
		
		request.setAttribute("rent_info", rent_info);
		request.setAttribute("cate_list", cate_list);
		
		ActionForward forward= new ActionForward();
		forward.setPath("/field_rent.jsp");
		return forward;
	}
}
