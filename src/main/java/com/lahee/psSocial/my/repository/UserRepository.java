package com.lahee.psSocial.my.repository;

import com.lahee.psSocial.my.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
