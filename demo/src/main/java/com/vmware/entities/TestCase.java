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
    @MapsId(value= "testSuiteId")
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name="test_suite_name", referencedColumnName = "test_suite_name"),
            @JoinColumn(name="project_id", referencedColumnName = "project_id")
    })
    private TestSuite testSuite;
}
