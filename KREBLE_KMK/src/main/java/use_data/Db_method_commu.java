package use_data;

import java.sql.ResultSet;
import java.util.ArrayList;



public class Db_method_commu extends Db_method_conn {
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
	
}
