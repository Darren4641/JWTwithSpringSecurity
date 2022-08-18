package com.Repository;

import com.Jwt.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    Optional<RefreshToken> findByRefreshToken(String refreshToken);
    boolean existsByKeyIdAndUserAgent(String userEmail, String userAgent);
    void deleteByKeyIdAndUserAgent(String userEmail, String userAgent);
}
