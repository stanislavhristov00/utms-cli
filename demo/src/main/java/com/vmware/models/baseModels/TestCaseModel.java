package com.vmware.models.baseModels;

import com.vmware.enums.TestCaseStatus;


public class TestCaseModel {
    private String name;
    private String status;

    public TestCaseModel() {
    }

    public TestCaseModel(String name, TestCaseStatus status) {
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
}
