package com.vmware.finaltask.cli.testresults;

public class ExecutedCommand {
    private String output;
    private String error;
    private String startDate;
    private String endDate;

    public ExecutedCommand(){
        this.output = null;
        this.error = null;
        this.startDate = null;
        this.endDate=null;
    }

    public ExecutedCommand(String output, String error, String startDate, String endDate) {
        this.output = output;
        this.error = error;
        this.startDate = startDate;
        this.endDate = endDate;
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
}
