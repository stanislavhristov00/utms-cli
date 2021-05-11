package com.vmware.controllers;

import com.vmware.entities.Project;
import com.vmware.entities.TestRun;
import com.vmware.models.baseModels.TestRunModel;
import com.vmware.models.baseModels.requestModels.TestRunRequestModel;
import com.vmware.services.ProjectService;
import com.vmware.services.TestRunService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiProjectController {
    private ProjectService projectService;
    private TestRunService testRunService;

    public ApiProjectController(ProjectService projectService, TestRunService testRunService){
        this.projectService = projectService;
        this.testRunService = testRunService;
    }

    @GetMapping("/projects/{project_name}")
    public Project findByName(@PathVariable String project_name){
        return this.projectService.findByName(project_name);
    }

    @PostMapping("/projects/{project_name}")
    public Long addProject(@PathVariable String project_name, @RequestParam String description){
      return this.projectService.addProject(project_name, description);
    };

    @GetMapping("/projects/{project_id}/runs")
    public List<TestRun> getAllByProjectId(@PathVariable Long project_id){
        return this.testRunService.findAllByProjectId(project_id);
    }

    @PostMapping("/projects/{project_id}/runs")
    public Long addTestRun(@PathVariable Long project_id, @RequestBody TestRunRequestModel testRun){
        TestRun tr = this.testRunService.createTestRun(project_id);
        return null;
    }
}
