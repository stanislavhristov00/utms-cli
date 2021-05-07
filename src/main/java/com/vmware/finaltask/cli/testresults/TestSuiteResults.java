package com.vmware.finaltask.cli.testresults;

import java.util.List;

public class TestSuiteResults {
    private String name;
    private String status;
    private List<TestResults> tests;

    public TestSuiteResults(String name, String status, List<TestResults> tests) {
        this.name = name;
        this.status = status;
        this.tests = tests;
    }

    public String getName() {
        return name;
    }

    public List<TestResults> getTests() {
        return tests;
    }

    public String getStatus(){
        return this.status;
    }

    public void print() {
        System.out.println("SUITE NAME: " + this.name);
        System.out.println("STATUS: " + this.status);
        for(TestResults tr : tests){
            tr.print();
        }
    }
}
