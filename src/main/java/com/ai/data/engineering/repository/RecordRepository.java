package com.ai.data.engineering.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ai.data.engineering.model.RecordEntity;

@Repository
public interface RecordRepository extends JpaRepository<RecordEntity, Integer> {
}