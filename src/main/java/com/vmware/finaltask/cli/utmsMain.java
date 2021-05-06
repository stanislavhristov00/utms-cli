package com.vmware.finaltask.cli;

import com.vmware.finaltask.cli.ProjectCreatorService.ProjectService;
import com.vmware.finaltask.cli.commands.CommandRunner;
import com.vmware.finaltask.cli.testresults.TestResults;
import com.vmware.finaltask.cli.tests.Project;
import com.vmware.finaltask.cli.tests.Test;

import java.util.Map;

public class utmsMain {
    public static void main(String[] args) {
        /*YamlParser yamlParser = new YamlParser("testing.yaml");
        Map<String, Object> map = yamlParser.parse();
        Project p = ProjectService.generateProject(map);
        p.print();*/

        Test test = new Test("Test 1", true, "cmd.exe /c echo Test", null);
        TestResults testResults = CommandRunner.executeTest(test);
        testResults.print();
    }
}
