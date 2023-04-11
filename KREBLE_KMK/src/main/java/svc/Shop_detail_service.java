package svc;

import java.sql.Connection;

import dao.Shop_DAO;
import use_data.Shop_prd;

import static db.JdbcUtil.*;

public class Shop_detail_service {

	public Shop_prd getArticle(int board_num) throws Exception{

		Shop_prd article = null;
		Connection con = getConnection();
		Shop_DAO shopDAO = Shop_DAO.getInstance();
		shopDAO.setConnection(con);
		int updateCount = shopDAO.updateReadCount(board_num);
		
		if(updateCount > 0){
			commit(con);
		}
		else{
			rollback(con);
		}
		
		article = shopDAO.selectArticle(board_num);
		close(con);
		return article;
		
	}

}
