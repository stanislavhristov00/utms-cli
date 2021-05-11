package com.vmware.models.baseModels.requestModels;

public class ProjectRequestModel {
    private String name;
    private String description;

    public ProjectRequestModel() {
    }

    public ProjectRequestModel(String name, String description) {
        this.name = name;
        this.description = description;
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
}
