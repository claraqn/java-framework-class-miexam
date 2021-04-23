package kr.ac.jejunu.userdao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.*;

public class UserDao {
    private final JejuJdbcTemplate jdbcTemplate;

    public UserDao(JejuJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public User get(Integer id) throws SQLException {
        Object[] params = new Object[]{id};
        String sql = "select * from userinfo where id = ?";
        return jdbcTemplate.get(sql, params);

    }
    public void insert(User user) throws SQLException{
        Object[] params = new Object[]{user.getName(), user.getPassword()};
        String sql = "insert into userinfo (name, password) values (?,?)";
        jdbcTemplate.insert(user, sql, params);

    }

    public void update(User user) throws SQLException {
        Object[] params = new Object[]{user.getName(), user.getPassword(), user.getId()};
        String sql = "update userinfo set name = ?, password = ? where id = ?";
        jdbcTemplate.update(sql, params);
    }

    public void delete(Integer id) throws SQLException {
        Object[] params = new Object[]{id};
        String sql = "delete from userinfo where id = ?";
        jdbcTemplate.update(sql, params);
    }


}
