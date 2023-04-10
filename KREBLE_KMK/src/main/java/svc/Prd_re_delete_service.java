package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;
import java.sql.Connection;
import dao.Shop_DAO;

public class Prd_re_delete_service {

	public boolean removeArticle(String prd_re_num) throws Exception{
		
		boolean isRemoveSuccess = false;
		Connection con = getConnection();
		Shop_DAO sdao = Shop_DAO.getInstance();
		sdao.setConnection(con);
		int deleteCount = sdao.deleteArticle(prd_re_num);
		
		if(deleteCount > 0){
			commit(con);
			isRemoveSuccess=true;
		}
		else{
			rollback(con);
		}
		
		close(con);
		return isRemoveSuccess;
	}

}
