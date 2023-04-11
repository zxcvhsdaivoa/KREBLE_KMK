package dao;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import use_data.Shop_prd;


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
	
	//상품리스트 갯수
	public int selectListCount() {

		int listCount= 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try{
			pstmt=con.prepareStatement("select count(*) from product");
			rs = pstmt.executeQuery();

			if(rs.next()){
				listCount=rs.getInt(1);
			}
		}catch(Exception ex){

		}finally{
			close(rs);
			close(pstmt);
		}

		return listCount;

	}
	
	
	//상품리스트
	public ArrayList<Shop_prd> selectArticleList(int page,int limit){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String shop_list_sql="select * from product order by prd_no desc limit ?,10";
		ArrayList<Shop_prd> articleList = new ArrayList<Shop_prd>();
		Shop_prd shop_prd = null;
		int startrow=(page-1)*10; 

		try{
			pstmt = con.prepareStatement(shop_list_sql);
			pstmt.setInt(1, startrow);
			rs = pstmt.executeQuery();

			while(rs.next()){
				shop_prd = new Shop_prd();
				shop_prd.setPrd_no(rs.getString("prd_no"));
				shop_prd.setPrd_id(rs.getString("prd_id"));
				shop_prd.setPrd_color(rs.getString("prd_color"));
				shop_prd.setPrd_date(rs.getString("prd_date"));
				shop_prd.setPrd_img(rs.getString("prd_img"));
				shop_prd.setPrd_price(rs.getInt("prd_price"));
				shop_prd.setPrd_name(rs.getString("prd_name"));
				articleList.add(shop_prd);
			}

		}catch(Exception ex){
		}finally{
			close(rs);
			close(pstmt);
		}

		return articleList;

	}

	
	//상품리스트 개별선택
	public Shop_prd selectArticle(int prd_no){

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Shop_prd shop_prd = null;

		try{
			pstmt = con.prepareStatement(
					"select * from product where prd_no = ?");
			pstmt.setInt(1, prd_no);
			rs= pstmt.executeQuery();

			if(rs.next()){
				shop_prd = new Shop_prd();
				shop_prd.setPrd_no(rs.getString("prd_no"));
				shop_prd.setPrd_cata(rs.getString("prd_cata"));
				shop_prd.setPrd_id(rs.getString("prd_id"));
				shop_prd.setPrd_meter(rs.getString("prd_meter"));
				shop_prd.setPrd_note(rs.getString("prd_note"));
				shop_prd.setPrd_size(rs.getString("prd_size"));
				shop_prd.setPrd_color(rs.getString("prd_color"));
				shop_prd.setPrd_date(rs.getString("prd_date"));
				shop_prd.setPrd_create(rs.getString("prd_create"));
				shop_prd.setPrd_qaul(rs.getString("prd_qaul"));
				shop_prd.setPrd_as(rs.getString("prd_as"));
				shop_prd.setPrd_img(rs.getString("prd_img"));
				shop_prd.setPrd_content(rs.getString("prd_content"));
				shop_prd.setPrd_name(rs.getString("prd_name"));
				shop_prd.setPrd_price(rs.getInt("prd_price"));
				shop_prd.setPrd_qant(rs.getInt("prd_qant"));
			}
		}catch(Exception ex){
		}finally{
			close(rs);
			close(pstmt);
		}

		return shop_prd;

	}
	//
	
	//상품리스트 댓글삭제
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
	

	public int updateReadCount(int board_num){

		PreparedStatement pstmt = null;
		int updateCount = 0;
		String sql="update board set BOARD_READCOUNT = "+
				"BOARD_READCOUNT+1 where BOARD_NUM = "+board_num;

		try{
			pstmt=con.prepareStatement(sql);
			updateCount = pstmt.executeUpdate();
		}catch(SQLException ex){
		}
		finally{
			close(pstmt);

		}

		return updateCount;

	}

	
}
