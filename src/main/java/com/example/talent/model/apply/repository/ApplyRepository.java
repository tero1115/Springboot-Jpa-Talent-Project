package com.example.talent.model.apply.repository;

import com.example.talent.model.apply.entity.ApplyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplyRepository extends JpaRepository<ApplyEntity, Integer> {
}
