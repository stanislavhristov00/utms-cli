package com.vmware.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "project")
public class Project {
    @Id
    @Column(name = "project_id")
    private Long id;
    @Column(name = "project_name")
    private String name;
    @OneToMany
    private Set<TestRun> testRuns;
}
