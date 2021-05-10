package com.vmware.controllers;

import com.vmware.entities.Project;
import com.vmware.repositories.ProjectRepository;
import com.vmware.services.ProjectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    private ProjectService projectService;

    public ProjectController(ProjectService projectService){
        this.projectService = projectService;
    }

    @GetMapping
    public List<Project> getAllProjects(){
        return this.projectService.getAllProjects();
    }

}
