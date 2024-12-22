package com.studyassistantapp.server.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.studyassistantapp.server.entity.StudyPlan;

public interface StudyPlanRepo extends JpaRepository<StudyPlan, Long> {
    @Query("SELECT s FROM StudyPlan s WHERE LOWER(s.topic) LIKE LOWER(CONCAT('%', :topic, '%'))")
    List<StudyPlan> findByTopic(String topic);
}
