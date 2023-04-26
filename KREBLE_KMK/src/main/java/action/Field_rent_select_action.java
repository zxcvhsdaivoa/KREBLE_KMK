package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.Field_rent_Service;
import vo.ActionForward;
import vo.Rent_info;


public class Field_rent_select_action implements Action {
	
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Rent_info rent_info=null;
		Field_rent_Service fieldrentService= new Field_rent_Service();
		rent_info = fieldrentService.getfield_list_check();
		request.setAttribute("rent_info", rent_info);
		ActionForward forward= new ActionForward();
		forward.setPath("/field_rent.jsp");
		return forward;
	}
}
