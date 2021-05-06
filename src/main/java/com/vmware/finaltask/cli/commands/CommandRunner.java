package com.vmware.finaltask.cli.commands;

import com.vmware.finaltask.cli.testresults.ExecutedCommand;
import com.vmware.finaltask.cli.testresults.ProjectResults;
import com.vmware.finaltask.cli.testresults.TestResults;
import com.vmware.finaltask.cli.testresults.TestSuiteResults;
import com.vmware.finaltask.cli.tests.Project;
import com.vmware.finaltask.cli.tests.Test;
import com.vmware.finaltask.cli.tests.TestSuite;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class CommandRunner {

    private CommandRunner(){}

    public static ProjectResults executeProject(Project project, int runId){
        boolean status = true;
        List<TestSuite> ts = project.getSuites();
        List<TestSuiteResults> tsRes = new ArrayList<>();
        for(TestSuite t : ts){
            TestSuiteResults tmp = executeTestSuite(t);
            if(tmp.getStatus() == "failed"){
                status = false;
            }
            tsRes.add(tmp);
        }
        String finalStatus = (status == true)? "passed" : "failed";
        return new ProjectResults(runId,project.getName(),project.getDescription(),finalStatus, tsRes);
    }

    public static TestSuiteResults executeTestSuite(TestSuite suite){
        boolean status = true;
        List<Test> tests = suite.getTests();
        List<TestResults> testResults = new ArrayList<>();
        for(Test test : tests) {
            TestResults tmp = executeTest(test);
            if (tmp.getStatus() == "failed") {
                status = false;
            }
            testResults.add(tmp);
        }
        String finalStatus = (status == true) ? "passed" : "failed";
        return new TestSuiteResults(suite.getName(), finalStatus, testResults);
    }

    public static TestResults executeTest(Test test) {
        if (!test.getEnabled()) {
            return new TestResults(test.getName());
        }

        String command = test.getCommand();
        String description = test.getDescription();
        try {
            ExecutedCommand executedCommand = runCommand(command);
            String status = (executedCommand.getExitCode() == 0) ? "passed" : "failed";
            return new TestResults(test.getName(), description, status, executedCommand);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new TestResults(test.getName()); // TODO: THINK ABOUT ALTERNATIVES
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
        int exitCode; // still wondering if exitValue() or waitFor()
        try{
            exitCode = process.waitFor();
        }catch (InterruptedException e){
            exitCode = 1;
        }
        return new ExecutedCommand(encode(output.toString()),
                encode(error.toString()),
                start.toString(),
                end.toString(),
                exitCode);
    }

    private static String encode(String str) {
        return Base64.getEncoder().encodeToString(str.getBytes());
    }
}
