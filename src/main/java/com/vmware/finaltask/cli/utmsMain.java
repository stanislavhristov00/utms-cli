package com.vmware.finaltask.cli;

import com.vmware.finaltask.cli.ProjectCreatorService.ProjectService;
import com.vmware.finaltask.cli.tests.Project;
import java.util.Map;

public class utmsMain {
    public static void main(String[] args) {
        YamlParser yamlParser = new YamlParser("testing.yaml");
        Map<String, Object> map = yamlParser.parse();
        Project p = ProjectService.generateProject(map);
        p.print();
    }
}
