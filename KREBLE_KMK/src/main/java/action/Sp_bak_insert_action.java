package action;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.Sp_back_insert_service;
import use_data.Shop_prd;
import vo.ActionForward;


public class Sp_bak_insert_action implements Action {

	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		ActionForward forward=null;
		Shop_prd shopprd = new Shop_prd();
		String nowPage = request.getParameter("page");
		shopprd.setPrd_no(request.getParameter("prd_no"));//상품번호
		System.out.println(shopprd.getPrd_no());
		shopprd.setPrd_img(request.getParameter("prd_img"));//상품이미지
		shopprd.setPrd_name(request.getParameter("prd_name"));//상품이름
		shopprd.setPrd_id(request.getParameter("prd_id"));//판매자이름
		shopprd.setPrd_re_id(request.getParameter("prd_re_id"));//구매자이름
		shopprd.setPrd_price(Integer.parseInt(request.getParameter("prd_price")));//상품가격
		shopprd.setPrd_color(request.getParameter("prd_color"));//상품색상
		Sp_back_insert_service shopinservice = new Sp_back_insert_service();
		boolean isWriteSuccess = shopinservice.sp_back_in_Article(shopprd);
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
			forward.setPath("shop_list_action.sp?page="+nowPage);
		}

		return forward;
		
	}  	
	
}