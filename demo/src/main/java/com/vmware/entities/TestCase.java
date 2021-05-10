package com.vmware.entities;

import com.vmware.enums.TestCaseStatus;

import javax.persistence.*;

@Entity
@Table(name = "test_case")
public class TestCase {
    @EmbeddedId
    private TestCasePK id;
    @Column(name = "test_case_description")
    private String description;
    @Column(name = "test_case_enabled")
    private boolean enabled;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "test_case_status")
    private TestCaseStatus status;
    @Column(name = "test_case_output")
    private String output;
    @Column(name = "test_case_start_time")
    private String startTime;
    @Column(name = "test_case_end_time")
    private String endTime;
    @Column(name = "test_case_error_output")
    private String error;
    @MapsId(value= "testSuitePK") // used to be testSuiteId
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name="test_suite_name", referencedColumnName = "test_suite_name"),
            @JoinColumn(name="project_id", referencedColumnName = "project_id")
    })
    private TestSuite testSuite;

    public TestCase(TestCasePK id, String description,
                    boolean enabled, TestCaseStatus status,
                    String output, String startTime,
                    String endTime, String error, TestSuite testSuite) {
        this.id = id;
        this.description = description;
        this.enabled = enabled;
        this.status = status;
        this.output = output;
        this.startTime = startTime;
        this.endTime = endTime;
        this.error = error;
        this.testSuite = testSuite;
    }

    public TestCase() {
    }

    public TestCasePK getId() {
        return id;
    }

    public void setId(TestCasePK id) {
        this.id = id;
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

    public TestCaseStatus getStatus() {
        return status;
    }

    public void setStatus(TestCaseStatus status) {
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

    public TestSuite getTestSuite() {
        return testSuite;
    }

    public void setTestSuite(TestSuite testSuite) {
        this.testSuite = testSuite;
    }
}
