package dao;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.sql.DataSource;
import vo.SquadInfo;

public class SquadDAO {

	DataSource ds;
	Connection con;
	private static SquadDAO commuDAO;

	private SquadDAO() {
	}

	public static SquadDAO getInstance(){
		if(commuDAO == null){
			commuDAO = new SquadDAO();
		}
		return commuDAO;
	}

	public void setConnection(Connection con){
		this.con = con;
	}



	@SuppressWarnings("resource")
	public int saveSquad(SquadInfo squad){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql="";
		int insertCount=0;

		try{
			sql="insert into mysquad (user_id,mysquad_no,mysquad_name,fomation,director,player1,player2,player3,player4,player5,player6,player7,player8,player9,player10,player11) values(?,default,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
			System.out.println("dfsdf");
			pstmt = con.prepareStatement(sql);
			System.out.println(squad.getUser_id());
			pstmt.setString(1, squad.getUser_id());
			System.out.println(squad.getSquad_name());
			pstmt.setString(2, squad.getSquad_name());
			System.out.println(squad.getFormation());
			pstmt.setString(3, squad.getFormation());
			System.out.println(squad.getDirector());
			pstmt.setString(4, squad.getDirector());
			System.out.println(squad.getPlayer1());
			pstmt.setString(5, squad.getPlayer1());
			System.out.println(squad.getPlayer2());
			pstmt.setString(6, squad.getPlayer2());
			System.out.println(squad.getPlayer3());
			pstmt.setString(7, squad.getPlayer3());
			System.out.println(squad.getPlayer4());
			pstmt.setString(8, squad.getPlayer4());
			System.out.println(squad.getPlayer5());
			pstmt.setString(9, squad.getPlayer5());
			System.out.println(squad.getPlayer6());
			pstmt.setString(10, squad.getPlayer6());
			System.out.println(squad.getPlayer7());
			pstmt.setString(11, squad.getPlayer7());
			System.out.println(squad.getPlayer8());
			pstmt.setString(12, squad.getPlayer8());
			System.out.println(squad.getPlayer9());
			pstmt.setString(13, squad.getPlayer9());
			System.out.println(squad.getPlayer10());
			pstmt.setString(14, squad.getPlayer10());
			System.out.println(squad.getPlayer11());
			pstmt.setString(15, squad.getPlayer11());

			insertCount=pstmt.executeUpdate();

		}catch(Exception ex){
		}finally{
			close(rs);
			close(pstmt);
		}

		return insertCount;

	}

	

	

}
