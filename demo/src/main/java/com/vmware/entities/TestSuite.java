package com.vmware.entities;

import com.vmware.enums.TestSuiteStatus;

import javax.persistence.*;
import java.util.Set;
@Entity
@Table(name = "test_suite")
public class TestSuite {
    @EmbeddedId
    private TestSuitePK id;
    @Column(name = "test_suite_status")
    private TestSuiteStatus status;
    @OneToMany
    private Set<TestCase> testCases;
    @MapsId(value="projectId")
    @ManyToOne
    @JoinColumn(name = "project_id", referencedColumnName = "project_id")
    private Project project;
}
