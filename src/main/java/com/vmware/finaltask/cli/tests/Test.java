package com.vmware.finaltask.cli.tests;

public class Test {
    private String name;
    private boolean enabled;
    private String command;
    private String description;

    public Test(String name, boolean enabled, String command, String description) {
        this.name = name;
        this.enabled = enabled;
        this.command = command;
        this.description = description;
    }

    public void print() {
        System.out.println("NAME: " + this.name);
        System.out.println("ENABLED: " + this.enabled);
        System.out.println("COMMAND: " + this.command);
        System.out.println("DESCRIPTION: "+ this.description);
    }
}
