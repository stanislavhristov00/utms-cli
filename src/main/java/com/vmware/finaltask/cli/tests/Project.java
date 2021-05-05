package com.vmware.finaltask.cli.tests;

import java.util.List;

public class Project {
    private String name;
    private String description;
    private List<TestSuite> suites;

    public Project(String name, String description, List<TestSuite> suites){
        this.name = name;
        this.description = description;
        this.suites = suites;
    }
}
