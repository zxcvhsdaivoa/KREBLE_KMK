package svc;

import java.sql.Connection;

import dao.Shop_DAO;
import use_data.Shop_prd;

import static db.JdbcUtil.*;

public class Shop_prd_mody_service {

	public void getArticle(String p_no) throws Exception{

		Connection con = getConnection();
		Shop_DAO shopDAO = Shop_DAO.getInstance();
		shopDAO.setConnection(con);
		shopDAO.selectArticle(p_no);
		close(con);
		
	}

}
