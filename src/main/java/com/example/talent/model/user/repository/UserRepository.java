package com.example.talent.model.user.repository;

import com.example.talent.model.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    Optional<UserEntity> findById(String id);

    Optional<UserEntity> findByIdAndDeleteDateIsNull(String id);

    Optional<UserEntity> findByIdxAndDeleteDateIsNull(Long idx);
}
