package use_data;

import java.sql.ResultSet;
import java.util.ArrayList;

import vo.SquadInfo;

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

	public Player_Info squad_player(SquadInfo squad, int no) throws Exception { //선수 호출 메소드
		Player_Info player = new Player_Info();
		String player_name=null;
		if(no==1) {
			player_name=squad.getPlayer1();
		} else if(no==2) {
			player_name=squad.getPlayer2();
		} else if(no==3) {
			player_name=squad.getPlayer3();
		} else if(no==4) {
			player_name=squad.getPlayer4();
		} else if(no==5) {
			player_name=squad.getPlayer5();
		} else if(no==6) {
			player_name=squad.getPlayer6();
		} else if(no==7) {
			player_name=squad.getPlayer7();
		} else if(no==8) {
			player_name=squad.getPlayer8();
		} else if(no==9) {
			player_name=squad.getPlayer9();
		} else if(no==10) {
			player_name=squad.getPlayer10();
		} else if(no==11) {
			player_name=squad.getPlayer11();
		}
		conn();
		try{
			ResultSet rs= stm.executeQuery("select * from player where player_name='"+player_name+"';");
			while(rs.next()) {
				player.setPlayer_name(rs.getString("player_name"));
				player.setPlayer_ko_name(rs.getString("player_ko_name"));
				player.setPlayer_position(rs.getString("player_position"));
			}
		}finally {
			diconn();
		}
		return player;
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
	
	public Director_Info squad_director(SquadInfo squad) throws Exception { //선수 호출 메소드
		Director_Info director = new Director_Info();
		String director_name=squad.getDirector();
		
		conn();
		try{
			ResultSet rs= stm.executeQuery("select * from director where director_name='"+director_name+"';");
			while(rs.next()) {
				director.setDirector_name(rs.getString("director_name"));
				director.setDirector_ko_name(rs.getString("director_ko_name"));
			}
		}finally {
			diconn();
		}
		return director;
	}
}
