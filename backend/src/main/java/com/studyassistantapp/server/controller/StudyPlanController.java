package com.studyassistantapp.server.controller;

import com.studyassistantapp.server.entity.StudyPlan;
import com.studyassistantapp.server.service.StudyPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/study-plans")
public class StudyPlanController {

    @Autowired
    private StudyPlanService studyPlanService;

    @GetMapping
    public List<StudyPlan> getAllStudyPlans() {
        return studyPlanService.getAllStudyPlans();
    }

    @GetMapping("/{id}")
    public StudyPlan getStudyPlanById(@PathVariable Long id) {
        return studyPlanService.getStudyPlanById(id);
    }

    @PostMapping
    public StudyPlan createStudyPlan(@RequestBody StudyPlan studyPlan) {
        return studyPlanService.createStudyPlan(studyPlan);
    }

    @PutMapping("/{id}")
    public StudyPlan updateStudyPlan(@PathVariable Long id, @RequestBody StudyPlan studyPlan) {
        studyPlan.setId(id);
        return studyPlanService.updateStudyPlan(studyPlan);
    }

    @DeleteMapping("/{id}")
    public void deleteStudyPlan(@PathVariable Long id) {
        studyPlanService.deleteStudyPlan(id);
    }

    @GetMapping("/search")
    public List<StudyPlan> getStudyPlansByTopic(@RequestParam String topic) {
        return studyPlanService.getStudyPlansByTopic(topic);
    }
}