package com.vmware.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vmware.enums.TestCaseStatus;

import javax.persistence.*;

@Entity
@Table(name = "test_case")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "testSuite"})
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
    private String startDate;
    @Column(name = "test_case_end_time")
    private String endDate;
    @Column(name = "test_case_error_output")
    private String error;
    @MapsId(value= "testSuitePK") // used to be testSuiteId
    @ManyToOne //maybe remove this one too
    @JoinColumns({
            @JoinColumn(name="test_suite_name", referencedColumnName = "test_suite_name"),
            @JoinColumn(name="project_id", referencedColumnName = "project_id"),
            @JoinColumn(name="test_run_id", referencedColumnName = "test_run_id")
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
        this.startDate = startTime;
        this.endDate = endTime;
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
