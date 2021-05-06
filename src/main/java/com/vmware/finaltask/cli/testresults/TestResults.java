package com.vmware.finaltask.cli.testresults;

public class TestResults {
    private String description;
    private String status;
    private ExecutedCommand command;

    public TestResults(){
        this.description = null;
        this.status = "skipped";
        this.command = new ExecutedCommand();
    }

    public TestResults(String description, String status, ExecutedCommand command){
        this.description = description;
        this.status = status;
        this.command = command;
    }

}
