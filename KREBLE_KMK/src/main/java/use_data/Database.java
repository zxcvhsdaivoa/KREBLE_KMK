package use_data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;



public class Database {
	Connection con = null;
	Statement stm = null;
	public void conn() throws Exception {//연결 메소드
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/kreble","root","qw4589");
			if(con == null){
				throw new Exception("데이터베이스에 연결할 수 없습니다.");
			}
			stm=con.createStatement();
		} catch (ClassNotFoundException e) {
			
		}
	}
	public void diconn() {//연결 해제 메소드
		try{
			stm.close();
			con.close();
		}catch(Exception ignored){
			
		}
	}
	
	
	
	public String login_data(String id, String pw) throws Exception {
		String login;
		try{
			conn();
			ResultSet rs= stm.executeQuery("select user_id from user where user_id='"+id+"' AND user_pass='"+pw+"';");
			if(rs.next()){
				login="true";
			}
			else {
				login="false";
			}
		}finally {
			diconn();
		}
		return login;
	}
	
	public ArrayList<String> join_member_idcheck() throws Exception {
		ArrayList<String> idList = new ArrayList<String>();
		try{
			conn();
			ResultSet rs= stm.executeQuery("select user_id from user;");
			while(rs.next()){
				idList.add(rs.getString("user_id"));
			}
		}finally {
			diconn();
		}
		return idList;
	}
	
	public void join_member_succass(UserData ud) throws Exception {
		try{
			conn();
			String command = String.format("insert into user values('"+ud.getId()+"','임시닉네임1234' ,'"+ud.getName()+"','"+ud.getPw()+"','"+ud.getPh()+"','"+ud.getEmail()+"','"+ud.getAddress()+"','"+ud.getGender()+"',now(), now(), default);");
			int rowNum = stm.executeUpdate(command);
			if(rowNum<1){
				throw new Exception("데이터를 DB에 입력할 수 없습니다.");
			}
		}finally {
			diconn();
		}
	}
	
	
	public ArrayList<CommunityData> commu_all() throws Exception { //커뮤니티 호출 메소드
		ArrayList<CommunityData> si = new ArrayList<CommunityData>();
		conn();
		try{
			ResultSet rs= stm.executeQuery("select * from community order by commu_no desc;");
			while(rs.next()) {
				CommunityData cdb= new CommunityData();
				cdb.setComu_num(rs.getInt("commu_no"));
				cdb.setId(rs.getString("user_id"));
				cdb.setCategory(rs.getString("category"));
				cdb.setComu_title(rs.getString("commu_title"));
				cdb.setComu_write(rs.getString("commu_write"));
				cdb.setComu_date(rs.getString("commu_wrday"));
				cdb.setCount(rs.getInt("commu_readcount"));
				si.add(cdb);
			}
		}finally {
			diconn();
		}
		return si;
	}
	
	public ArrayList<CommunityData> commu_cate(String cate) throws Exception { //커뮤니티 카테고리별 호출 메소드
		ArrayList<CommunityData> si = new ArrayList<CommunityData>();
		conn();
		try{
			ResultSet rs= stm.executeQuery("select * from community where category='"+cate+"' order by commu_no desc;");
			while(rs.next()) {
				CommunityData cdb= new CommunityData();
				cdb.setComu_num(rs.getInt("commu_no"));
				cdb.setId(rs.getString("user_id"));
				cdb.setCategory(rs.getString("category"));
				cdb.setComu_title(rs.getString("commu_title"));
				cdb.setComu_write(rs.getString("commu_write"));
				cdb.setComu_date(rs.getString("commu_wrday"));
				cdb.setCount(rs.getInt("commu_readcount"));
				si.add(cdb);
			}
		}finally {
			diconn();
		}
		return si;
	}
	
	public CommunityData commu_one(int comu_no) throws Exception { //커뮤니티 페이지1개 호출 메소드
		conn();
		CommunityData cdb= new CommunityData();
		try{
			ResultSet rs= stm.executeQuery("select * from community where commu_no="+comu_no+";");
			if(rs.next()) {
				cdb.setComu_num(rs.getInt("commu_no"));
				cdb.setId(rs.getString("user_id"));
				cdb.setCategory(rs.getString("category"));
				cdb.setComu_title(rs.getString("commu_title"));
				cdb.setComu_write(rs.getString("commu_write"));
				cdb.setComu_date(rs.getString("commu_wrday"));
				cdb.setCount(rs.getInt("commu_readcount"));
			}
		}finally {
			diconn();
		}
		return cdb;
	}
	
	public ArrayList<CommunityData> commu_search(String select, String text) throws Exception { //커뮤니티 검색 메소드
		conn();
		ArrayList<CommunityData> si = new ArrayList<CommunityData>();
		try{
			StringBuilder commandBuilder = new StringBuilder();
			commandBuilder.append("select * from community");
			if(select.equals("search_title")) {
				commandBuilder.append(" where commu_title like '%"+text+"%'");
			}
			else if(select.equals("search_title_write")) {
				commandBuilder.append(" where commu_title like '%"+text+"%' or commu_write like '%"+text+"%'");
			}
			else if(select.equals("search_name")) {
				commandBuilder.append(" where user_id='"+text+"'");
			}
			commandBuilder.append(" order by commu_no desc;");
			String aa = commandBuilder.toString();
			ResultSet rs = stm.executeQuery(aa);
			while(rs.next()) {
				CommunityData cdb= new CommunityData();
				cdb.setComu_num(rs.getInt("commu_no"));
				cdb.setId(rs.getString("user_id"));
				cdb.setCategory(rs.getString("category"));
				cdb.setComu_title(rs.getString("commu_title"));
				cdb.setComu_write(rs.getString("commu_write"));
				cdb.setComu_date(rs.getString("commu_wrday"));
				cdb.setCount(rs.getInt("commu_readcount"));
				si.add(cdb);
			}
		}finally {
			diconn();
		}
		return si;
	}
	
	public int commu_last() throws Exception { //커뮤니티 페이지1개 호출 메소드
		conn();
		int last_no =0;
		try{
			ResultSet rs= stm.executeQuery("select max(commu_no) from community;");
			if(rs.next()) {
				last_no=rs.getInt("max(commu_no)");
			}
		}finally {
			diconn();
		}
		return last_no;
	}
	
	public void commu_write(CommunityData cmd) throws Exception { //커뮤니티 글 작성
		try{
			conn();
			String command = String.format("insert into community values('"+cmd.getId()+"',default,'"+cmd.getCategory()+"','"+cmd.getComu_title()+"','"+cmd.getComu_write()+"','a',0,now());");
			int rowNum = stm.executeUpdate(command);
			if(rowNum<1){
				throw new Exception("데이터를 DB에 입력할 수 없습니다.");
			}
		}finally {
			diconn();
		}
	}
	
	public void commu_change(CommunityData cmd) throws Exception { //커뮤니티 글 수정
		try{
			conn();
			String command = String.format("update community set category:='%s',commu_title:='%s',commu_write:='%s' where commu_no=%s AND user_id='%s'",cmd.getCategory(),cmd.getComu_title(),cmd.getComu_write(),cmd.getComu_num(),cmd.getId());
			int rowNum = stm.executeUpdate(command);
			if(rowNum<1){
				throw new Exception("데이터를 DB에 입력할 수 없습니다.");
			}
		}finally {
			diconn();
		}
	}
	
	public void commu_delete(String no, String id) throws Exception { //커뮤니티 글 삭제
		try{
			conn();
			String command = String.format("delete from community where commu_no=%s and user_id='%s';",no,id);
			int rowNum = stm.executeUpdate(command);
			if(rowNum<1){
				throw new Exception("데이터를 DB에 입력할 수 없습니다.");
			}
		}finally {
			diconn();
		}
	}

//	<!--  카테 / 사진 / 상품명 / 상품가격 / 색상 / 등록자 / 등록일	 -->
//		상품리스트 로드
	  public ArrayList<Shop_prd> shop_prd_list() throws Exception{
		  ArrayList<Shop_prd> board = new ArrayList<Shop_prd>();
		  try{
			  conn();
			    if(con == null){
			      throw new Exception("데이터베이스에 연결할 수 없습니다.");
			    }

			    stm = con.createStatement();
			    ResultSet rs = stm.executeQuery("select * from product;");

				  
			    while(rs.next()) {
			    	Shop_prd aa = new Shop_prd();
			    	aa.setPrd_no(rs.getString("prd_no"));
			    	aa.setPrd_cata(rs.getString("prd_cata"));
			    	aa.setPrd_img(rs.getString("prd_img"));		    	
			    	aa.setPrd_name(rs.getString("prd_name"));		    	
			    	aa.setPrd_price(rs.getInt("prd_price"));		    	
			    	aa.setPrd_color(rs.getString("prd_color"));		    	
			    	aa.setPrd_id(rs.getString("prd_id"));		    	
			    	aa.setPrd_date(rs.getString("prd_date"));
			    	board.add(aa);
			    }
		  		}catch(Exception ignored){

			  }finally{
				  diconn();
			  }
		  
		  return board;
	  }
	
//	상품디테일 로드
	  public Shop_prd shop_prd_detail(String p_no) throws Exception{
	    	Shop_prd aa = new Shop_prd();
		  try{
			  conn();
			    if(con == null){
			      throw new Exception("데이터베이스에 연결할 수 없습니다.");
			    }
			    stm = con.createStatement();
			    ResultSet rs = stm.executeQuery("select * from product where prd_no = '" + p_no + "';");
			    if(rs.next()) {		    	
			    	aa.setPrd_img(rs.getString("prd_img"));	
			    	aa.setPrd_name(rs.getString("prd_name"));	
			    	aa.setPrd_cata(rs.getString("prd_cata"));	
			    	aa.setPrd_id(rs.getString("prd_id"));	
			    	aa.setPrd_meter(rs.getString("prd_meter"));	
			    	aa.setPrd_note(rs.getString("prd_note"));	
			    	aa.setPrd_price(rs.getInt("prd_price"));	
			    	aa.setPrd_size(rs.getString("prd_size"));	
			    	aa.setPrd_color(rs.getString("prd_color"));	
			    	aa.setPrd_date(rs.getString("prd_date"));	
			    	aa.setPrd_create(rs.getString("prd_create"));	
			    	aa.setPrd_qaul(rs.getString("prd_qaul"));	
			    	aa.setPrd_as(rs.getString("prd_as"));	
			    	aa.setPrd_qant(rs.getInt("prd_qant"));	
			    	aa.setPrd_content(rs.getString("prd_content"));	
			    }
		  		}catch(Exception ignored){

			  }finally{
				  diconn();
			  }
		  return aa;
	  }
	  
	  
	//  게시판 로드
	  public ArrayList<Shop_reform_db> shop_board() throws Exception{
		  ArrayList<Shop_reform_db> board = new ArrayList<Shop_reform_db>();
		  try{
			  conn();
			    if(con == null){
			      throw new Exception("데이터베이스에 연결할 수 없습니다.");
			    }
			    stm = con.createStatement();
			    ResultSet rs = stm.executeQuery("select * from shop_reform;");
			    while(rs.next()) {
			    	Shop_reform_db ob = new Shop_reform_db();
			    	ob.setRenum(rs.getInt("shop_renum"));		    	
			    	ob.setRecata(rs.getString("shop_recata"));		    	
			    	ob.setRetitle(rs.getString("shop_retitle"));		    	
			    	ob.setReid(rs.getString("shop_reid"));		    	
			    	ob.setRetrade(rs.getString("shop_retrade"));		    	
			    	ob.setRedate(rs.getString("shop_redate"));		    	
			    	board.add(ob);
			    }
		  		}catch(Exception ignored){

			  }finally{
				  diconn();
			  }
		  
		  return board;
	  }
//	  게시판 서치
	  public ArrayList<Shop_reform_db> shop_board_sc(String re_trade, String re_title) throws Exception{
		  ArrayList<Shop_reform_db> board = new ArrayList<Shop_reform_db>();
		  if(re_title!="") {
		  re_title.trim().toLowerCase();
		  }
		  try{
			  conn();
			    if(con == null){
				      throw new Exception("데이터베이스에 연결할 수 없습니다.");
				    }
				    stm = con.createStatement();
				    
				    StringBuilder commandBuilder = new StringBuilder();
				    commandBuilder.append("select * from shop_reform");
				    if(re_trade != "" || re_title != "") {
				        commandBuilder.append(" where ");
				    }
				    if(re_trade!="") {
				    	commandBuilder.append("shop_retrade='"+re_trade+"'");
				    }
				    
				    if(re_trade!="" && re_title!="") {
				    	commandBuilder.append("and shop_retitle like '%"+re_title+"%'");
				    }else if(re_trade=="" && re_title!="") {
				    	commandBuilder.append("shop_retitle like '%"+re_title+"%'");
				    }
				    commandBuilder.append(";");
				    
				    String aa = commandBuilder.toString();
				    ResultSet rs = stm.executeQuery(aa);
				    while(rs.next()) {
				    	Shop_reform_db ob = new Shop_reform_db();
				    	ob.setRenum(rs.getInt("shop_renum"));		    	
				    	ob.setRecata(rs.getString("shop_recata"));		    	
				    	ob.setRetitle(rs.getString("shop_retitle"));		    	
				    	ob.setReid(rs.getString("shop_reid"));		    	
				    	ob.setRetrade(rs.getString("shop_retrade"));		    	
				    	ob.setRedate(rs.getString("shop_redate"));		    	
				    	board.add(ob);
				    }
			    while(rs.next()) {
			    }
		  		}catch(Exception ignored){

			  }finally{
				  diconn();
			  }
		  return board;
	  }
	  // 카테고리 서치
	  public ArrayList<Shop_reform_db> shop_board_casc(String cata) throws Exception{
		  ArrayList<Shop_reform_db> board = new ArrayList<Shop_reform_db>();
		  try{
			  conn();
			    if(con == null){
				      throw new Exception("데이터베이스에 연결할 수 없습니다.");
				    }
				    stm = con.createStatement();
				    ResultSet rs = stm.executeQuery("select * from shop_reform where shop_recata = '" + cata + "';");
				    while(rs.next()) {
				    	Shop_reform_db ob = new Shop_reform_db();
				    	ob.setRenum(rs.getInt("shop_renum"));		    	
				    	ob.setRecata(rs.getString("shop_recata"));		    	
				    	ob.setRetitle(rs.getString("shop_retitle"));		    	
				    	ob.setReid(rs.getString("shop_reid"));		    	
				    	ob.setRetrade(rs.getString("shop_retrade"));		    	
				    	ob.setRedate(rs.getString("shop_redate"));		    	
				    	board.add(ob);
				    }
		  		}catch(Exception ignored){

			  }finally{
				  diconn();
			  }
		  return board;
	  }
	  
	  //  게시글 로드
	  public Shop_reform_db shop_board_1(String aa) throws Exception{
		  Shop_reform_db board = new Shop_reform_db();
		  try{
			  conn();
			    if(con == null){
			      throw new Exception("데이터베이스에 연결할 수 없습니다.");
			    }
			    stm = con.createStatement();
			    ResultSet rs = stm.executeQuery("select * from shop_reform where shop_renum = " + aa + ";");
			    if(rs.next()) {
			    board.setRequnt(rs.getInt("shop_requnt"));
			    board.setRecata(rs.getString("shop_recata"));
			    board.setRetitle(rs.getString("shop_retitle"));
			    board.setReid(rs.getString("shop_reid"));
			    board.setRetrade(rs.getString("shop_retrade"));
			    board.setRedate(rs.getString("shop_redate"));
			    board.setRetext(rs.getString("shop_retext"));
			    }
		  		}catch(Exception ignored){
			  }finally{
				  diconn();
			  }
		  
		  return board;
	  }

	//입력메소드
	  public void board_input(Shop_reform_db aal) throws Exception{
	  	  String cata = aal.getRecata();
	  	  String title = aal.getRetitle();
	  	  String id = aal.getReid();
	  	  String trade = aal.getRetrade(); 
	  	  int qunt = aal.getRequnt();
	  	  String text = aal.getRetext();
	  	  String date = aal.getRedate();
	  	  try{
	  		  conn();
	  		if(con == null){
	  			throw new Exception("데이터베이스에 연결할 수 없습니다.");
	  		}
	  		stm=con.createStatement();
	  	    String command = String.format("insert into shop_reform values(default,'%s','%s','%s','%s',%s,%s,'%s')",cata,title,id,trade,qunt,date,text);
	  		int rowNum = stm.executeUpdate(command);
	  		if(rowNum<1){
	  			throw new Exception("데이터를 DB에 입력할 수 없습니다.");
	  		}
	  	    

			}catch(Exception ignored){
	  	  }finally{
	  		  diconn();
	  	  }
	  }
	  
	  
	  //수정메소드
	  public void board_mody(Shop_reform_db aal) throws Exception{
		  try{
			  conn();
			if(con == null){
				throw new Exception("데이터베이스에 연결할 수 없습니다.");
			}
			stm=con.createStatement();
		    String command = String.format("update shop_reform set shop_recata = '"+aal.getRecata()+"',shop_retitle= '"+aal.getRetitle()+"',shop_retrade='"+aal.getRetrade()+"',shop_requnt = "+aal.requnt+",shop_retext = '"+aal.getRetitle()+"' where shop_renum="+aal.getRenum()+";");
			int rowNum = stm.executeUpdate(command);
			if(rowNum<1){
				throw new Exception("데이터를 DB에 입력할 수 없습니다.");
			}
			}catch(Exception ignored){
		  }finally{
			  diconn();
		  }
	}
	
	
	//삭제메소드
	public void dbdelete(String renum) throws Exception {
		try{
			conn();
			if(con == null){
				throw new Exception("데이터베이스에 연결할 수 없습니다.");
			}
			stm=con.createStatement();
			String command = String.format("delete from shop_reform where shop_renum = " + renum + ";");
			int comm = stm.executeUpdate(command);
			if(comm<1) {
				throw new Exception("데이터를 삭제할 수 없습니다.");
			}

		}catch(Exception ignored){
		}finally {
			diconn();
		}
	}
	
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
