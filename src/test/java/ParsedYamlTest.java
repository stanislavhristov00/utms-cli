import com.vmware.finaltask.cli.YamlParser;
import com.vmware.finaltask.cli.validation.ParsedYamlValidation;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;

public class ParsedYamlTest {
    @Test
    public void testWithValidYaml(){
        String pathFile = "D:\\testing.yaml";
        YamlParser yamlParser = new YamlParser(pathFile);
        try {
            Assert.assertTrue(ParsedYamlValidation.validate(yamlParser.parse()));
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    @Test
    public void testWithInvalidYaml(){
        String pathFile = "D:\\not_valid_yaml.yaml";
        YamlParser yamlParser = new YamlParser(pathFile);
        try {
            Assert.assertFalse(ParsedYamlValidation.validate(yamlParser.parse()));
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    @Test
    public void testWithNull(){
        Assert.assertFalse(ParsedYamlValidation.validate(null));
    }
}
