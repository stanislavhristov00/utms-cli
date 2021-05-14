package com.vmware.models.baseModels;

import com.vmware.enums.TestCaseStatus;


public class TestCaseModel {
    private String name;
    private String status;
    private String output;
    private String error;
    private String startDate;
    private String endDate;

    public TestCaseModel() {
    }

    public TestCaseModel(String name, TestCaseStatus status, String output, String error, String startDate, String endDate) {
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
            case STARTED:
                this.status = "STARTED";
                break;
        }
        this.output = output;
        this.error = error;
        this.startDate = startDate;
        this.endDate = endDate;
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

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
