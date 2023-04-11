package action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.Prd_re_delete_service;
import use_data.Shop_prd;
import use_data.UserData;
import vo.ActionForward;

public class Shop_re_delete_action extends use_data.Db_method_conn implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		String p_no=request.getParameter("re_no");
		String nowPage = request.getParameter("page");

		Prd_re_delete_service prd_re_del_svc = new Prd_re_delete_service();


		return forward;
	}

}
