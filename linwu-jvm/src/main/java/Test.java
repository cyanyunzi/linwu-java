import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Test {
    public static void main(String[] args) throws Exception {
        Path root = new File("/Users/zhanglei/soft/nacos").toPath().normalize();

        Path usedProperties = Paths.get(root.resolve("conf/application.properties").toString());
        Path copyProperties = Paths.get(root.resolve("conf/application.properties.copy").toString());

        Files.delete(usedProperties);
        Files.copy(copyProperties, usedProperties);

        List<String> lines = Files.readAllLines(usedProperties);
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);


        }
    }
}
