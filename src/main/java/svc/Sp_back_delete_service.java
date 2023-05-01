package svc;

import java.sql.Connection;
import dao.Shop_DAO;
import use_data.Shop_prd;
import static db.JdbcUtil.*;

public class Sp_back_delete_service {
	public boolean sp_back_in_Article(String p_no, String b_id) throws Exception {
		boolean isSuccess = false;

		Shop_DAO shopDAO = Shop_DAO.getInstance();
		Connection con = getConnection();
		shopDAO.setConnection(con);

		int insertCount = shopDAO.deleteBackArticle(p_no, b_id);

		if (insertCount > 0) {
			commit(con);
			isSuccess = true;
		} else {
			rollback(con);
		}
		close(con);

		return isSuccess;
	}

}