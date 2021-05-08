package com.vmware.finaltask.cli;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;
import com.vmware.finaltask.cli.ProjectCreatorService.ProjectService;
import com.vmware.finaltask.cli.args.Args;
import com.vmware.finaltask.cli.commands.CommandRunner;
import com.vmware.finaltask.cli.interfaces.Parser;
import com.vmware.finaltask.cli.json.JsonError;
import com.vmware.finaltask.cli.json.JsonParser;
import com.vmware.finaltask.cli.testresults.ProjectResults;
import com.vmware.finaltask.cli.tests.Project;
import com.vmware.finaltask.cli.validation.ParsedYamlValidation;

import java.io.FileNotFoundException;
import java.util.Map;

public class UtmsMain {

    public static void main(String[] args) {
        try{
        Args argf = new Args();
        JCommander flags = JCommander.newBuilder()
                .addObject(argf)
                .build();
        flags.parse(args);
        String filePath = "D:\\testing.yaml"; // TODO: ask for default value?
        int runid = 1;
        if(argf.getConfig() != null){
            filePath = argf.getConfig();
        }
        if(argf.getRunId() != null){
            runid = argf.getRunId();
        }
            Parser yamlParser = new YamlParser(filePath);
            Map<String, Object> map = yamlParser.parse();
            if(ParsedYamlValidation.validate(map)){
                Project p = ProjectService.generateProject(map);
                ProjectResults pr = CommandRunner.executeProject(p, runid);
                System.out.println(JsonParser.parseProject(pr));
            }else{
                System.out.println(JsonError.configFileNotValid());
            }
        }catch (FileNotFoundException e){
            System.out.println(JsonError.configFileNotFound());
        }catch (ParameterException parameterException){
            System.out.println(JsonError.runidIsNotValid());
        }catch (ClassCastException e){
            System.out.println("File format is wrong");
        }
    }
} // TODO: maybe setup a default testing.yaml for config in Args

