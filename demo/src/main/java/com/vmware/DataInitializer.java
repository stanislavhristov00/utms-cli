package com.vmware;

import com.vmware.entities.*;
import com.vmware.enums.TestCaseStatus;
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
        Project project = new Project(1L, "proektche", "testowo proektche", new HashSet<>());
        this.projectRepository.save(project);
        TestSuitePK testSuitePK = new TestSuitePK("testSuite", project.getId());
        TestSuite testSuite = new TestSuite(testSuitePK, TestSuiteStatus.PASSED, new HashSet<>(), project);
        TestCasePK testCasePK = new TestCasePK("test1", testSuitePK);
        TestCase test1 = new TestCase(testCasePK, "Towa e test",
                true, TestCaseStatus.PASSED,
                "output", "startTime",
                "endTime", "error", testSuite);
        this.testSuiteRepository.save(testSuite);
        this.testCaseRepository.save(test1);
        testSuite.addTestCase(test1);
        this.testSuiteRepository.save(testSuite);
        TestRunPK testRunPK = new TestRunPK(project.getId(), 100L);
        TestRun testRun = new TestRun(testRunPK, TestSuiteStatus.PASSED, new HashSet<>(), project);
        this.testRunRepository.save(testRun);
        testRun.addTestSuite(testSuite);
        this.testRunRepository.save(testRun);
        project.addTestRun(testRun);
        this.projectRepository.save(project);
        TestSuitePK testSuitePK2 = new TestSuitePK("testSuite 2", project.getId());
        TestSuite testSuite2 = new TestSuite(testSuitePK2, TestSuiteStatus.PASSED, new HashSet<>(), project);
        TestCasePK testCasePK2 = new TestCasePK("test2", testSuitePK2);
        TestCase test2 = new TestCase(testCasePK2, "Towa e test",
                true, TestCaseStatus.PASSED,
                "output", "startTime",
                "endTime", "error", testSuite2);
        this.testSuiteRepository.save(testSuite2);
        this.testCaseRepository.save(test2);
        testSuite2.addTestCase(test2);
        this.testSuiteRepository.save(testSuite2);
        TestRunPK testRunPK2 = new TestRunPK(project.getId(), 105L);
        TestRun testRun2 = new TestRun(testRunPK2, TestSuiteStatus.PASSED, new HashSet<>(), project);
        this.testRunRepository.save(testRun2);
        testRun2.addTestSuite(testSuite2);
        this.testRunRepository.save(testRun2);
        project.addTestRun(testRun2);
        this.projectRepository.save(project);

        /*Project project2 = new Project(3L, "proekt za missing id", "ne", null);
        this.projectRepository.saveAndFlush(project2);
        Project project1 = new Project(4L, "proektche2", "za wtorite neshta", null);
        this.projectRepository.saveAndFlush(project1);
        Project project3 = new Project(this.projectRepository.getNextId(), "aaaaaaaaaaaaaaaaaaaaaa", "za wtorite neshta", null);
        this.projectRepository.saveAndFlush(project3);
        Project project4 = new Project(this.projectRepository.getNextId(), "bbbbbbbbbbbbbbbbbbbbbb", "za wtorite neshta", null);
        this.projectRepository.saveAndFlush(project4);*/
    }
}
