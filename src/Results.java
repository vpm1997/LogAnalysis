import java.util.Map;

public interface Results {

    void pushResult(String error, String datetime);

    Map<String,Map<String,Integer>>  getResult();

    void printResults();
    
}
