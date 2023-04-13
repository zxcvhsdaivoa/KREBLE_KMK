package action;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.Shop_insert_service;
import svc.Sp_re_inser_service;
import use_data.Shop_prd;
import vo.ActionForward;


public class Sp_bak_insert_action implements Action {

	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		ActionForward forward=null;
		Shop_prd shopprd = null;
		String p_no = request.getParameter("prd_no");//상품번호
		String p_img = request.getParameter("prd_img");//상품이미지
		String p_name = request.getParameter("prd_name");//상품이름
		String p_price = request.getParameter("prd_price");//상품가격
		String p_color = request.getParameter("prd_color");//상품색상
		String nowPage = request.getParameter("page");
		//리플번호PKAI
		shopprd.setPrd_re_sc(Integer.parseInt(request.getParameter("prd_re_sc")));//평점
		Sp_re_inser_service shopinservice = new Sp_re_inser_service();
		boolean isWriteSuccess = shopinservice.prd_re_in_Article(shopprd);
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
			forward.setPath("shop_prd_detail.sp?prd_no="+request.getParameter("prd_no"));
		}

		return forward;
		
	}  	
	
}