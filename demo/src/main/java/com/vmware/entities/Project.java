package com.vmware.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "project")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "testRuns"})
public class Project {
    @Id
    @Column(name = "project_id")
    private Long id;
    @Column(name = "project_name", unique = true)
    private String name;
    @Column(name = "project_description")
    private String description;
    @OneToMany
    private Set<TestRun> testRuns;

    public void addTestRun(TestRun testRun){
        this.testRuns.add(testRun);
    }
    public Project() {
    }

    public Project(Long id, String name, String description, Set<TestRun> testRuns) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.testRuns = testRuns;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<TestRun> getTestRuns() {
        return testRuns;
    }

    public void setTestRuns(Set<TestRun> testRuns) {
        this.testRuns = testRuns;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
