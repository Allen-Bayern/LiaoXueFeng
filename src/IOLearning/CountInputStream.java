package IOLearning;
import java.io.*;

public class CountInputStream extends FilterInputStream{
    private int count = 0;

    public CountInputStream(InputStream in){ super(in);}

    public int getBytesRead(){ return this.count; }

    public int read() throws IOException{
        int n = in.read();
        if(n != -1)
            this.count++;
        return n;
    }

    public int read(byte[]b, int off, int len) throws IOException{
        int n = in.read(b, off, len);
        this.count += n;
        return n;
    }
}
