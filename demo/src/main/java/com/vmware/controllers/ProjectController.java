package com.vmware.controllers;

import com.vmware.entities.Project;
import com.vmware.repositories.ProjectRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    private ProjectRepository projectRepository;

    public ProjectController(ProjectRepository projectRepository){
        this.projectRepository = projectRepository;
    }

    @GetMapping
    public List<Project> getAllProjects(){
        return this.projectRepository.findAll();
    }

    @GetMapping("/{name}")
    public Project findByName(@PathVariable String name){
        return this.projectRepository.findByName(name);
    }
}
