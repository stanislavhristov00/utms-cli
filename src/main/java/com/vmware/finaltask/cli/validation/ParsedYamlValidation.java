package com.vmware.finaltask.cli.validation;

//TODO: EACH TEST MUST HAVE A COMMAND AND ENABLED PROPERTY. THEY MUST BE NOT NULL.
//DESCRIPTION IS NOT NECESSARY

import com.vmware.finaltask.cli.tests.Test;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ParsedYamlValidation {
    private ParsedYamlValidation() {}

    public static boolean validate(Map<String, Object> map){
        if(map == null){
            return false;
        }
        if(map.get("project") == null || map.get("suites") == null){
            return false;
        }
        LinkedHashMap<String, Object> project = (LinkedHashMap<String, Object>) map.get("project");
        if(project.get("name") == null || project.get("description") == null){
            return false;
        }
        List<Object> suites = (List<Object>) map.get("suites");
        for(Object o : suites){
            LinkedHashMap<String, Object> suiteMap = (LinkedHashMap<String, Object>) o;
            List<Object> ls =  (List<Object>) suiteMap.entrySet().iterator().next().getValue();
            for(Object test : ls){
                LinkedHashMap<String, Object> testMap = (LinkedHashMap<String, Object>) test;
                if(testMap.get("command") == null || testMap.get("enabled") == null){
                    return false;
                }
            }
        }
        return true;
    }
}
