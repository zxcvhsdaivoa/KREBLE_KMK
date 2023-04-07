package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.util.ArrayList;
import dao.SquadDAO;
import vo.SquadInfo;

public class UserSquadListService {

	public ArrayList<SquadInfo> getArticleList(String user_id) throws Exception{
		
		ArrayList<SquadInfo> squadList = null;
		Connection con = getConnection();
		SquadDAO commuDAO = SquadDAO.getInstance();
		commuDAO.setConnection(con);
		squadList = commuDAO.selectUserSquad(user_id);
		close(con);
		return squadList;
		
	}

}
