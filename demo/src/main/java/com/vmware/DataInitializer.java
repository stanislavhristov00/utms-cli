package com.vmware;

import com.vmware.entities.Project;
import com.vmware.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public void run(String... args) throws Exception {
        Project project = new Project(1L, "proektche", "testowo proektche", null);
        this.projectRepository.saveAndFlush(project);
        Project project2 = new Project(3L, "proekt za missing id", "ne", null);
        this.projectRepository.saveAndFlush(project2);
        Project project1 = new Project(4L, "proektche2", "za wtorite neshta", null);
        this.projectRepository.saveAndFlush(project1);
        Project project3 = new Project(this.projectRepository.getNextId(), "aaaaaaaaaaaaaaaaaaaaaa", "za wtorite neshta", null);
        this.projectRepository.saveAndFlush(project3);
        Project project4 = new Project(this.projectRepository.getNextId(), "bbbbbbbbbbbbbbbbbbbbbb", "za wtorite neshta", null);
        this.projectRepository.saveAndFlush(project4);
    }
}
