package com.vmware.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vmware.enums.TestSuiteStatus;

import javax.persistence.*;
import java.util.Set;
@Entity
@Table(name = "test_suite")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "testCases"})
public class TestSuite {
    @EmbeddedId
    private TestSuitePK id;
    @Column(name = "test_suite_status")
    @Enumerated(value = EnumType.STRING)
    private TestSuiteStatus status;
    @OneToMany
    private Set<TestCase> testCases;
    @MapsId(value="projectId")
    @ManyToOne //maybe remove this one
    @JoinColumn(name = "project_id", referencedColumnName = "project_id")
    private Project project;


    public void addTestCase(TestCase testCase){
        this.testCases.add(testCase);
    }
    public TestSuite() {
    }

    public TestSuite(TestSuitePK id, TestSuiteStatus status, Set<TestCase> testCases, Project project) {
        this.id = id;
        this.status = status;
        this.testCases = testCases;
        this.project = project;
    }

    public TestSuitePK getId() {
        return id;
    }

    public void setId(TestSuitePK id) {
        this.id = id;
    }

    public TestSuiteStatus getStatus() {
        return status;
    }

    public void setStatus(TestSuiteStatus status) {
        this.status = status;
    }

    public Set<TestCase> getTestCases() {
        return testCases;
    }

    public void setTestCases(Set<TestCase> testCases) {
        this.testCases = testCases;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
