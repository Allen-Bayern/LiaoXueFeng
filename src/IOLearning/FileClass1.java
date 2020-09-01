package IOLearning;
        import java.io.*; // 涉及IO时引进这一条

public class FileClass1 {
    public static void main(String[] args) throws IOException{
        File file = new File("E:\\ForGraduation\\LiaoXueFeng\\src\\IOLearning\\README.md");
        System.out.println(file);
        System.out.println();
        System.out.println(file.getPath());
        System.out.println(file.getAbsolutePath());
        //System.out.println(file.getCanonicalPath()); 这行先用不上

        System.out.println();
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());
        System.out.println(file.canRead());
        System.out.println(file.canWrite());
        System.out.println(file.canExecute());
        System.out.println(file.length());

        File f2 = File.createTempFile("tmp", ".txt");
        f2.deleteOnExit();
        System.out.println(f2.isFile());
        System.out.println(f2.isFile());

        File f3 = new File("E:\\ForGraduation\\LiaoXueFeng\\src\\IOLearning\\README.txt");
        System.out.println(f3.isFile());
        if (f3.createNewFile()){
            System.out.println(f3.isFile());
            f3.delete();
        }
    }
}