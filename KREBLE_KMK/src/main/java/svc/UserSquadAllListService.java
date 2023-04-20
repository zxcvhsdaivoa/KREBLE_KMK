package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.SquadDAO;
import vo.SquadInfo;

public class UserSquadAllListService {

	public ArrayList<SquadInfo> getAllList(int page, int limit) throws Exception{
		ArrayList<SquadInfo> squadList = null;
		Connection con = getConnection();
		SquadDAO commuDAO = SquadDAO.getInstance();
		commuDAO.setConnection(con);
		squadList = commuDAO.selectAllSquad(page,limit);
		
		close(con);
		return squadList;
	}
	
	public int getAllListCount() throws Exception{
		int count=0;
		Connection con = getConnection();
		SquadDAO commuDAO = SquadDAO.getInstance();
		commuDAO.setConnection(con);
		count = commuDAO.selectAllSquadCount();
		
		close(con);
		return count;
	}
}
