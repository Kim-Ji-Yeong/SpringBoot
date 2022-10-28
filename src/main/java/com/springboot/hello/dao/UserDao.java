package com.springboot.hello.dao;

import org.apache.catalina.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;



@Component
public class UserDao {
    private final DataSource dataSource;
    private final JdbcTemplate jdbcTemplate;

    public UserDao(DataSource dataSource, JdbcTemplate jdbcTemplate) {
        this.dataSource = dataSource;
        this.jdbcTemplate = jdbcTemplate;
    }
    RowMapper<User> rowMapper = new RowMapper<User>() {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User(rs.getString("id"),rs.getString("name"),rs.getString("password"));
            return user;
        }
    };

    public void add(User user) {
        this.jdbcTemplate.update("insert into users(id, name, password) values (?,?,?)",
                user.getId(), user.getName(), user.getPassword());
    }

    public int deleteAll() {
        return this.jdbcTemplate.update("delete from users");
    }

    public User findByID(String id) throws SQLException {
        String sql = "select *from users where id = ?";
        return jdbcTemplate.queryForObject(sql,rowMapper,id);
    }
}
