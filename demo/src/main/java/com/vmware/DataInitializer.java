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
        this.projectRepository.save(project);
    }
}
