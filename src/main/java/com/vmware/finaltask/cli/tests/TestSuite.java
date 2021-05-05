package com.vmware.finaltask.cli.tests;

import java.util.List;

public class TestSuite {
    private String name;
    private List<Test> tests;

    public TestSuite(String name, List<Test> tests) {
        this.name = name;
        this.tests = tests;
    }

    public void addTest(Test test){
        this.tests.add(test);
    }

    public void print(){
        System.out.println("SUITE NAME: " + this.name);
        for(Test t : this.tests){
            t.print();
        }
    }
}
