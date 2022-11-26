import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

public class MapLoading {

    private static Map<String,String> map = new HashMap<>();
    private static String mappingData;
    private static String[] singlelineData;
    private static void loadHashMap() throws IOException{
        File file = new File("D:\\Sample\\mappingDetails.txt");
        mappingData = Files.readString(file.toPath());
        singlelineData = mappingData.split(System.getProperty("line.separator"));
        for (String lineData : singlelineData) {
            String key = lineData.split(":")[0];
            String value = lineData.split(":")[1];
            map.put(key, value);
        }
    }
    public static void main(String[] args) throws IOException {
        loadHashMap();
        System.out.println(map.entrySet());
    }
}
