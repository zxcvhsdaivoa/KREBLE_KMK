package use_data;

import java.sql.ResultSet;
import java.util.ArrayList;



public class Db_method_shop extends Db_method_conn {

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
}
