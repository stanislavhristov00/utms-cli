package com.vmware.finaltask.cli.testresults;

public class TestResults {
    private String name;
    private String description;
    private String status;
    private ExecutedCommand command;

    public TestResults(String name){
        this.name = name;
        this.description = null;
        this.status = "skipped";
        this.command = new ExecutedCommand();
    }

    public TestResults(String name, String description, String status, ExecutedCommand command){
        this.name = name;
        this.description = description;
        this.status = status;
        this.command = command;
    }

    public String getStatus(){
        return this.status;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public ExecutedCommand getCommand() {
        return command;
    }

    public void print(){
        System.out.println("NAME: " + this.name);
        System.out.println("DESCRIPTION: " + this.description);
        System.out.println("STATUS: " + this.status);
        this.command.print();
    }

}
