import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CustomFile {

    private List<Map<String,String>> fileData =  new ArrayList<>();

    public List<Map<String,String>> getFileData(){
        return this.fileData;
    }

    public void addMap(Map<String,String> datamap){
        fileData.add(datamap);
    }
   
}
