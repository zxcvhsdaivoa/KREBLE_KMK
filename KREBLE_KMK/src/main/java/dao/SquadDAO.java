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

	@SuppressWarnings("null")
	public ArrayList<SquadInfo> selectUserSquad(String user_id){
		System.out.println(user_id);
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		SquadInfo squad = null;
		ArrayList<SquadInfo> squadList=new ArrayList<SquadInfo>();
		try{
			pstmt = con.prepareStatement("select * from mysquad where user_id = ?;");
			pstmt.setString(1, user_id);
			rs= pstmt.executeQuery();
			while(rs.next()){
				squad=new SquadInfo();
				squad.setUser_id(rs.getString("user_id"));
				squad.setSquad_num(rs.getInt("mysquad_no"));
				squad.setSquad_name(rs.getString("mysquad_name"));
				squad.setFormation(rs.getString("fomation"));
				squad.setDirector(rs.getString("director"));
				squad.setPlayer1(rs.getString("player1"));
				squad.setPlayer2(rs.getString("player2"));
				squad.setPlayer3(rs.getString("player3"));
				squad.setPlayer4(rs.getString("player4"));
				squad.setPlayer5(rs.getString("player5"));
				squad.setPlayer6(rs.getString("player6"));
				squad.setPlayer7(rs.getString("player7"));
				squad.setPlayer8(rs.getString("player8"));
				squad.setPlayer9(rs.getString("player9"));
				squad.setPlayer10(rs.getString("player10"));
				squad.setPlayer11(rs.getString("player11"));
				squad.setDisclose(rs.getString("disclose"));
				squadList.add(squad);
			}
		}catch(Exception ex){
		}finally{
			close(rs);
			close(pstmt);
		}

		return squadList;
	}

	
	@SuppressWarnings("null")
	public int selectSquadLastNo(){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int last_no=0;
		try{
			pstmt = con.prepareStatement("select mysquad_no from mysquad ORDER BY mysquad_no DESC LIMIT 1;");
			rs= pstmt.executeQuery();
			if(rs.next()){
				last_no=rs.getInt("mysquad_no");
			}
		}catch(Exception ex){
		}finally{
			close(rs);
			close(pstmt);
		}

		return last_no;

	}
	
	
	@SuppressWarnings("resource")
	public int saveSquad(SquadInfo squad){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql="";
		int insertCount=0;

		try{
			sql="insert into mysquad (user_id,mysquad_no,mysquad_name,fomation,director,player1,player2,player3,player4,player5,player6,player7,player8,player9,player10,player11) values(?,default,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, squad.getUser_id());
			pstmt.setString(2, squad.getSquad_name());
			pstmt.setString(3, squad.getFormation());
			pstmt.setString(4, squad.getDirector());
			pstmt.setString(5, squad.getPlayer1());
			pstmt.setString(6, squad.getPlayer2());
			pstmt.setString(7, squad.getPlayer3());
			pstmt.setString(8, squad.getPlayer4());
			pstmt.setString(9, squad.getPlayer5());
			pstmt.setString(10, squad.getPlayer6());
			pstmt.setString(11, squad.getPlayer7());
			pstmt.setString(12, squad.getPlayer8());
			pstmt.setString(13, squad.getPlayer9());
			pstmt.setString(14, squad.getPlayer10());
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
