package com.best.kyobo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyUtils {
    public static void disForward(HttpServletRequest req, HttpServletResponse res, String jsp) throws ServletException, IOException {
        String path ="/WEB-INF/homepage/"+ jsp + ".jsp"; //homepage directory 안에있는 jsp로 가기.
        req.getRequestDispatcher(path).forward(req,res);
    }

    //스트링 -> int
    //받아온 스트링 -> int

    public static int parseStringtoInt(String str, int defVal){
        try{ //str을 int로 변환
            return Integer.parseInt(str);
        }catch (Exception e){} //안된다면 defVal값으로
        return defVal;
    }

    public static int parseStringtoInt(String str){return parseStringtoInt(str,0);}
    //str넣었을때  String만 없는 경우? (as123asd 이런거) >> 0으로 반환
    //정상적으로 넣으면 int반환?


    public static int getParameterInt(HttpServletRequest req, String aaa){
     return parseStringtoInt(req.getParameter(aaa));
    }

}
