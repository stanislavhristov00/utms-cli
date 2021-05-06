package com.vmware.finaltask.cli.testresults;

public class ExecutedCommand {
    private String output;
    private String error;
    private String startDate;
    private String endDate;
    private int exitCode;

    public ExecutedCommand(){
        this.output = null;
        this.error = null;
        this.startDate = null;
        this.endDate=null;
        this.exitCode = -1;
    }

    public ExecutedCommand(String output, String error, String startDate, String endDate, int exitCode) {
        this.output = output;
        this.error = error;
        this.startDate = startDate;
        this.endDate = endDate;
        this.exitCode = exitCode;
    }

    public String getOutput() {
        return output;
    }

    public String getError() {
        return error;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public int getExitCode(){
        return this.exitCode;
    }

    public void print() {
        System.out.println("OUTPUT: " + this.output);
        System.out.println("ERROR: " + this.error);
        System.out.println("START TIME: " + this.startDate);
        System.out.println("END DATE: " + this.endDate);
    }
}
