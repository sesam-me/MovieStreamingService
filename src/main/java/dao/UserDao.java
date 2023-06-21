package dao;

import config.JdbcConnection;
import dto.UserDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private static UserDao userdao;
    public static UserDao getUserRepository() {
        if(userdao == null) userdao = new UserDao();
        return userdao;
    }


    public UserDto loginById(String user_id, String user_pwd){
        Connection conn = new JdbcConnection().getJdbc();
        UserDto loginUser = new UserDto();
        String sql = "select *\n" +
                "from user\n" +
                "where user_id = ? \n" +
                "and user_pwd = ?;";

        try {
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setString(1, user_id);
            psmt.setString(2, user_pwd);
            ResultSet resultSet = psmt.executeQuery();

//          while을 써줘야 함->왜? 만약 resultSet에 값이 없을 경우, 실행하지 않아야 하기 때문에,
//          while을 하지 않으면 resultSet.getInt("user_seq")에 값이 없는데 들어가서 에러뜸.
            while(resultSet.next()){
                // setter를 쓰는 것보다 method를 활용해서 세팅하는게 좋음
                loginUser.createUser(
                        resultSet.getInt("user_seq"),
                        resultSet.getString("user_id"),
                        resultSet.getString("user_name"),
                        resultSet.getString("user_email"),
                        resultSet.getString("user_pwd"),
                        resultSet.getString("user_birthdate"),
                        resultSet.getString("user_phonenumber")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        };
        return loginUser;
    }


    public UserDto loginByEmail(String user_email, String user_pwd){
        Connection conn = new JdbcConnection().getJdbc();
        UserDto loginUser = new UserDto();
        String sql = "select *\n" +
                "from user\n" +
                "where user_email = ? \n" +
                "and user_pwd = ?;";

        try {
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setString(1, user_email);
            psmt.setString(2, user_pwd);
            ResultSet resultSet = psmt.executeQuery();



            // setter를 쓰는 것보다 method를 활용해서 세팅하는게 좋음
            while(resultSet.next()){
                loginUser.createUser(
                        resultSet.getInt("user_seq"),
                        resultSet.getString("user_id"),
                        resultSet.getString("user_name"),
                        resultSet.getString("user_email"),
                        resultSet.getString("user_pwd"),
                        resultSet.getString("user_birthdate"),
                        resultSet.getString("user_phonenumber")
                );
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        };
        return loginUser;
    }
}
