package com.vmware.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vmware.enums.TestSuiteStatus;

import javax.persistence.*;
import java.util.Set;
@Entity
@Table(name = "test_suite")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "testCases"})
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "testRun"})
public class TestSuite {
    @EmbeddedId
    private TestSuitePK id;
    @Column(name = "test_suite_status")
    @Enumerated(value = EnumType.STRING)
    private TestSuiteStatus status;
    @OneToMany
    private Set<TestCase> testCases;
    @MapsId(value="runId")
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "test_run_id", referencedColumnName = "test_run_id"),
            @JoinColumn(name = "project_id", referencedColumnName = "project_id")
    })
    private TestRun testRun;


    public void addTestCase(TestCase testCase){
        this.testCases.add(testCase);
    }
    public TestSuite() {
    }

    public TestSuite(TestSuitePK id, TestSuiteStatus status, Set<TestCase> testCases, TestRun testRun) {
        this.id = id;
        this.status = status;
        this.testCases = testCases;
        this.testRun = testRun;
    }

    public TestRun getTestRun() {
        return testRun;
    }

    public void setTestRun(TestRun testRun) {
        this.testRun = testRun;
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


}
