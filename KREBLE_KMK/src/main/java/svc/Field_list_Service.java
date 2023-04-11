package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.util.ArrayList;
import dao.FieldDAO;
import vo.KreblechoiData;

public class Field_list_Service {

	public int getListCount() throws Exception{
		int listCount = 0;
		Connection con = getConnection();
		FieldDAO fieldDAO = FieldDAO.getInstance();
		fieldDAO.setConnection(con);
		listCount = fieldDAO.selectListCount();
		close(con);
		return listCount;
		
	}

	public ArrayList<KreblechoiData> getArticleList() throws Exception{
		
		ArrayList<KreblechoiData> articleList = null;
		Connection con = getConnection();
		FieldDAO fieldDAO = fieldDAO.getInstance();
		fieldDAO.setConnection(con);
		articleList = fieldDAO.selectArticleList();
		close(con);
		return articleList;
		
	}

}

