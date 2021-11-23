package com.best.kyobo.user;

import com.best.kyobo.MyUtils;
import com.best.kyobo.VO.UserVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/join") //주소창에 user/join 입력하면 doget 작동
public class joinservlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        MyUtils.disForward(req,res,"user/join"); //homepage directory의 user폴더안에 join.jsp로 가겠다.
    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String uid = req.getParameter("uid");
        String upw = req.getParameter("upw");
        String nm = req.getParameter("nm");
        int gender = MyUtils.getParameterInt(req,"gender");

        UserVO vo = new UserVO();
        vo.setUid(uid);
        vo.setUpw(upw);
        vo.setNm(nm);
        vo.setGender(gender);

        int result = DAOuser.join(vo);


        switch (result){
            case 1://성공했으니 로그인 창으로
                res.sendRedirect("/user/login");
                break;
            case 0: //실패
                req.setAttribute("message","회원가입을 실패했습니다.");
                doGet(req,res);
                break;

        }

    }
}
