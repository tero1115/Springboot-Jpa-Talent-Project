package com.example.talent.model.user.repository;

import com.example.talent.model.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    Optional<UserEntity> findByUsername(String username);

    Optional<UserEntity> findByUsernameAndDeleteDateIsNull(String username);

    Optional<UserEntity> findByIdAndDeleteDateIsNull(Long id);
}
