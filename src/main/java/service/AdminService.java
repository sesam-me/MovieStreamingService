package service;

import dao.ActorDao;
import dao.MainDao;
import dto.ActorDto;
import dto.MovieDto;

public class AdminService {
    private static AdminService adminService;
    public static AdminService getMainService() {
        if(adminService == null) adminService = new AdminService();
        return adminService;
    }


    public void insertMainMovie(MovieDto movieDto){
        MainDao.getRepository().insertMainMovie(movieDto);
    }

    public void insertSubMovie(MovieDto movieDto
    ){
        MainDao.getRepository().insertSubMovie(movieDto);
    }

    public void insertActor(ActorDto actorDto){
        ActorDao.getRepository().insertActor(actorDto);
    }

    
}
