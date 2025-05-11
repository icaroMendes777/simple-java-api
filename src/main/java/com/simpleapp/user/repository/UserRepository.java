package com.simpleapp.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import com.simpleapp.user.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
