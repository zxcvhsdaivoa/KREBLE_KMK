package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.util.ArrayList;

import dao.Mypage;
import dao.Shop_DAO;
import dao.SquadDAO;
import use_data.Shop_prd;
import use_data.UserData;
import vo.SquadInfo;
import vo.field_save_Data;

public class User_my_page_service {
    Connection con;

    public User_my_page_service() {
        con = getConnection();
    }

    public ArrayList<UserData> getUserInfo(String id) throws Exception{
    	ArrayList<UserData> ud = new ArrayList<UserData>();
        Mypage mpage = Mypage.getInstance();
        mpage.setConnection(con);
        
        ud = mpage.userinfo(id);
        
        return ud;
    }
    public ArrayList<SquadInfo> getSquadInfo(String id) throws Exception{
    	ArrayList<SquadInfo> si = new ArrayList<SquadInfo>();
        Mypage mpage = Mypage.getInstance();
        mpage.setConnection(con);
        
        si = mpage.squadinfo(id);
        
        return si;
    }
    
    public int sqsize(String id) throws Exception{
    	int asd=0;
        SquadDAO aa = SquadDAO.getInstance();
        aa.setConnection(con);
        
        asd = aa.Squad_cnt(id);
        
        return asd;
    }
    
    public ArrayList<field_save_Data> getFieldInfo(String id) throws Exception{
    	ArrayList<field_save_Data> fs = new ArrayList<field_save_Data>();
        Mypage mpage = Mypage.getInstance();
        mpage.setConnection(con);
        
        
        
        return fs;
    }
    public ArrayList<Shop_prd> getCartInfo(String id) throws Exception{
    	ArrayList<Shop_prd> sp = new ArrayList<Shop_prd>();
        Mypage mpage = Mypage.getInstance();
        mpage.setConnection(con);
        String [] aa = new String[3];
        
        aa = mpage.cartinfo(id);
        sp = mpage.prd_info(aa);
        
        return sp;
    }
    public ArrayList<Shop_prd> getLikeInfo(String id) throws Exception{
    	ArrayList<Shop_prd> sp = new ArrayList<Shop_prd>();
        Mypage mpage = Mypage.getInstance();
        mpage.setConnection(con);
        String [] aa = new String[3];
        
        aa = mpage.likeinfo(id);
        sp = mpage.prd_info(aa);
        
        close(con);
        return sp;
    }
}