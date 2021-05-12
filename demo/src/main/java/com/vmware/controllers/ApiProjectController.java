package com.vmware.controllers;

import com.vmware.entities.Project;
import com.vmware.entities.TestRun;
import com.vmware.models.baseModels.requestModels.TestRunRequestModel;
import com.vmware.services.ProjectService;
import com.vmware.services.TestRunService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @PostMapping("/projects")
    public Long addProject(@RequestBody Map<String, Object> map){
      return this.projectService.addProject((String)map.get("name"), (String)map.get("description"));
    };

    @GetMapping("/projects/{project_id}/runs")
    public List<TestRun> getAllByProjectId(@PathVariable Long project_id){
        return this.testRunService.findAllByProjectId(project_id);
    }

    @PostMapping("/projects/{project_id}/runs")
    public void addTestRun(@PathVariable Long project_id, @RequestBody TestRunRequestModel testRun){
        TestRun tr = this.testRunService.createTestRun(project_id);
        if(tr != null){
            this.testRunService.updateTestRun(tr, testRun, this.projectService.findById(project_id));
        }
    }
}
