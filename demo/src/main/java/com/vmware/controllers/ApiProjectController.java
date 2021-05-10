package com.vmware.controllers;

import com.vmware.entities.Project;
import com.vmware.services.ProjectService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiProjectController {
    private ProjectService projectService;

    public ApiProjectController(ProjectService projectService){
        this.projectService = projectService;
    }

    @GetMapping("/projects/{project_name}")
    public Project findByName(@PathVariable String project_name){
        return this.projectService.findByName(project_name);
    }

    @PostMapping("/projects/{project_name}")
    public Long addProject(@PathVariable String project_name, @RequestParam String description){
      return this.projectService.addProject(project_name, description);
    };
}
