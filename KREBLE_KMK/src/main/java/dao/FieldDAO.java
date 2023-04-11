package dao;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.sql.DataSource;
import vo.KreblechoiData;
import use_data.ReviewData;

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
		KreblechoiData field_list=new KreblechoiData();
		
		try{
			if(con == null){
				throw new Exception("데이터베이스에 연결할 수 없습니다.");
			}
			pstmt = con.prepareStatement("select * from field_info where field_id = '" + id + "';");
			rs= pstmt.executeQuery();

			if(rs.next()){
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
		}finally {
			close(rs);
			close(pstmt);
		}
		return field_list;
	}
}
