import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
public class ExecutorPool {

    private static Executor fixSizeExecutor;

    public static Executor getFixSizeExecutor(){
       if(fixSizeExecutor==null){
           setFixSizeExecutor();
       }
       return fixSizeExecutor;
    }

    public static void setFixSizeExecutor(){
        fixSizeExecutor = Executors.newFixedThreadPool(5);
    }

    public static void shutDownExecutor(){
        ((ExecutorService)fixSizeExecutor).shutdown();
        if(fixSizeExecutor!=null){
            try {
                if (!((ExecutorService)fixSizeExecutor).awaitTermination(60, TimeUnit.SECONDS)) {
                    ((ExecutorService)fixSizeExecutor).shutdownNow();
                }
            } catch (InterruptedException ex) {
                ((ExecutorService)fixSizeExecutor).shutdownNow();
                Thread.currentThread().interrupt();
            }
        }
    }

    
}
