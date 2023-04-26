package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import dao.FieldDAO;
import vo.Rent_info;

public class Field_rent_Service {
	
	public Rent_info getfield_list_check() throws Exception{
		Rent_info rent_info = null;
		Connection con = getConnection();
		FieldDAO fieldDAO = FieldDAO.getInstance();
		fieldDAO.setConnection(con);
		rent_info = fieldDAO.rent_info_select();
		close(con);
		return rent_info;
		
	}
}
