package com.vmware.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class TestRunPK implements Serializable {
    @Column(name = "project_id")
    private Long projectId;
    @Column(name = "test_run_id")
    private Long testRunId;

    public TestRunPK(Long projectId, Long testRunId) {
        this.projectId = projectId;
        this.testRunId = testRunId;
    }

    public TestRunPK() {
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getTestRunId() {
        return testRunId;
    }

    public void setTestRunId(Long testRunId) {
        this.testRunId = testRunId;
    }
}
