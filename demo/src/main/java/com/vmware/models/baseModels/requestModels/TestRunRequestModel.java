package com.vmware.models.baseModels.requestModels;

import java.util.List;

public class TestRunRequestModel {
    private ProjectRequestModel project;
    private String status;
    private List<TestSuiteRequestModel> suites;

    public TestRunRequestModel(ProjectRequestModel project, String status, List<TestSuiteRequestModel> suites) {
        this.project = project;
        this.status = status;
        this.suites = suites;
    }

    public TestRunRequestModel() {
    }


    public ProjectRequestModel getProject() {
        return project;
    }

    public void setProject(ProjectRequestModel project) {
        this.project = project;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<TestSuiteRequestModel> getSuites() {
        return suites;
    }

    public void setSuites(List<TestSuiteRequestModel> suites) {
        this.suites = suites;
    }
}
