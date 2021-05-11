package com.vmware.models.baseModels;

import com.vmware.enums.TestSuiteStatus;

import java.util.Set;

public class TestSuiteModel {
    private String name;
    private Set<TestCaseModel> testCases;

    public TestSuiteModel() {
    }

    public TestSuiteModel(String name, Set<TestCaseModel> testCases) {
        this.name = name;
        this.testCases = testCases;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<TestCaseModel> getTestCases() {
        return testCases;
    }

    public void setTestCases(Set<TestCaseModel> testCases) {
        this.testCases = testCases;
    }
}
