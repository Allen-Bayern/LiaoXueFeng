package MultiThr;
import java.util.concurrent.locks.*;

public class Counter {
    private int count = 0;
    private final Lock lock = new ReentrantLock();

    public void add(int n){
        lock.lock();
        try{
            count += n; // 用完之后要释放锁
    }

}
