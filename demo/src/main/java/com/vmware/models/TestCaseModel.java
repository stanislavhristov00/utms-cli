package com.vmware.models;

import com.vmware.enums.TestCaseStatus;


public class TestCaseModel {
    private String name;
    private String description;
    private boolean enabled;
    private String status;
    private String output;
    private String startTime;
    private String endTime;
    private String error;

    public TestCaseModel() {
    }

    public TestCaseModel(String name, String description, boolean enabled, TestCaseStatus status, String output, String startTime, String endTime, String error) {
        this.name = name;
        this.description = description;
        this.enabled = enabled;
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
        this.startTime = startTime;
        this.endTime = endTime;
        this.error = error;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
