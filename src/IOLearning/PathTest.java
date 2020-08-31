package IOLearning;
import java.io.*;
import java.nio.file.*;

public class PathTest {
    public static void main(String[]args) throws IOException{
        Path p1 = Paths.get("..", "DateAndTime");
        System.out.println(p1);
        Path p2 = p1.toAbsolutePath();
        System.out.println(p2);
        Path p3 = p1.normalize();
        System.out.println(p3);
    }
}
