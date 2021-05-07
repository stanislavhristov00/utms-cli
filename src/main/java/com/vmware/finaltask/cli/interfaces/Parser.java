package com.vmware.finaltask.cli.interfaces;

import java.io.FileNotFoundException;
import java.util.Map;

public interface Parser {
    public Map<String, Object> parse() throws FileNotFoundException;
}
