package com.concerto.backend.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Repository for anything raw DB stuffs

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    // Add more function as needed

    boolean existsByUserEmail(String email);
}
