package com.vmware.models.baseModels;

import com.vmware.enums.TestSuiteStatus;

import java.util.Set;

public class TestRunModel {
    private String status;
    private Set<TestSuiteModel> testSuites;

    public TestRunModel(TestSuiteStatus status, Set<TestSuiteModel> testSuites) {
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
