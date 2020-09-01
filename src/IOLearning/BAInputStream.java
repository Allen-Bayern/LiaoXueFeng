package IOLearning;
import java.io.*;

public class BAInputStream {
    public static void main(String[] args) throws IOException{
        byte[] data = {72, 101, 108, 108, 111, 33};
        String s = "";
        try (InputStream input = new ByteArrayInputStream(data)){
            int n = 0;
            StringBuilder sb = new StringBuilder();
            while ((n = input.read()) != -1){
                sb.append((char) n);
            }
            s = sb.toString();
        }
        System.out.println(s);
    }

    public static String readAsString (InputStream input) throws IOException{
        int n = 0;
        StringBuilder sb = new StringBuilder();
        while ((n = input.read()) != -1) { sb.append((char) n); }

        return sb.toString();
    }
}