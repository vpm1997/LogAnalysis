import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileHandler {

    public static CustomFile handleFile(String path) {
        CustomFile customFile = new CustomFile();
        try {
            File file = new File(path);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = " ";
            String[] temparr;
            boolean headerFlag = true;
            List<String> headers = new ArrayList<>();
            
            while ((line = br.readLine()) != null) {
                if (headerFlag) {
                    temparr = line.split(" ");
                    for (String header : temparr) {
                        headers.add(header.strip());
                    }
                } else {
                    temparr = line.split(" ");
                    Map<String, String> datamap = new HashMap<>();
                    int index = 0;
                    for (String data : temparr) {
                        datamap.put(headers.get(index), data.strip());
                        index += 1;
                    }
                    customFile.addMap(datamap);
                }
                headerFlag = false;
            }
            br.close();
        } catch (IOException ex) {
            System.out.println("IoErrorOccurred");
        }
        return customFile;
    }

}
