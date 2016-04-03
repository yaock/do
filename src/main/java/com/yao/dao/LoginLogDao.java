package com.yao.dao;

import com.yao.domain.LoginLog;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by yaochengkai on 2016/4/3.
 */
@Repository
public class LoginLogDao {
    @Resource
    private JdbcTemplate jdbcTemplate;

    public void insertLoginLog(LoginLog loginLog) {
        String sqlStr = "INSERT INTO loginlog(userid,ip,logindatetime) VALUES(?,?,?)";
        jdbcTemplate.update(sqlStr, new Object[]{loginLog.getUserId(), loginLog.getIp(), loginLog.getLoginDate()});
    }
}
