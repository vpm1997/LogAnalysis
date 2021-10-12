import java.util.List;

public class Manager {

    public Results handle(List<CustomFile> files){
        Results results = new SynchornizedResults();
        for(CustomFile file : files){
            ExecutorPool.getFixSizeExecutor().execute(new Worker(results, file));
        }
        ExecutorPool.shutDownExecutor();
        return results;
    }
    
}
