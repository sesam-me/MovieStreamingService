package dao;

import config.JdbcConnection;
import dto.ActorDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ActorDao {
    private static ActorDao actorDao;
    public static ActorDao getRepository() {
        if(actorDao == null) actorDao = new ActorDao();
        return actorDao;
    }

    public int insertActor(ActorDto actorDto){
        Connection conn = new JdbcConnection().getJdbc();

        String sql = "INSERT INTO actor (name, birth_date, nation, gender)\n" +
                "values (?, ?, ?, ?);";

        try {
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setString(1, actorDto.getName());
            psmt.setObject(2, actorDto.getBirth_date());
            psmt.setString(3, actorDto.getNation());
            psmt.setString(4, actorDto.getGender());

            if (psmt.executeUpdate() == 0) {
                return 1;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return 0;
    }


}
