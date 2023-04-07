package use_data;

import java.sql.ResultSet;
import java.util.ArrayList;



public class Db_method_user extends Db_method_conn {
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
}
