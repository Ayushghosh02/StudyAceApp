package com.studyassistantapp.server.service;

import java.util.List;

import com.studyassistantapp.server.entity.StudyPlan;

public interface StudyPlanService {
    List<StudyPlan> getAllStudyPlans();
    StudyPlan getStudyPlanById(Long id);
    StudyPlan createStudyPlan(StudyPlan studyPlan);
    StudyPlan updateStudyPlan(StudyPlan studyPlan);
    void deleteStudyPlan(Long id);
    List<StudyPlan> getStudyPlansByTopic(String topic);
}
