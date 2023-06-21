package servlet;

import dao.UserDao;
import dto.UserDto;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class EditUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("views/myPage/editUserInfo.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String birthDay = req.getParameter("birthDay");
        String phoneNumber = req.getParameter("phoneNumber");

        HttpSession session = req.getSession();
        int i = Integer.parseInt(String.valueOf(session.getAttribute("useq")));

        //세션 seq로 먼저 유저정보를 탐색
        UserDto userBySeq = UserDao.getUserRepository().getUserBySeq(i);

        userBySeq.setUser_name(userName);
        userBySeq.setUser_email(email);
        userBySeq.setUser_pwd(password);
        userBySeq.setUser_birthdate(birthDay);
        userBySeq.setUser_phone_number(phoneNumber);
        //탐색한 유저정보를 파라미터를 받은걸토대로 업데이트
        Boolean isUpdate = UserDao.getUserRepository().updateUser(userBySeq);

        if(isUpdate){
            System.out.println("업데이트 성공");
            resp.sendRedirect("/main");
        }else{
            System.out.println("업데이트 실패");
            resp.sendRedirect("/edit");
        }

    }
}
