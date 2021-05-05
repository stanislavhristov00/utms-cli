package com.vmware.finaltask.cli;

import com.vmware.finaltask.cli.ProjectCreatorService.ProjectService;
import com.vmware.finaltask.cli.tests.Project;
import com.vmware.finaltask.cli.tests.TestSuite;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class utmsMain {
    public static void main(String[] args) {
        /*//System.out.println("This is the first command line argument" +  args[0]);
        yamlParser yaml = new yamlParser("testing.yaml");
        Map<String, Object> obj = yaml.parse();
        System.out.println(obj.get("suites").getClass());
        List<Object> suites = (List<Object>) obj.get("suites");

        //suites - arraylist
        // objects inside suites - linkedhashmap
        // key of object - string
        // value of object - arraylist

        for(Object o : suites){
            LinkedHashMap<String, Object> map = (LinkedHashMap<String, Object>) o;
            for(Map.Entry<String, Object> entry : map.entrySet()){
                System.out.println(entry.getKey());
                System.out.println(entry.getValue().getClass());
                System.out.println("FOR:");
                List<Object> ls = (List<Object>) entry.getValue();
                for(Object ob : ls){
                    System.out.println(ob);
                }
            }
        }*/
        /*ProjectService projectService = new ProjectService();
        YamlParser yamlParser = new YamlParser("testing.yaml");
        Map<String, Object> map = yamlParser.parse();
        System.out.println((LinkedHashMap<String, Object>) map.get("project"));
        List<TestSuite> testSuites = new ArrayList<>();
        List<Object> suites = (List<Object>) map.get("suites");
        for(Object o : suites){
            LinkedHashMap<String,Object> suiteMap = (LinkedHashMap<String, Object>) o;
            TestSuite tmp = projectService.createTestSuite(suiteMap);
            testSuites.add(tmp);
        }

        for(TestSuite t : testSuites){
            t.print();
        }*/
        YamlParser yamlParser = new YamlParser("testing.yaml");
        Map<String, Object> map = yamlParser.parse();
        Project p = ProjectService.generateProject(map);
        p.print();
    }
}
