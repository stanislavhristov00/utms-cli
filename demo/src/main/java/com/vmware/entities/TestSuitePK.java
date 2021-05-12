package com.vmware.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class TestSuitePK implements Serializable {
    @Column(name = "test_suite_name")
    private String name;
    @Column(name = "test_run_id")
    private TestRunPK testRunPK;

    public TestSuitePK() {
    }


    public TestSuitePK(String name, TestRunPK testRunPK) {
        this.name = name;
        this.testRunPK = testRunPK;
    }

    public TestRunPK getTestRunPK() {
        return testRunPK;
    }

    public void setTestRunPK(TestRunPK testRunPK) {
        this.testRunPK = testRunPK;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
