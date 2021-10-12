import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        List<CustomFile> customFiles = new ArrayList<>();
        System.out.println("Enter file size: ");
        int filesize = sc.nextInt();
        sc.nextLine();

        for(int i =1;i<=filesize;i++){
            System.out.println("Please enter a file: ");
            String path  = sc.nextLine();
            customFiles.add(FileHandler.handleFile(path.strip()));
        }

        sc.close();
        Manager manager = new Manager();
        Results results = manager.handle(customFiles);
        results.printResults();
    }
}
