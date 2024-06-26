package com.vmware.finaltask.cli.testresults;

import java.util.List;

public class ProjectResults {
    private String name;
    private String description;
    private String status;
    private List<TestSuiteResults> suites;

    public ProjectResults(String name, String description, String status, List<TestSuiteResults> suites) {
        this.name = name;
        this.description = description;
        this.status = status;
        this.suites = suites;
    }


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public List<TestSuiteResults> getSuites() {
        return suites;
    }

    public void print(){
        System.out.println("PROJECT NAME: " + this.name);
        System.out.println("PROJECT DESC: " + this.description);
        System.out.println("PROJECT STATUS: " + this.status);
        for(TestSuiteResults ts : suites){
            ts.print();
        }
    }
}
