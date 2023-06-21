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
    public boolean signUp(UserDto dto) {
        Connection conn = new JdbcConnection().getJdbc();
        boolean isSuccess = false;
        String sql = "INSERT INTO user (user_id, user_name, user_email, user_pwd, user_birthdate, user_phonenumber) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setString(1, dto.getUser_id());
            psmt.setString(2, dto.getUser_name());
            psmt.setString(3, dto.getUser_email());
            psmt.setString(4, dto.getUser_pwd());
            psmt.setString(5, dto.getUser_birthdate());
            psmt.setString(6, dto.getUser_phone_number());
            int rowsAffected = psmt.executeUpdate();
            if (rowsAffected > 0) {
                isSuccess = true;
            }
        } catch (SQLException e) {
            return false;
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                return isSuccess;
            }
        }
        return isSuccess;
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
