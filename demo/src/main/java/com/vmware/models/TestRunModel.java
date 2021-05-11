package com.vmware.models;

import com.vmware.entities.TestSuite;
import com.vmware.enums.TestSuiteStatus;

import java.util.Set;

public class TestRunModel {
    private Long id;
    private String status;
    private Set<TestSuiteModel> testSuites;

    public TestRunModel(Long id, TestSuiteStatus status, Set<TestSuiteModel> testSuites) {
        this.id = id;
        switch (status){
            case PASSED:
                this.status = "PASSED";
                break;
            case FAILED:
                this.status = "FAILED";
                break;
            case SKIPPED:
                this.status = "SKIPPED";
                break;
        }
        this.testSuites = testSuites;
    }

    public TestRunModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<TestSuiteModel> getTestSuites() {
        return testSuites;
    }

    public void setTestSuites(Set<TestSuiteModel> testSuites) {
        this.testSuites = testSuites;
    }
}
