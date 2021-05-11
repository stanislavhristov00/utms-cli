package com.vmware.models.baseModels.requestModels;

import java.util.LinkedHashMap;

public class TestSuiteRequestModel {
    private String name;
    private String status;
    private LinkedHashMap<String,TestCaseRequestModel> tests;

    public TestSuiteRequestModel() {
    }

    public TestSuiteRequestModel(String name, String status, LinkedHashMap<String, TestCaseRequestModel> tests) {
        this.name = name;
        this.status = status;
        this.tests = tests;
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

    public LinkedHashMap<String, TestCaseRequestModel> getTests() {
        return tests;
    }

    public void setTests(LinkedHashMap<String, TestCaseRequestModel> tests) {
        this.tests = tests;
    }
}
