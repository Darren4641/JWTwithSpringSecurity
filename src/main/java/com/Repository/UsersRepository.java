package com.Repository;

import com.Model.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, String> {
    Optional<Users> findById(String id);
    Optional<Users> findByEmail(String email);
    Page<Users> findAll(Pageable pageable);
}
