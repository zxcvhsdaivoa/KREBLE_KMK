package use_data;

import java.sql.ResultSet;
import java.util.ArrayList;

public class Db_method_player extends Db_method_conn {
	public ArrayList<Player_Info> player() throws Exception { //선수 호출 메소드
		ArrayList<Player_Info> player_list = new ArrayList<Player_Info>();
		conn();
		try{
			ResultSet rs= stm.executeQuery("select * from player;");
			while(rs.next()) {
				Player_Info pl= new Player_Info();
				pl.setPlayer_name(rs.getString("player_name"));
				pl.setPlayer_ko_name(rs.getString("player_ko_name"));
				pl.setPlayer_birth(rs.getDate("player_birth"));
				pl.setPlayer_gender(rs.getString("player_gender"));
				pl.setPlayer_position(rs.getString("player_position"));
				pl.setPlayer_profile(rs.getString("player_profile"));;
				player_list.add(pl);
			}
		}finally {
			diconn();
		}
		return player_list;
	}

	public ArrayList<Director_Info> director() throws Exception { //감독 호출 메소드
		ArrayList<Director_Info> director_list = new ArrayList<Director_Info>();
		conn();
		try{
			ResultSet rs= stm.executeQuery("select * from director;");
			while(rs.next()) {
				Director_Info pl= new Director_Info();
				pl.setDirector_name(rs.getString("director_name"));
				pl.setDirector_ko_name(rs.getString("director_ko_name"));
				pl.setDirecotr_birth(rs.getDate("director_birth"));
				pl.setDirector_gender(rs.getString("director_gender"));
				pl.setDirector_nation(rs.getString("director_nation"));
				pl.setDirector_date_in(rs.getDate("director_datein"));
				pl.setDirector_date_end(rs.getDate("director_dateEnd"));
				director_list.add(pl);
			}
		}finally {
			diconn();
		}
		return director_list;
	}
}
