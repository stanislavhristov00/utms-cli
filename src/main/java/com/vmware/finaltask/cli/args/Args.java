package com.vmware.finaltask.cli.args;

import com.beust.jcommander.Parameter;

public class Args {
    @Parameter(names = {"--config", "-c"}, description = "Path to config file")
    private String config;

    @Parameter(names = {"--debug", "-d"}, description = "Toggle debug mode")
    private boolean debug;

    @Parameter(names = {"--server", "-s"}, description = "Address for sending the generated report", required = true)
    private String address;

    public boolean isDebug() {
        return debug;
    }

    public String getAddress() {
        return address;
    }

    public String getConfig() {
        return config;
    }

}
