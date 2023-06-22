package servlet;

import dto.MovieDto;
import service.AdminService;
import service.MainService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class DetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        int movieDto = Integer.parseInt(req.getParameter("seq"));
        MovieDto movie = MainService.getMainService().findMovieBySeq(movieDto);

        session.setAttribute("actorList", AdminService.getMainService().movieSelectActor(movie.getMovie_seq()));

        System.out.println(movie.getMovie_seq());

        System.out.println(AdminService.getMainService().movieSelectActor(movie.getMovie_seq()));

        session.setAttribute("movie", movie);
        req.getRequestDispatcher("views/detail.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



    }
}
