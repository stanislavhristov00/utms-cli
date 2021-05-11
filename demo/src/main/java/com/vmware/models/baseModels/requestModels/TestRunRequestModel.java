package com.vmware.models.baseModels.requestModels;

import java.util.List;
import java.util.Set;

public class TestRunRequestModel {
    //private Long runId;
    private ProjectRequestModel project;
    private String status;
    private List<TestSuiteRequestModel> suites;

    public TestRunRequestModel(/*Long runId,*/ProjectRequestModel project, String status, List<TestSuiteRequestModel> suites) {
        /*this.runId = runId;*/
        this.project = project;
        this.status = status;
        this.suites = suites;
    }

    public TestRunRequestModel() {
    }

    /*public Long getRunId() {
        return runId;
    }

    public void setRunId(Long runId) {
        this.runId = runId;
    }*/

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
