package com.studyassistantapp.server.service.Impl;

import com.studyassistantapp.server.entity.StudyPlan;
import com.studyassistantapp.server.repository.StudyPlanRepo;
import com.studyassistantapp.server.service.StudyPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudyPlanServiceImpl implements StudyPlanService {

    @Autowired
    private StudyPlanRepo studyPlanRepo;

    @Override
    public List<StudyPlan> getAllStudyPlans() {
        return studyPlanRepo.findAll();
    }

    @Override
    public StudyPlan getStudyPlanById(Long id) {
        return studyPlanRepo.findById(id).orElse(null);
    }

    @Override
    public StudyPlan createStudyPlan(StudyPlan studyPlan) {
        return studyPlanRepo.save(studyPlan);
    }

    @Override
    public StudyPlan updateStudyPlan(StudyPlan studyPlan) {
        if (studyPlanRepo.existsById(studyPlan.getId())) {
            return studyPlanRepo.save(studyPlan);
        } else {
            throw new IllegalArgumentException("StudyPlan with id " + studyPlan.getId() + " does not exist");
        }
    }

    @Override
    public void deleteStudyPlan(Long id) {
        if (studyPlanRepo.existsById(id)) {
            studyPlanRepo.deleteById(id);
        } else {
            throw new IllegalArgumentException("StudyPlan with id " + id + " does not exist");
        }
    }

    @Override
    public List<StudyPlan> getStudyPlansByTopic(String topic) {
        return studyPlanRepo.findByTopic(topic);
    }
}