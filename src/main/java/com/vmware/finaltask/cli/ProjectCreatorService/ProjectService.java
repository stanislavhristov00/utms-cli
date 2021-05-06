package com.vmware.finaltask.cli.ProjectCreatorService;

import com.vmware.finaltask.cli.tests.Project;
import com.vmware.finaltask.cli.tests.Test;
import com.vmware.finaltask.cli.tests.TestSuite;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ProjectService {
    private ProjectService() {}

    public static Project generateProject(Map<String, Object> parsedYaml){
        LinkedHashMap<String, Object> project = (LinkedHashMap<String, Object>) parsedYaml.get("project");
        String name = (String) project.get("name");
        String description = (String) project.get("description");
        List<Object> suites = (List<Object>) parsedYaml.get("suites");
        List<TestSuite> testSuites = new ArrayList<>();
        for(Object o : suites){
            LinkedHashMap<String,Object> suiteMap = (LinkedHashMap<String, Object>) o;
            TestSuite tmp = createTestSuite(suiteMap);
            testSuites.add(tmp);
        }
        return new Project(name, description, testSuites);
    }

    public static TestSuite createTestSuite(Map<String, Object> testSuite){
        List<Test> tests = new ArrayList<>();
        String name = testSuite.entrySet().iterator().next().getKey();
        TestSuite result = new TestSuite(name, tests);
        List<Object> ls =  (List<Object>) testSuite.entrySet().iterator().next().getValue();
        for(Object o : ls){
            LinkedHashMap<String, Object> testMap = (LinkedHashMap<String, Object>) o;
            Test tmp = createTest(testMap);
            result.addTest(tmp);
        }
        return result;
    }

    public static Test createTest(Map<String, Object> test){
        String name = test.entrySet().iterator().next().getKey();
        String description = (String) test.get("description");
        Boolean enabled = (Boolean) test.get("enabled");
        String command = (String) test.get("command");
        return new Test(name, enabled, command, description);
    }
}
