package com.best.kyobo.user;

import com.best.kyobo.DbUtils;
import com.best.kyobo.VO.UserVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAOuser {
    public static int join(UserVO pa){
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "INSERT INTO kyobo_user (uid, upw, nm, gender)" +
                 " VALUE (?,?,?,?)" ;
        try{
            con = DbUtils.getCon();
            ps = con.prepareStatement(sql);
            ps.setString(1,pa.getUid());
            ps.setString(2,pa.getUpw());
            ps.setString(3,pa.getNm());
            ps.setInt(4,pa.getGender());
            return ps.executeUpdate();
            //입력이 되면 1 (쿼리문 실행o)
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DbUtils.close(con,ps);
        } return 0; //입력이 안되면 0 (쿼리문 실행x)
    }

    public static int login(UserVO pa){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT iuser, upw, nm FROM kyobo_user WHERE uid=?";

        try{
            con = DbUtils.getCon();
            ps = con.prepareStatement(sql);
            ps.setString(1,pa.getUid());
            rs = ps.executeQuery();

            if(rs.next()){
                String dbupw = rs.getString("upw");
                if(dbupw.equals(pa.getUpw())){
                    pa.setIuser(rs.getInt("iuser"));
                    pa.setNm(rs.getString("nm"));
                    return 1; //성공
                }else{
                    return 3; // 비번틀림
                }
            }else{
                return 2; //아이디 없음.
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DbUtils.close(con,ps,rs);
        } return 0; //에러
    }
}
