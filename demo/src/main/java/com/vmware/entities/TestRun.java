package com.vmware.entities;

import com.vmware.enums.TestSuiteStatus;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "test_run")
public class TestRun {
    @EmbeddedId
    private TestRunPK id;
    @Enumerated(value = EnumType.STRING)
    private TestSuiteStatus status;
    @OneToMany
    private Set<TestSuite> testSuites;
    @MapsId(value = "projectId")
    @ManyToOne
    @JoinColumn(name = "project_id", referencedColumnName = "project_id")
    private Project project;
}
