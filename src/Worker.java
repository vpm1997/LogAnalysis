import java.util.Map;

public class Worker extends Thread {

    public Results results;
    public CustomFile file;

    public Worker(Results results, CustomFile file){
        this.results = results;
        this.file = file;
    }
    
    void process(CustomFile file, Results results){
        try{
        for( Map<String,String> data : file.getFileData()){
                String time = data.get("timeStamp").strip();
                String error = data.get("text").strip();
                results.pushResult(error, DateUtil.getDateTimeQuater(time));
         }
        } catch(Exception ex){

        }
    }

    public void run(){
         process(file, results);
    }
}
