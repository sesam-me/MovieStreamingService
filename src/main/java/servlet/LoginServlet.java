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
//      #1 wep에서 입력 받은 값 가져오기
//      로그인은 입력 칸이 2개이기 때문에, Parameter는 2개임
//      Parameter는 실제 DB변수명을 적어야함
        String userIdEmail = req.getParameter("user_id_email");
        String userPwd = req.getParameter("user_pwd");


//      #2 로그인 정보 저장
//      아이디로 로그인
        UserDto userDto1 = new UserDao().loginById(userIdEmail, userPwd);
//      이메일로 로그인
        UserDto userDto2 = new UserDao().loginByEmail(userIdEmail, userPwd);

//        TODO ||(또는) 없애는 방법으로도 할 수 있음
//        UserDto userDto3 = new UserDao().loginById(userIdEmail, userPwd);
//        if(userDto3==null)
//            userDto3 = new UserDao().loginByEmail(userIdEmail, userPwd);




//       TODO 로그인 성공/실패 하는걸 메소드로 빼라???
//      #3 로그인 성공/실패
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


//          로그인 실패 시.
//          #4 login페이지로 이동
        } else {resp.sendRedirect("/login");}
    }
}