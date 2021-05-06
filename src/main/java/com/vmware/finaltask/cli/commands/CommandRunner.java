package com.vmware.finaltask.cli.commands;

import com.vmware.finaltask.cli.testresults.ExecutedCommand;
import com.vmware.finaltask.cli.testresults.TestResults;
import com.vmware.finaltask.cli.tests.Test;

public class CommandRunner {

    public static TestResults executeTest(Test test){
        if(!test.getEnabled()) {
            return new TestResults();
        }

        String command = test.getCommand();
        String description = test.getDescription();
        return null;
    }

    private static ExecutedCommand runCommand(String command){

        return null;
    }
}
