package com.vmware.controllers;

import com.vmware.entities.Project;
import com.vmware.entities.TestRun;
import com.vmware.entities.TestRunPK;
import com.vmware.models.TestRunModel;
import com.vmware.services.ProjectService;
import com.vmware.services.TestRunService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    private ProjectService projectService;
    private TestRunService testRunService;

    public ProjectController(ProjectService projectService, TestRunService testRunService) {
        this.projectService = projectService;
        this.testRunService = testRunService;
    }

    @GetMapping
    public List<Project> getAllProjects(){
        return this.projectService.getAllProjects();
    }

    @GetMapping("/{project_id}/runs")
    public List<TestRunModel> getAllByProjectId(@PathVariable Long project_id){
        return this.testRunService.getIdByProjectId(project_id);
    }

}
