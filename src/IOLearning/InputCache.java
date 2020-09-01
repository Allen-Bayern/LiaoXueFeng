package IOLearning;
import java.io.*;

public class InputCache {

    public static void main(String[] args) throws IOException {
        String f = "README.md";
        readFileCache(f);
    }

    public static void readFileCache(String file) throws IOException{
        try (InputStream input = new FileInputStream(file)){
            byte[] buffer = new byte[1000];
            int n = 0;
            while ((n = input.read()) != -1){ System.out.println("read" + n + "bytes."); }
        }
    }
}
