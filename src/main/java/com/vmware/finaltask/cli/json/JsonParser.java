package com.vmware.finaltask.cli.json;

import com.vmware.finaltask.cli.testresults.ProjectResults;
import com.vmware.finaltask.cli.testresults.TestResults;
import com.vmware.finaltask.cli.testresults.TestSuiteResults;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.List;

public class JsonParser {
    private JsonParser() {}

    public static JSONObject parseProject(ProjectResults projectResults){
        JSONObject project = new JSONObject();

        JSONObject projectInside = new JSONObject();
        projectInside.put("name", projectResults.getName());
        projectInside.put("description", projectResults.getDescription());

        project.put("project", projectInside);
        project.put("status", projectResults.getStatus());
        project.put("suites", parseSuites(projectResults.getSuites()));
        return project;
    }

    public static JSONArray parseSuites(List<TestSuiteResults> testSuiteResults){
        JSONArray jsonArray = new JSONArray();
        for(TestSuiteResults tr : testSuiteResults){
            jsonArray.add(parseSuite(tr));
        }
        return jsonArray;
    }

    public static JSONObject parseSuite(TestSuiteResults testSuiteResults){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", testSuiteResults.getName());
        jsonObject.put("status", testSuiteResults.getStatus());
        jsonObject.put("tests", parseTests(testSuiteResults.getTests()));
        return jsonObject;
    }

    public static JSONObject parseTests(List<TestResults> ls){
        JSONObject tests = new JSONObject();
        for(TestResults t : ls){
            tests.put(t.getName(), parseTest(t));
        }
        return tests;
    }

    public static JSONObject parseTest(TestResults test){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("description", test.getDescription());
        jsonObject.put("output", test.getCommand().getOutput());
        jsonObject.put("error", test.getCommand().getError());
        jsonObject.put("status",test.getStatus());
        jsonObject.put("startDate", test.getCommand().getStartDate());
        jsonObject.put("endDate", test.getCommand().getEndDate());
        return jsonObject;
    }
}
