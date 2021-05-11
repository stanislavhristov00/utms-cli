package com.vmware.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vmware.enums.TestSuiteStatus;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "test_run")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "project"})
public class TestRun {
    @EmbeddedId
    private TestRunPK id;
    @Enumerated(value = EnumType.STRING)
    private TestSuiteStatus status;
    @OneToMany
    private Set<TestSuite> testSuites;
    @MapsId(value = "projectId")
    @ManyToOne
    @JoinColumn(name = "project_id", referencedColumnName = "project_id")
    private Project project;

    public void addTestSuite(TestSuite testSuite){
        this.testSuites.add(testSuite);
    }
    public TestRun() {
    }

    public TestRun(TestRunPK id, TestSuiteStatus status, Set<TestSuite> testSuites, Project project) {
        this.id = id;
        this.status = status;
        this.testSuites = testSuites;
        this.project = project;
    }

    public TestRunPK getId() {
        return id;
    }

    public void setId(TestRunPK id) {
        this.id = id;
    }

    public TestSuiteStatus getStatus() {
        return status;
    }

    public void setStatus(TestSuiteStatus status) {
        this.status = status;
    }

    public Set<TestSuite> getTestSuites() {
        return testSuites;
    }

    public void setTestSuites(Set<TestSuite> testSuites) {
        this.testSuites = testSuites;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
