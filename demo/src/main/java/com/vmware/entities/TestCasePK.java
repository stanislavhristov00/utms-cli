package com.vmware.entities;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class TestCasePK implements Serializable {
    private String name;
    private TestSuitePK testSuitePK;

    public TestCasePK() {
    }

    public TestCasePK(String name, TestSuitePK testSuitePK) {
        this.name = name;
        this.testSuitePK = testSuitePK;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TestSuitePK getTestSuitePK() {
        return testSuitePK;
    }

    public void setTestSuitePK(TestSuitePK testSuitePK) {
        this.testSuitePK = testSuitePK;
    }
}
