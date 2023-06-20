package service;

import dao.MainDao;
import dto.MovieDto;
import servlet.MainServlet;

import java.util.List;

public class MainService {
    private static MainService mainService;
    public static MainService getMainService() {
        if(mainService == null) mainService = new MainService();
        return mainService;
    }


    public List<MovieDto> showMovieList() {
        List<MovieDto> movieList = MainDao.getRepository().mainMovieList();
        return movieList;
    }

}
