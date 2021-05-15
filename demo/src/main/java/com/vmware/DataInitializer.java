package com.vmware;

import com.vmware.entities.*;
import com.vmware.enums.TestCaseStatus;
import com.vmware.enums.TestRunStatus;
import com.vmware.enums.TestSuiteStatus;
import com.vmware.repositories.ProjectRepository;
import com.vmware.repositories.TestCaseRepository;
import com.vmware.repositories.TestRunRepository;
import com.vmware.repositories.TestSuiteRepository;
import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
public class DataInitializer implements CommandLineRunner {
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private TestRunRepository testRunRepository;
    @Autowired
    private TestSuiteRepository testSuiteRepository;
    @Autowired
    private TestCaseRepository testCaseRepository;

    @Override
    public void run(String... args) throws Exception {
    }
}
