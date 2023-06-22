package servlet;

import dto.MovieDto;
import service.MainService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class DetailSubServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int seq = Integer.parseInt(req.getParameter("seq"));

        MovieDto movie = MainService.getMainService().findSubMovieBySeq(seq);

        HttpSession session = req.getSession();

        session.setAttribute("movie", movie);

        req.getRequestDispatcher("views/detail.jsp").forward(req,resp);
    }
}
