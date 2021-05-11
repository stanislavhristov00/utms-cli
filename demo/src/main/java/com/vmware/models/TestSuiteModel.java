package com.vmware.models;

import com.vmware.entities.TestCase;
import com.vmware.enums.TestSuiteStatus;

import java.util.Set;

public class TestSuiteModel {
    private String name;
    private String status;
    private Set<TestCaseModel> testCases;

    public TestSuiteModel() {
    }

    public TestSuiteModel(String name, TestSuiteStatus status, Set<TestCaseModel> testCases) {
        this.name = name;
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
        this.testCases = testCases;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<TestCaseModel> getTestCases() {
        return testCases;
    }

    public void setTestCases(Set<TestCaseModel> testCases) {
        this.testCases = testCases;
    }
}
