package com.dailydash.repository;

import com.dailydash.entity.DashUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DashUserRepository extends JpaRepository<DashUser, Long> {
    Optional<DashUser> findDashUserByEmailAndPassword(String email, String password);
}
