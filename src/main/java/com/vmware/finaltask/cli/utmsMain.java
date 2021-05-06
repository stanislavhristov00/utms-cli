package com.vmware.finaltask.cli;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;
import com.vmware.finaltask.cli.ProjectCreatorService.ProjectService;
import com.vmware.finaltask.cli.args.Args;
import com.vmware.finaltask.cli.commands.CommandRunner;
import com.vmware.finaltask.cli.testresults.ProjectResults;
import com.vmware.finaltask.cli.testresults.TestResults;
import com.vmware.finaltask.cli.tests.Project;
import com.vmware.finaltask.cli.tests.Test;
import com.vmware.finaltask.cli.tests.TestSuite;
import com.vmware.finaltask.cli.validation.ParsedYamlValidation;
import org.yaml.snakeyaml.error.YAMLException;

import java.io.File;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class utmsMain {

    public static void main(String[] args) {
        try{
        Args argf = new Args();
        JCommander flags = JCommander.newBuilder()
                .addObject(argf)
                .build();
        flags.parse(args);
        String filePath = "testing.yaml";
        int runid = 1;
        if(argf.getConfig() != null){
            filePath = argf.getConfig();
        }
        if(argf.getRunId() != null){
            runid = argf.getRunId();
        }
            YamlParser yamlParser = new YamlParser(filePath);
            Map<String, Object> map = yamlParser.parse();
            if(ParsedYamlValidation.validate(map)){
                Project p = ProjectService.generateProject(map);
                ProjectResults pr = CommandRunner.executeProject(p, runid);
                pr.print();
            }else{
                System.out.println("Config file is not valid");
            }
        }catch (IllegalArgumentException e){
            System.out.println("File format for windows must be file:/(DISK):/(FOLDER)/...");
        }catch (YAMLException yamlException){
            System.out.println("File doesn't exist");
        }catch (ParameterException parameterException){
            System.out.println("Run id should be a number my dude");
        }
    }
}
