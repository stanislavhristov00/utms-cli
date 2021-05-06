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

    public String getName(){
        return this.name;
    }

    public String getDescription(){
        return this.description;
    }

    public List<TestSuite> getSuites(){
        return this.suites;
    }

    public void print() {
        System.out.println("PROJECT NAME: " + this.name);
        System.out.println("PROJECT DESCRIPTION " + this.description);
        for(TestSuite t: suites){
            t.print();
        }
    }
}
