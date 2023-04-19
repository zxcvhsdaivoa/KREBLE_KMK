package dao;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.sql.DataSource;
import vo.KreblechoiData;
import vo.field_save_Data;

public class FieldDAO {
	DataSource ds;
	Connection con;
	private static FieldDAO fieldDAO;
	
	private FieldDAO() {
	}
	
	public static FieldDAO getInstance(){
		if(fieldDAO == null){
			fieldDAO = new FieldDAO();
		}
		return fieldDAO;
	}

	public void setConnection(Connection con){
		this.con = con;
	}
	
	//예약/대여 시민구장 정보,최승혁 db

	public KreblechoiData field_list_check(String id) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;		
		KreblechoiData field_list=null;

		try{
			pstmt = con.prepareStatement("select * from field_info where field_id = '" + id + "';");
			rs= pstmt.executeQuery();

			if(rs.next()){
				field_list=new KreblechoiData();
				field_list.setField_id(rs.getString("field_id"));
				field_list.setFullname(rs.getString("field_fullname"));
				field_list.setField_image(rs.getString("field_image"));
				field_list.setField_price(rs.getInt("field_price"));
				field_list.setField_name(rs.getString("field_name"));
				field_list.setField_location(rs.getString("field_location"));
				field_list.setField_map(rs.getString("field_map"));
				field_list.setField_area(rs.getInt("field_area"));
				field_list.setField_usetime(rs.getString("field_usetime"));
				field_list.setField_facility(rs.getString("field_facility"));
				field_list.setField_call(rs.getString("field_call"));
			}
		}catch(Exception ex){
		}finally {
			close(rs);
			close(pstmt);
		}
		return field_list;
	}
	
	// 자주가는 구장 저장
	@SuppressWarnings({ "resource", "null" })
	public int save_insert(field_save_Data save) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql="";
		int insertCount=0;
		
		try{
			rs = pstmt.executeQuery();
			sql="insert into favorite_field_save(save_num,user_id,save1,save2,save3,save4";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, save.getSave_num());
			pstmt.setString(2, save.getUser_id());
			pstmt.setString(3, save.getSave1());
			pstmt.setString(4, save.getSave2());
			pstmt.setString(5, save.getSave3());
			pstmt.setString(6, save.getSave4());
			insertCount=pstmt.executeUpdate();

		}catch(Exception ex){
		}finally{
			close(rs);
			close(pstmt);
		}

		return insertCount;

	}
		
}
