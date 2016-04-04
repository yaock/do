package com.yao.dao;

import com.yao.domain.User;

/**
 * Created by Administrator on 2016/4/4.
 */
public interface UserMapper {
    int getMatchCount(String userName, String password);
    User findUserByUserName(final String userName);
    void updateLoginInfo(User user);
}
