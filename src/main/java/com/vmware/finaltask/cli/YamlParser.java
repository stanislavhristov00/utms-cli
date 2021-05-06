package com.vmware.finaltask.cli;

import com.vmware.finaltask.cli.interfaces.Parser;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Map;

public class YamlParser implements Parser {
    private Yaml yaml;
    private String filePath;

    public YamlParser(String filePath){
        this.yaml = new Yaml();
        this.filePath = filePath;
    }
    @Override
    public Map<String, Object> parse(){
        InputStream inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream(this.filePath);
        return this.yaml.load(inputStream);
    }
}
