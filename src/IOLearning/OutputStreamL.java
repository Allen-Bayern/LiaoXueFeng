package IOLearning;
import java.io.*;

public class OutputStreamL {
    public static void main(String[] args) throws IOException{
        String file = "t1.txt";
        writeFile(file);

    }
    public static void writeFile(String file) throws IOException{
        File f = new File(file);
        if (f.isFile() == false){ f.createNewFile(); }
        try (OutputStream output = new FileOutputStream(file)) {
            output.write("Hello".getBytes());
        }
        f.delete();
    }
}
