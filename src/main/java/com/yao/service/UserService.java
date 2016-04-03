package com.yao.service;

import com.yao.dao.LoginLogDao;
import com.yao.dao.UserDao;
import com.yao.domain.LoginLog;
import com.yao.domain.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by yaochengkai on 2016/4/3.
 */
@Service
public class UserService {
    @Resource
    private UserDao userDao;
    @Resource
    private LoginLogDao loginLogDao;

    public boolean hashMatchUser(String userName, String password) {
        int matchCount = userDao.getMatchCount(userName, password);
        return matchCount > 0;
    }

    public User findUserByUserName(String userName) {
        return userDao.findUserByUserName(userName);
    }

    public void loginSuccess(User user) {
        user.setCredits(5 + user.getCredits());
        LoginLog loginLog = new LoginLog();
        loginLog.setUserId(user.getUserId());
        loginLog.setIp(user.getLastIp());
        loginLog.setLoginDate(user.getLastVisit());
        userDao.updateLoginInfo(user);
        loginLogDao.insertLoginLog(loginLog);
    }
}
