package dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;


public class Shop_DAO {
	DataSource ds;
	Connection con;
	private static Shop_DAO shop_DAO;

	private Shop_DAO() {
	}

	public static Shop_DAO getInstance(){
		if(shop_DAO == null){
			shop_DAO = new Shop_DAO();
		}
		return shop_DAO;
	}

	public void setConnection(Connection con){
		this.con = con;
	}

	public int deleteArticle(String prd_re_no){

		PreparedStatement pstmt = null;
		String prdre_delete_sql="delete from prd_re where prd_re_no =?";
		int deleteCount=0;

		try{
			pstmt=con.prepareStatement(prdre_delete_sql);
			pstmt.setString(1, prd_re_no);
			deleteCount=pstmt.executeUpdate();
		}catch(Exception ex){
		}	finally{
			close(pstmt);
		}

		return deleteCount;

	}
	

	public boolean isArticleBoardWriter(String p_no,String pass){

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String board_sql="select * from prd_re where prd_re_ro=?";
		boolean isWriter = false;

		try{
			pstmt=con.prepareStatement(board_sql);
			pstmt.setString(1, p_no);
			rs=pstmt.executeQuery();
			rs.next();

			if(pass.equals(rs.getString("BOARD_PASS"))){
				isWriter = true;
			}
		}catch(SQLException ex){
		}
		finally{
			close(pstmt);
		}

		return isWriter;

	}
	
	
	
}
