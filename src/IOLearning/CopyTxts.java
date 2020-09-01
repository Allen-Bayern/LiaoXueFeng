package IOLearning;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class CopyTxts {
    public static void main(String[] args) throws IOException, FileNotFoundException{
        File file1 = new File("t1.txt");
        File file2 = new File("t2.txt");

        cp(file1, file2);
    }

    public static void cp(File file_raw, File file_new)throws IOException, FileNotFoundException{
        int n = 0;
        String name1 = file_raw.getName();
        String name2 = file_new.getName();

        if (file_new.isFile() == false){ file_new.createNewFile(); } // 如果没有原文件，则创建之

        try (InputStream raw = new FileInputStream(name1);
        OutputStream toFile = new FileOutputStream(name2)
        ){
            while((n = raw.read()) != -1){ toFile.write(n); }
        }

        // tests
        InputStream yw = new FileInputStream(name1);
        InputStream fz = new FileInputStream(name2);

        if (readAsStr(yw) == readAsStr(fz)){
            System.out.println(true);
        }else{
            System.out.println(false);
        }
    }

    public static String readAsStr(InputStream input) throws IOException{
        int n = 0;
        StringBuilder sb = new StringBuilder();
        while ((n = input.read()) != -1){ sb.append((char) n); }

        return sb.toString();
    }
}