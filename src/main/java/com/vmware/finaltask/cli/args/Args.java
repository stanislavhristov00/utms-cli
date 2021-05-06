package com.vmware.finaltask.cli.args;

import com.beust.jcommander.Parameter;

public class Args {
    @Parameter(names = {"--config", "-c"}, description = "Path to config file")
    private String config;

    @Parameter(names = {"--run-id", "-r"}, description = "Run id of project")
    private Integer runId;

    public String getConfig() {
        return config;
    }

    public Integer getRunId() {
        return runId;
    }
}
