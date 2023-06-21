package servlet;

import dao.UserDao;
import dto.UserDto;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("views/login/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//      입력 칸이 2개이기 때문에, Parameter는 2개임
        String userIdEmail = req.getParameter("user_id_email");
        String userPwd = req.getParameter("user_pwd");

//      #1 로그인
//      아이디로 로그인
        UserDto userDto1 = new UserDao().loginById(userIdEmail, userPwd);
//      이메일로 로그인
        UserDto userDto2 = new UserDao().loginByEmail(userIdEmail, userPwd);


//      #2 세션에 생성



//      #4 세션에 로그인 정보 저장
//      아이디로 로그인


//      #5 로그인 후
//      userDto1 != null을 하면 오류 뜸 -> 왜? userDto1은 껍데기이지 null이 아님
//      userDto1.getUser_email()로 구체적인 값이 null인 걸 지정해줘야함..!
        if(userDto1!= null || userDto2!= null) {

            Integer seq=userDto1.getUser_seq();
            if(userDto1==null){
                seq = userDto2.getUser_seq();
            }

            HttpSession session = req.getSession();
            session.setAttribute("useq",seq);
            resp.sendRedirect("/main");
        } else {resp.sendRedirect("/login");}
    }
}
