package com.lahee.psSocial.repository;

import com.lahee.psSocial.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
