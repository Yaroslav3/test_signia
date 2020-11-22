package com.signia.backend.repository;

import com.signia.backend.model.Authorization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorizationRepository extends JpaRepository<Authorization, Long> {

    @Query(value = "SELECT * FROM test_signia.authorization a WHERE a.email=?1 AND a.password=?2", nativeQuery = true)
    Optional<Authorization>findAuthorizationUser(String email, String pass);
}
