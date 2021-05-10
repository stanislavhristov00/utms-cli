package com.vmware.services;

import com.vmware.entities.Project;
import com.vmware.repositories.ProjectRepository;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;

@Component
public class ProjectService {
    private ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository){
        this.projectRepository = projectRepository;
    }

    public List<Project> getAllProjects(){
        return this.projectRepository.findAll();
    }

    public Project findByName(String name){
        return this.projectRepository.findByName(name);
    }

    public Long addProject(String name, String description){
        Project pr = this.projectRepository.findByName(name);
        if(pr == null){
            Long id = this.projectRepository.getNextId();
            pr = new Project(id, name, description, new HashSet<>());
            this.projectRepository.save(pr);
            return id;
        }else{
            if(pr.getDescription().equals(description)){
            return pr.getId();
            }else{
                return -1L;
            }
        }
    }
}
