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
import org.json.simple.JSONObject;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class UtmsMain {

    public static HttpRequest makeProjectPOSTRequest(String name, String description, String address){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", name);
        jsonObject.put("description", description);
        String requestURI = address + "/projects";

        return HttpRequest.newBuilder()
                .uri(URI.create(requestURI))
                .header("Content-type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonObject.toJSONString()))
                .build();

    }

    public static HttpRequest makeRunPOSTRequest(Long project_id, JSONObject requestBody, String address){
        String requestUri = address + "/projects/" + project_id.toString() + "/runs";
        return HttpRequest.newBuilder()
                .uri(URI.create(requestUri))
                .header("Content-type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody.toJSONString()))
                .build();
    }

    public static void main(String[] args) {
        try {
            Args argf = new Args();
            JCommander flags = JCommander.newBuilder()
                    .addObject(argf)
                    .build();
            flags.parse(args);
            if (argf.isDebug()) {
                String filePath = "D:\\testing.yaml"; 
                if (argf.getConfig() != null) {
                    filePath = argf.getConfig();
                }
                Parser yamlParser = new YamlParser(filePath);
                Map<String, Object> map = yamlParser.parse();
                if (ParsedYamlValidation.validate(map)) {
                    Project p = ProjectService.generateProject(map);
                    ProjectResults pr = CommandRunner.executeProject(p);
                    System.out.println(JsonParser.parseProject(pr));
                } else {
                    System.out.println(JsonError.configFileNotValid());
                }

            } else {
                String server = argf.getAddress();
                final HttpClient client = HttpClient.newHttpClient();
                String filePath = "D:\\testing.yaml";
                if(argf.getConfig() != null){
                    filePath = argf.getConfig();
                }
                Parser yamlParser = new YamlParser(filePath);
                Map<String, Object> map = yamlParser.parse();
                if(ParsedYamlValidation.validate(map)){
                    Project project = ProjectService.generateProject(map);
                    HttpRequest httpRequest = makeProjectPOSTRequest(project.getName(), project.getDescription(), server);
                    HttpResponse<String> httpResponse = client.send(httpRequest,
                            HttpResponse.BodyHandlers.ofString());
                    Long project_id = Long.parseLong(httpResponse.body());
                    if(project_id.equals(-1L)){
                        System.out.println(JsonError.projectAlreadyExists());
                    }else{
                        ProjectResults results = CommandRunner.executeProject(project);
                        HttpRequest httpRequest1 = makeRunPOSTRequest(project_id, JsonParser.parseProject(results),server);
                        HttpResponse<String> httpResponse1 = client.send(httpRequest1, HttpResponse.BodyHandlers.ofString());
                    }

                }else{
                    System.out.println(JsonError.configFileNotValid());
                }

            }
        } catch (FileNotFoundException e) {
            System.out.println(JsonError.configFileNotFound());
        } catch (ParameterException parameterException) {
            System.out.println(JsonError.serverAddressNotProvided());
        } catch (ClassCastException e) {
            System.out.println(JsonError.fileFormatProblem());
        } catch (IOException | InterruptedException e){
            System.out.println(JsonError.urlProblem());
        }

    }
}

