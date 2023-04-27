package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import dao.FieldDAO;
import vo.KreblechoiData;
import vo.Rent_info;

public class Field_rent_Service {
	
	public Rent_info getrent_list_check() throws Exception{
		Rent_info rent_info = null;
		Connection con = getConnection();
		FieldDAO fieldDAO = FieldDAO.getInstance();
		fieldDAO.setConnection(con);
		rent_info = fieldDAO.rent_info_select();
		close(con);
		return rent_info;
		
	}
	public KreblechoiData getfield_cate_list() throws Exception{
		KreblechoiData cate_list = null;
		Connection con = getConnection();
		FieldDAO fieldDAO = FieldDAO.getInstance();
		fieldDAO.setConnection(con);
		cate_list = fieldDAO.field_cate_list();
		close(con);
		return cate_list;
		
	}
	
}
