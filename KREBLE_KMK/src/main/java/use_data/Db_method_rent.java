package use_data;

import java.sql.ResultSet;
import java.util.ArrayList;



public class Db_method_rent extends Db_method_conn {
	
	//대여/예약(최승혁) 리뷰 게시판 메소드들
	public ArrayList<ReviewData> db_review_select() throws Exception {
		ArrayList<ReviewData> reviewList = new ArrayList<ReviewData>();
		try{
			conn();
			if(con == null){
				throw new Exception("데이터베이스에 연결할 수 없습니다.");
			}
			stm=con.createStatement();
			ResultSet rs= stm.executeQuery("select*from rent_review order by review_num desc;");
			while(rs.next()){
				ReviewData ob=new ReviewData();
				ob.setNum(rs.getInt("review_num"));
				ob.setId(rs.getString("user_id"));
				ob.setTitle(rs.getString("review_title"));
				ob.setPut(rs.getString("review_content"));
				ob.setGood(rs.getInt("review_good"));
				ob.setView(rs.getInt("review_readcount"));
				ob.setDate(rs.getString("review_date"));
				ob.setRating(rs.getInt("review_rating"));
				reviewList.add(ob);
			}
		}finally {
			diconn();
		}
		return reviewList;
	}
	
	public ReviewData review_list_check(String num) throws Exception {
		ReviewData list=new ReviewData();
		try{
			conn();
			if(con == null){
				throw new Exception("데이터베이스에 연결할 수 없습니다.");
			}
			stm=con.createStatement();
			ResultSet rs= stm.executeQuery("select * from rent_review where review_num = '"+ num +"';");
			if(rs.next()){
				list.setNum(rs.getInt("review_num"));
				list.setId(rs.getString("user_id"));
				list.setTitle(rs.getString("review_title"));
				list.setPut(rs.getString("review_content"));
				list.setGood(rs.getInt("review_good"));
				list.setView(rs.getInt("review_readcount"));
				list.setDate(rs.getString("review_date"));
				list.setRating(rs.getInt("review_rating"));
			}
		}finally {
			diconn();
		}
		return list;
	}
	
	//////리뷰 게시판 인서트 메소드
	public void db_review_insert(ReviewData review_insr) throws Exception  {
		  //insr에 있는 자료가 여러개 이므로 객체를 생성해서 그안에 자료를 담아놓고 객체를 리턴 받은것.
			String idin=review_insr.getId();
			String titlein=review_insr.getTitle();
			String writein=review_insr.getPut();
			Integer ratingin=review_insr.getRating();
			
			try{
				conn();
				if(con == null){
					throw new Exception("데이터베이스에 연결할 수 없습니다.");
				}
				stm=con.createStatement();
				String command = String.format("insert into rent_review values (default,'%s','%s','%s',default,default,now(),%s)",idin,titlein,writein,ratingin);
				int rowNum = stm.executeUpdate(command);
				if(rowNum<1){
					throw new Exception("데이터를 DB에 입력할 수 없습니다.");
				}
		  }finally{
			  diconn();
		  }
		  
	}
	public void db_review_update(ReviewData review_upda) throws Exception  {
			Integer numin=review_upda.getNum();
			String titlein=review_upda.getTitle();
			String putin=review_upda.getPut();
			Integer ratingin=review_upda.getRating();
			
			try{
				conn();
				if(con == null){
					throw new Exception("데이터베이스에 연결할 수 없습니다.");
				}
				stm=con.createStatement();
				String command = String.format("update rent_review set review_title:='%s',review_content:='%s',review_rating:=%s where review_num=%s",titlein,putin,ratingin,numin);
				int rowNum = stm.executeUpdate(command);
				if(rowNum<1){
					throw new Exception("데이터를 DB에 입력할 수 없습니다.");
				}
		  }finally{
			  diconn();
		  }
		  
	}
	
	public void  db_review_delete(String num) throws Exception  {
	
			try{
				conn();
				if(con == null){
					throw new Exception("데이터베이스에 연결할 수 없습니다.");
				}
				stm=con.createStatement();
				String command = String.format("delete from rent_review where review_num = '"+ num +"';");
				int rowNum = stm.executeUpdate(command);
				if(rowNum<1){
					throw new Exception("데이터를 DB에 입력할 수 없습니다.");
				}
		  }finally{
			  diconn();
		  }
		  
	}

	public void db_review_count(String num) throws Exception  {
		
		try{
			conn();
			if(con == null){
				throw new Exception("데이터베이스에 연결할 수 없습니다.");
			}
			stm=con.createStatement();
			String command = String.format("update rent_review set review_readcount:= review_readcount + 1 where review_num = '"+ num +"';");
			int rowNum = stm.executeUpdate(command);
			if(rowNum<1){
				throw new Exception("데이터를 DB에 입력할 수 없습니다.");
			}
	  }finally{
		  diconn();
	  }
	  
}
	public void db_good_count(String num) throws Exception  {
			
			try{
				conn();
				if(con == null){
					throw new Exception("데이터베이스에 연결할 수 없습니다.");
				}
				stm=con.createStatement();
				String command = String.format("update rent_review set review_good:= review_good + 1 where review_num = '"+ num +"';");
				int rowNum = stm.executeUpdate(command);
				if(rowNum<1){
					throw new Exception("데이터를 DB에 입력할 수 없습니다.");
				}
		  }finally{
			  diconn();
		  }
	  
	}

	public ArrayList<Player_Info> player() throws Exception { //선수 호출 메소드
		ArrayList<Player_Info> player_list = new ArrayList<Player_Info>();
		conn();
		try{
			ResultSet rs= stm.executeQuery("select * from player;");
			while(rs.next()) {
				Player_Info pl= new Player_Info();
				pl.setPlayer_name(rs.getString("player_name"));
				System.out.println(rs.getString("player_name"));
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
				System.out.println(rs.getString("director_name"));
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

	
	//예약/대여 시민구장 정보,최승혁 db
	
	public KreblechoiData field_list_check(String id) throws Exception {
		KreblechoiData field_list=new KreblechoiData();
		try{
			conn();
			if(con == null){
				throw new Exception("데이터베이스에 연결할 수 없습니다.");
			}
			stm=con.createStatement();
			ResultSet rs= stm.executeQuery("select * from field_info where field_id = '" + id + "';");
			if(rs.next()){
				field_list.setField_id(rs.getString("field_id"));
				field_list.setFullname(rs.getString("field_fullname"));
				field_list.setField_price(rs.getInt("field_price"));
				field_list.setField_name(rs.getString("field_name"));
				field_list.setField_location(rs.getString("field_location"));
				field_list.setField_map(rs.getString("field_map"));
				field_list.setField_area(rs.getInt("field_area"));
				field_list.setField_usetime(rs.getString("field_usetime"));
				field_list.setField_facility(rs.getString("field_facility"));
				field_list.setField_call(rs.getString("field_call"));
			}
		}finally {
			diconn();
		}
		return field_list;
	}
	
}
