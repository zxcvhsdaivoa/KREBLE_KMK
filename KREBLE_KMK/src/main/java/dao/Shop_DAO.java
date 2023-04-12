package dao;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
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
	//카테고리 상품리스트 갯수
	public int CaSelectListCount(String cata) {
		String prd_cata = "";
		switch(cata) {
        case "uni": prd_cata = "유니폼";
         break;
        case "ball": prd_cata = "축구공";
         break;
        case "sho": prd_cata = "축구화";
         break;
        default : prd_cata = "기타용품";
        break;
		}
		
		int listCount= 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try{
			String sql="select count(*) from product where prd_cata=?;";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, prd_cata);
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
	
	//카테고리 상품리스트
	public ArrayList<Shop_prd> caSelectArticleList(String cata, int page,int limit){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String shop_list_sql="select * from product where prd_cata=? order by prd_no desc limit ?,10";
		ArrayList<Shop_prd> articleList = new ArrayList<Shop_prd>();
		Shop_prd shop_prd = null;
		int startrow=(page-1)*10; 
		String prd_cata = "";
		switch(cata) {
        case "uni": prd_cata = "유니폼";
         break;
        case "ball": prd_cata = "축구공";
         break;
        case "sho": prd_cata = "축구화";
         break;
        default : prd_cata = "기타용품";
        break;
		}

		try{
			pstmt = con.prepareStatement(shop_list_sql);
			pstmt.setString(1, prd_cata);
			pstmt.setInt(2, startrow);
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
			System.out.println(ex);
		}finally{
			close(rs);
			close(pstmt);
		}

		return articleList;

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
	public Shop_prd selectArticle(String prd_no){

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Shop_prd shop_prd = null;

		try{
			pstmt = con.prepareStatement("select * from product where prd_no = ?");
			pstmt.setString(1, prd_no);
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
	
	//상품등록
	@SuppressWarnings("resource")
	public int insertArticle(Shop_prd article){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int num =0;
		String sql="";
		int insertCount=0;
		String g = article.getPrd_cata();
		String formattedNum = "";
		String se_sql = "SELECT max(right(prd_no,4)) FROM product where prd_cata='"+g+"';";
		try{
			pstmt=con.prepareStatement(se_sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				num =rs.getInt("max(right(prd_no,4))");
				formattedNum = String.format("%04d", num+1);
			}
			else {
				num=0001;
			}
			String p_no = "";
			switch(g) {
            case "축구화":
            	p_no = "s"+formattedNum;
             break;
             case "축구공":
            	p_no = "b"+formattedNum;
             break;
             case "유니폼":
            	p_no = "u"+formattedNum;
             break;
             case "기타용품":
            	p_no = "e"+formattedNum;
             break;

			}
			
			sql="insert into product (prd_no , prd_name, prd_cata, prd_id, prd_meter, prd_note, prd_price, prd_size, prd_color, prd_date, prd_create, prd_qaul, prd_as, prd_qant, prd_img, prd_content) values(?, ?, ?, ?, ?, ?, ?, ?, ?, now(), ?, ?, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, p_no);
			pstmt.setString(2, article.getPrd_name());
			pstmt.setString(3, g);
			pstmt.setString(4, article.getPrd_id());
			pstmt.setString(5, article.getPrd_meter());
			pstmt.setString(6, article.getPrd_note());
			pstmt.setInt(7, article.getPrd_price());
			pstmt.setString(8, article.getPrd_size());
			pstmt.setString(9, article.getPrd_color());
			//prd_date now()
			pstmt.setString(10, article.getPrd_create());
			pstmt.setString(11, article.getPrd_qaul());
			pstmt.setString(12, article.getPrd_as());
			pstmt.setInt(13, article.getPrd_qant());
			pstmt.setString(14, p_no+".jpg");
			pstmt.setString(15, article.getPrd_content());

			insertCount=pstmt.executeUpdate();

		}catch(Exception ex){
			System.out.println(ex);
		}finally{
			close(rs);
			close(pstmt);
		}

		return insertCount;

	}
	//상품리플등록
		@SuppressWarnings("resource")
		public int reInsertArticle(Shop_prd article){
			PreparedStatement pstmt = null;
			int insertCount=0;
			System.out.println(article.getPrd_re_sc());	

			String sql = "insert into prd_re values(default,?,?,?,?)";
			try{
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, article.getPrd_re_id());
				pstmt.setString(2, article.getPrd_re_text());
				pstmt.setInt(3, article.getPrd_re_sc());
				pstmt.setString(4, article.getPrd_re_no());
				insertCount=pstmt.executeUpdate();

			}catch(Exception ex){
				System.out.println(ex);
			}finally{
				close(pstmt);
			}

			return insertCount;

		}
		

	//상품수정
	@SuppressWarnings("resource")
	public int PrdmodyArticle(Shop_prd article){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int num =0;
		String sql="";
		int insertCount=0;
		String g = article.getPrd_cata();
		String formattedNum = "";
		String n = article.getPrd_no();
		String p_no = "";
		String no_sql = "select prd_cata from product where prd_no='"+n+"';";
		
		
		try{
			pstmt=con.prepareStatement(no_sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String nc = rs.getString("prd_cata");
				if(nc.equals(g)) {
					p_no = n;
				}
				else {
					String se_sql = "SELECT max(right(prd_no,4)) FROM product where prd_cata='"+g+"';";
					pstmt=con.prepareStatement(se_sql);
					rs = pstmt.executeQuery();
					
					if(rs.next()) {
						num =rs.getInt("max(right(prd_no,4))");
						formattedNum = String.format("%04d", num+1);
					}
					else {
						num=0001;
					}
					switch(g) {
		            case "축구화":
		            	p_no = "s"+formattedNum;
		             break;
		             case "축구공":
		            	p_no = "b"+formattedNum;
		             break;
		             case "유니폼":
		            	p_no = "u"+formattedNum;
		             break;
		             case "기타용품":
		            	p_no = "e"+formattedNum;
		             break;

					}
				}
			}
			
			sql="update product set prd_no =?, prd_name=?, ";
			sql+="prd_cata=?, prd_meter=?, prd_note=?, prd_price=?, ";
			sql+="prd_size=?, prd_color=?, prd_create=?, prd_qaul=?, ";
			sql+="prd_as=?, prd_qant=?, prd_img=?, prd_content=? where prd_no = '"+n+"';";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, p_no);
			pstmt.setString(2, article.getPrd_name());
			pstmt.setString(3, g);
			//prd_id = default
			pstmt.setString(4, article.getPrd_meter());
			pstmt.setString(5, article.getPrd_note());
			pstmt.setInt(6, article.getPrd_price());
			pstmt.setString(7, article.getPrd_size());
			pstmt.setString(8, article.getPrd_color());
			//prd_date now()
			pstmt.setString(9, article.getPrd_create());
			pstmt.setString(10, article.getPrd_qaul());
			pstmt.setString(11, article.getPrd_as());
			pstmt.setInt(12, article.getPrd_qant());
			pstmt.setString(13, p_no+".jpg");
			pstmt.setString(14, article.getPrd_content());
			insertCount=pstmt.executeUpdate();

		}catch(Exception ex){
			System.out.println(ex);
		}finally{
			close(rs);
			close(pstmt);
		}

		return insertCount;

	}


	
}
