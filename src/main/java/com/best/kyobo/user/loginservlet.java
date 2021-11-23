package com.best.kyobo.user;

import com.best.kyobo.MyUtils;
import com.best.kyobo.VO.UserVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/login")
public class loginservlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        MyUtils.disForward(req,res,"user/login");
        //
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String uid = req.getParameter("uid");
        String upw = req.getParameter("upw");

        UserVO vo = new UserVO();
        vo.setUid(uid);
        vo.setUpw(upw);

        int result = DAOuser.login(vo);



        //성공하면 list로
        //실패하면 다시
    }
}
