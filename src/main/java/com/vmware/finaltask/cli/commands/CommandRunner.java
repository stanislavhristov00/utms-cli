package com.vmware.finaltask.cli.commands;

import com.vmware.finaltask.cli.testresults.ExecutedCommand;
import com.vmware.finaltask.cli.testresults.TestResults;
import com.vmware.finaltask.cli.tests.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Instant;
import java.util.Base64;

public class CommandRunner {

    private CommandRunner(){}

    public static TestResults executeTest(Test test) {
        if (!test.getEnabled()) {
            return new TestResults();
        }

        String command = test.getCommand();
        String description = test.getDescription();
        try {
            ExecutedCommand executedCommand = runCommand(command);
            String status = (executedCommand.getExitCode() == 0) ? "passed" : "failed";
            return new TestResults(description, status, executedCommand);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new TestResults(); // TODO: THINK ABOUT ALTERNATIVES
    }

    private static ExecutedCommand runCommand(String command) throws IOException {
        Instant start = Instant.now();
        Process process = Runtime.getRuntime().exec(command);
        Instant end = Instant.now();    // get begin and end time of command
        StringBuilder output = new StringBuilder();
        StringBuilder error = new StringBuilder();
        BufferedReader readOutput = new BufferedReader(new InputStreamReader(process.getInputStream()));
        BufferedReader errorOutput = new BufferedReader(new InputStreamReader(process.getErrorStream()));
        String line;
        while ((line = readOutput.readLine()) != null) {
            output.append(line);
        }
        while ((line = errorOutput.readLine()) != null) {
            error.append(line);
        }
        readOutput.close();
        errorOutput.close();

        return new ExecutedCommand(encode(output.toString()),
                encode(error.toString()),
                start.toString(),
                end.toString(),
                process.exitValue());
    }

    private static String encode(String str) {
        return Base64.getEncoder().encodeToString(str.getBytes());
    }
}
