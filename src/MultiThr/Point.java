package MultiThr;
import java.util.*;
import java.util.concurrent.locks.*;

public class Point {
    public final StampedLock stampedLock = new StampedLock();

    private double x;
    private double y;

    public void move(double deltaX, double deltaY){
        long stamp = stampedLock.writeLock(); // 获取写锁
        try{
            x += deltaX;
            y += deltaY;
        }finally{
            stampedLock.unlockWrite(stamp); // 释放写锁
        }
    }

    public double distanceFromOrigin(){
        long stamp = stampedLock.tryOptimisticRead();
        double currentX = x;
        double currentY = y;

        if (!stampedLock.validate(stamp)){ // 检查是否有其他写锁发生
            stampedLock.readLock(); // 这是个悲观锁
            try{
                currentX = x;
                currentY = y;
            } finally{
                stampedLock.unlockRead(stamp);
            }
        }

        return Math.sqrt(currentX * currentX + currentY + currentY);
    }

}
