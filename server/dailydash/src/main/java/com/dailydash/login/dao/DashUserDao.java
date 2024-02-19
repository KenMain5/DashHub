package com.dailydash.login.dao;

import com.dailydash.login.entity.DashUser;

public interface DashUserDao {

    void addUser(DashUser dashuser);

    void deleteUser(DashUser dashuser);

    void verifyUser(Long userId);
}
