package com.vmware.finaltask.cli;

import com.vmware.finaltask.cli.ProjectCreatorService.ProjectService;
import com.vmware.finaltask.cli.commands.CommandRunner;
import com.vmware.finaltask.cli.testresults.ProjectResults;
import com.vmware.finaltask.cli.testresults.TestResults;
import com.vmware.finaltask.cli.tests.Project;
import com.vmware.finaltask.cli.tests.Test;
import com.vmware.finaltask.cli.tests.TestSuite;
import com.vmware.finaltask.cli.validation.ParsedYamlValidation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class utmsMain {
    public static void main(String[] args) {
        YamlParser yamlParser = new YamlParser("testing.yaml");
        Map<String, Object> map = yamlParser.parse();
        Project p = ProjectService.generateProject(map);
        ProjectResults pr = CommandRunner.executeProject(p, 1);
        pr.print();
        /*p.print();
        System.out.println(ParsedYamlValidation.validate(map));*/
        /*Test test = new Test("Test 1", true, "cmd.exe /c echo Test", null);
        *//*TestResults testResults = CommandRunner.executeTest(test);
        testResults.print();*//*
        Test test2 = new Test("Test 2", true, "cmd.exe /c echo Test2", "I do something");
        Test test3 = new Test("Test 3", false, "cmd.exe /c echo Test3", null);
        List<Test> ls = new ArrayList<>();
        ls.add(test);
        ls.add(test2);
        ls.add(test3);
        TestSuite ts = new TestSuite("FIRST TRY", ls);
        CommandRunner.executeTestSuite(ts).print();*/
    }
}
