package com.dailydash.login.dao;

import com.dailydash.login.entity.DashUser;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class DashUserDaoImpl implements DashUserDao{

    private EntityManager entityManager;

    @Autowired
    public DashUserDaoImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void addUser(DashUser dashuser) {
        entityManager.persist(dashuser);
    }

    @Override
    @Transactional
    public void deleteUser(DashUser dashuser) {
        entityManager.remove(dashuser);
    }

    @Override
    public void verifyUser(Long userId) {
        entityManager.find(DashUser.class, userId);
    }

    //find via id
}
