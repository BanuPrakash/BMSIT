import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Third {
    public static void main(String[] args) {
        System.out.println("Main starts!!!");
        try {
            doTask();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    // throws: I will delegate this exception to caller method
    // caller method has to handle
    private static void doTask() throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("a.txt");
        System.out.println("Do something with file!!!");
    }
}
