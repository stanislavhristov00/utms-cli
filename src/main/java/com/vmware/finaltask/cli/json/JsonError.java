package com.vmware.finaltask.cli.json;

import org.json.simple.JSONObject;

public class JsonError {
    private JsonError() {}

    public static JSONObject configFileNotFound(){
        JSONObject error = new JSONObject();
        error.put("error", "Configuration file not found.");
        return error;
    }

    public static JSONObject configFileNotValid(){
        JSONObject error = new JSONObject();
        error.put("error", "Configuration file is not valid.");
        return error;
    }

    public static JSONObject serverAddressNotProvided(){
        JSONObject error = new JSONObject();
        error.put("error", "Server address not specified.");
        return error;
    }

    public static JSONObject projectAlreadyExists(){
        JSONObject error = new JSONObject();
        error.put("error", "Project with this name already exists");
        return error;
    }

    public static JSONObject urlProblem(){
        JSONObject error = new JSONObject();
        error.put("error", "Something wrong with the address");
        return error;
    }

    public static JSONObject fileFormatProblem(){
        JSONObject error = new JSONObject();
        error.put("error", "Config file format should be .yaml or .yml");
        return error;
    }


}
