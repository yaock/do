package com.yao.dao;

import com.yao.domain.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by yaochengkai on 2016/4/3.
 */
@Repository
public class UserDao {
    @Resource
    private JdbcTemplate jdbcTemplate;

    public int getMatchCount(String userName, String password) {
        String sqlStr = "SELECT COUNT(*) FROM user WHERE username=? and password=?";
        return jdbcTemplate.queryForInt(sqlStr, new Object[]{userName, password});
    }
    public User findUserByUserName(final String userName) {
        String sql = "SELECT userid, username, credits FROM user WHERE username=?";
        final User user = new User();
        jdbcTemplate.query(sql, new Object[]{userName},
                new RowCallbackHandler() {
                    @Override
                    public void processRow(ResultSet rs) throws SQLException {
                        user.setUserId(rs.getInt("userid"));
                        user.setUserName(userName);
                        user.setCredits(rs.getInt("credits"));
                    }
                });
        return user;
    }
    public void updateLoginInfo(User user) {
        String sqlStr = "UPDATE user SET lastVisit=?,lastip=?,credits=? WHERE userid=?";
        jdbcTemplate.update(sqlStr, new Object[]{user.getLastVisit(), user.getLastIp(),
                user.getCredits(), user.getUserId()});
    }
}
