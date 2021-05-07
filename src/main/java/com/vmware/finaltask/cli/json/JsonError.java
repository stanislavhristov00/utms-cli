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

    public static JSONObject runidIsNotValid(){
        JSONObject error = new JSONObject();
        error.put("error", "Run Id is not valid.");
        return error;
    }
}
