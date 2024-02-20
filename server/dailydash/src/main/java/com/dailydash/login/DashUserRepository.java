package com.dailydash.login;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DashUserRepository extends JpaRepository<DashUser, Long> {
    Optional<DashUser> findDashUserByUsernameAndPassword(String username, String password);
    Boolean existsByUsername(String username);
}
