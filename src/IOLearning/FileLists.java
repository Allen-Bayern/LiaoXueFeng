package IOLearning;
import java.io.*;

public class FileLists {
    public static void main(String[] args) throws IOException {
        File f = new File("C:\\Windows");
        File[] fs1 = f.listFiles(); // 列出所有文件和子目录
        printFiles(fs1);
        File[] fs2 = f.listFiles(new FilenameFilter() { // 仅列出.exe文件
            public boolean accept(File dir, String name) {
                return name.endsWith(".exe"); // 返回true表示接受该文件
            }
        });
        printFiles(fs2);
    }

    static void printFiles(File[] f){
        System.out.println("==========");
        if (f != null){
            for (File file : f){
                System.out.println(file);
            }
        }
        System.out.println("==========");
    }
}
