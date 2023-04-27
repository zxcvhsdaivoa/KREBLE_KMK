package action;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import use_data.Shop_prd;
import use_data.UserData;
import vo.SquadInfo;

public class Mypage {
	DataSource ds;
	Connection con;
	private static Mypage mpage;

	private Mypage() {
	}

	public static Mypage getInstance(){
		if(mpage == null){
			mpage = new Mypage();
		}
		return mpage;
	}
	public void setConnection(Connection con){
		this.con = con;
	}
	//마이페이지 유저정보 불러오기(userinfo)
	public ArrayList<UserData> userinfo(String id) {
		ArrayList<UserData> alud = new ArrayList<UserData>();
		UserData ud = new UserData();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		try {
			sql = "select * from user where user_id =?;";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				ud.setNick(rs.getString("nick"));
				ud.setUser_prof(rs.getString("user_prof"));
				alud.add(ud);
			}else {
				ud.setNick("No Data");
				ud.setUser_prof("No Data");
			}
			
		}catch(Exception e){
			System.out.println(e);
		}finally {
			close(rs);
			close(pstmt);
		}
		return alud;
	}

	//마이페이지 스쿼드 불러오기(squad)
	public ArrayList<SquadInfo> squadinfo(String id) {
		ArrayList<SquadInfo> alsi = new ArrayList<SquadInfo>();
		SquadInfo si = new SquadInfo();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		try {
			sql = "select * from mysquad where view_count = (select max(view_count) from mysquad where user_id =?);";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				si.setUser_id(rs.getString("user_id"));
				si.setSquad_num(rs.getInt("mysquad_no"));
				si.setSquad_name(rs.getString("mysquad_name"));
				si.setDirector(rs.getString("director"));
				si.setPlayer1(rs.getString("player1"));
				si.setPlayer2(rs.getString("player2"));
				si.setPlayer3(rs.getString("player3"));
				si.setPlayer4(rs.getString("player4"));
				si.setPlayer5(rs.getString("player5"));
				si.setPlayer6(rs.getString("player6"));
				si.setPlayer7(rs.getString("player7"));
				si.setPlayer8(rs.getString("player8"));
				si.setPlayer9(rs.getString("player9"));
				si.setPlayer10(rs.getString("player10"));
				si.setPlayer11(rs.getString("player11"));
				alsi.add(si);
			}else {
				si.setUser_id("No Data");
				si.setSquad_num(0);
				si.setSquad_name("No Data");
				si.setDirector("No Data");
				si.setPlayer1("No Data");
				si.setPlayer2("No Data");
				si.setPlayer3("No Data");
				si.setPlayer4("No Data");
				si.setPlayer5("No Data");
				si.setPlayer6("No Data");
				si.setPlayer7("No Data");
				si.setPlayer8("No Data");
				si.setPlayer9(rs.getString("No Data"));
				si.setPlayer10(rs.getString("No Data"));
				si.setPlayer11(rs.getString("No Data"));
				alsi.add(si);
			}
			
		}catch(Exception e){
			System.out.println(e);
		}finally {
			close(rs);
			close(pstmt);
		}
		return alsi;
	}

	//마이페이지 장바구니 불러오기(cart)
	public ArrayList<Shop_prd> cartinfo(String id) {
		ArrayList<Shop_prd> alsp = new ArrayList<Shop_prd>();
		Shop_prd sp = new Shop_prd();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		try {
			sql = "select * from shop_prd_like where u_id = ?;";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				sp.setPrd_no(rs.getString("p_no"));
				sp.setPrd_id(rs.getString("u_id"));
				alsp.add(sp);
			}
			if(alsp.size() == 0) {
				sp.setPrd_no("No Data");
				sp.setPrd_id("No Data");
			}
			
		}catch(Exception e){
			System.out.println(e);
		}finally {
			close(rs);
			close(pstmt);
		}
		return alsp;
	}

	//마이페이지 관심상품 불러오기(likeinfo)
	public ArrayList<Shop_prd> likeinfo(String id) {
		ArrayList<Shop_prd> alsp = new ArrayList<Shop_prd>();
		Shop_prd sp = new Shop_prd();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		try {
			sql = "select * from shop_back where sb_buy_id = ?;";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				sp.setPrd_no(rs.getString("p_no"));
				sp.setPrd_id(rs.getString("u_id"));
				alsp.add(sp);
			}
			if(alsp.size() == 0) {
				sp.setPrd_no("No Data");
				sp.setPrd_id("No Data");
			}
			
		}catch(Exception e){
			System.out.println(e);
		}finally {
			close(rs);
			close(pstmt);
		}
		return alsp;
	}
}
