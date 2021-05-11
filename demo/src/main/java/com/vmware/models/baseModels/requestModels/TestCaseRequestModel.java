package com.vmware.models.baseModels.requestModels;

public class TestCaseRequestModel {
    private String output;
    private String error;
    private String status;
    private String description;
    private String startDate;
    private String endDate;

    public TestCaseRequestModel() {
    }

    public TestCaseRequestModel(String output, String error, String status, String description, String startDate, String endDate) {
        this.output = output;
        this.error = error;
        this.status = status;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
