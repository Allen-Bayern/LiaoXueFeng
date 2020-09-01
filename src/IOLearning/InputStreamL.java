package IOLearning;
import java.io.*;

public class InputStreamL {
    public static void main(String[] args) throws IOException {
        String f = "README.md";
        readFile(f);
    }

    public static void readFile(String file) throws IOException{
        InputStream is = null;
        try {
            is = new FileInputStream(file);
            int n = 0;
            while ((n = is.read()) != -1){
                System.out.println(n);
            }
        } finally{ if (is != null) { is.close(); } }
    }

    /** 上述代码可以用Java 7引入的try (resource)方法写：
     public void readFile() throws IOException {
         try (InputStream input = new FileInputStream("src/readme.txt")) {
         int n;
         while ((n = input.read()) != -1) {
         System.out.println(n);
     }
     } // 编译器在此自动为我们写入finally并调用close()
     }
     * */
}
