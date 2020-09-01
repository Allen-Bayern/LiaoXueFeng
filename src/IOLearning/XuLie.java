package IOLearning;
import java.io.*;
import java.util.Arrays;

public class XuLie {
    // 源地址：https://www.liaoxuefeng.com/wiki/1252599548343744/1298366845681698
    public static void main(String[] args) throws IOException{
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        try (ObjectOutputStream output = new ObjectOutputStream(buffer)){ // 把Java对象变成一个数组
            // 需要用到ObjectOutputStream
            // 写入int:
            output.writeInt(12345);
            // 写入String
            output.writeUTF("Hello world");
            // 写入对象
            output.writeObject(Double.valueOf(123.567));
        }
        System.out.println(Arrays.toString(buffer.toByteArray()));
    }
}
