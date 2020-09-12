package MultiThr;
import java.util.concurrent.locks.*;
import java.util.*;

public class CounterRW {
    private final ReadWriteLock rwLock = new ReentrantReadWriteLock();
    private final Lock rLock = rwLock.readLock();
    private final Lock wLock = rwLock.writeLock();
    private int[] counts = new int[10];

    // 把读写操作分别用读锁和写锁来加锁，在读取时，多个线程可以同时获得读锁，这样就大大提高了并发读的执行效率。
    public void inc(int index){
        wLock.lock(); // 写锁
        try{
            counts[index] += 1;
        }finally{
            wLock.unlock();
        }
    }

    public int[] get(){
        rLock.lock(); // 读锁
        try{
            return Arrays.copyOf(counts, counts.length);
        }finally{ rLock.unlock(); }
    }
}
