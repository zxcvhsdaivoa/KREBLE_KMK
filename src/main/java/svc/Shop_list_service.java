package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.util.ArrayList;

import dao.Shop_DAO;
import use_data.Shop_prd;

public class Shop_list_service {

	public int getListCount() throws Exception {
		int listCount = 0;
		Connection con = getConnection();
		Shop_DAO shopDAO = Shop_DAO.getInstance();
		shopDAO.setConnection(con);
		listCount = shopDAO.selectListCount();
		close(con);
		return listCount;

	}

	public ArrayList<Shop_prd> getArticleList(int page, int limit) throws Exception {

		ArrayList<Shop_prd> articleList = null;
		Connection con = getConnection();
		Shop_DAO shopDAO = Shop_DAO.getInstance();
		shopDAO.setConnection(con);
		articleList = shopDAO.selectArticleList(page, limit);
		close(con);
		return articleList;

	}

}
