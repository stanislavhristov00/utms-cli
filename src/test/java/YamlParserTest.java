import com.vmware.finaltask.cli.YamlParser;
import org.junit.Assert;
import org.junit.Test;
import java.io.FileNotFoundException;

public class YamlParserTest {


    @Test
    public void testWithValidFile(){
        String filePath = "D:\\Games\\testing2.yaml";
        YamlParser yamlParser = new YamlParser(filePath);
        try {
            Assert.assertNotNull(yamlParser.parse());
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    @Test
    public void testWithNonExistantFile(){
        String filePath = "D:\\Games\\testing3.yaml";
        YamlParser yamlParser = new YamlParser(filePath);
        Assert.assertThrows(FileNotFoundException.class, () -> {yamlParser.parse();});
    }

    @Test
    public void testWithNonValidPath(){
        String filePath = "D:gameszxc";
        YamlParser yamlParser = new YamlParser(filePath);
        Assert.assertThrows(FileNotFoundException.class, () -> {yamlParser.parse();});
    }

    @Test
    public void testWithNonYamlFile(){
        String filePath = "D:\\not_a_yaml_file.txt";
        YamlParser yamlParser = new YamlParser(filePath);
        Assert.assertThrows(ClassCastException.class, () -> {yamlParser.parse();});
    }
}
