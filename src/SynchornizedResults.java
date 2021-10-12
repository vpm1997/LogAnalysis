import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SynchornizedResults implements Results {

    private Map<String, Map<String, Integer>> result;

    public SynchornizedResults() {
        this.result = new ConcurrentHashMap<>();
    }

    @Override
    public void pushResult(String error, String datetime) {
        synchronized (result) {
            if (result.containsKey(error)) {
                Map<String, Integer> datetimedata = result.get(error);
                if (datetimedata.containsKey(datetime)) {
                    datetimedata.put(datetime, datetimedata.get(datetime) + 1);
                } else {
                    datetimedata.put(datetime, 1);
                }
            } else {
                Map<String, Integer> datetimedata = new ConcurrentHashMap<>();
                datetimedata.put(datetime, 1);
                result.put(error, datetimedata);
            }
        }
    }

    @Override
    public Map<String, Map<String, Integer>> getResult() {
        return this.result;
    }

    @Override
    public void printResults() {
        for (Map.Entry<String, Map<String, Integer>> entry : getResult().entrySet()) {
            for (Map.Entry<String, Integer> nextEntry : entry.getValue().entrySet()) {
                System.out.println(entry.getKey() + " " + nextEntry.getKey() + " " + nextEntry.getValue());
            }
        }

    }
}
