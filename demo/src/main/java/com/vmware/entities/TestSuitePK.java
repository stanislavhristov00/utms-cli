package com.vmware.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class TestSuitePK implements Serializable {
    @Column(name = "test_suite_name")
    private String name;
    @Column(name = "project_id")
    private Long projectId;

    public TestSuitePK() {
    }

    public TestSuitePK(String name, Long projectId) {
        this.name = name;
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }
}
