package com.vmware.finaltask.cli;

import com.vmware.finaltask.cli.interfaces.Parser;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;

public class YamlParser implements Parser {
    private Yaml yaml;
    private String filePath;

    public YamlParser(String filePath){
        this.yaml = new Yaml();
        this.filePath = filePath;
    }
    @Override
    public LinkedHashMap<String, Object> parse() throws FileNotFoundException, ClassCastException{
        FileInputStream inputStream = new FileInputStream(this.filePath);
        return this.yaml.load(inputStream);
    }
}
