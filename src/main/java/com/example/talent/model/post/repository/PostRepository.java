package com.example.talent.model.post.repository;

import com.example.talent.model.post.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepository extends JpaRepository<PostEntity, Integer> {

    Optional<PostEntity> findByIdAndDeleteDateIsNull(Integer id);
}
