package com.signia.backend.repository;

import com.signia.backend.model.Opt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface OptRepository extends JpaRepository<Opt, Long> {

    @Query(value = "SELECT * FROM test_signia.opt a WHERE a.session_id=?1", nativeQuery = true)
    Optional<Opt> findSessionId(String sessionId);
}
