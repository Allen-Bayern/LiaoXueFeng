package MultiThr;
import java.util.*;
import java.util.concurrent.locks.*;

public class TaskQueue {
    private Queue<String> queue = new LinkedList<>();
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    public void addTask(String s){
        lock.lock();
        try{
            queue.add(s);
            condition.signalAll();
        }finally{
            lock.unlock();
        }
    }


    /**public synchronized void addTask(String s){
        this.queue.add(s);
        this.notifyAll();
    }*/

    /**public synchronized String getTask() throws InterruptedException { // 抛出异常必须
        while (queue.isEmpty()){ // 只能在while循环中使用wait方法
            // 释放this锁
            this.wait();
            // 获取this锁
        }
        return queue.remove();
    }*/

    public String getTask(){
        lock.lock();
        try{
            while(queue.isEmpty()){
                condition.await();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally{
            lock.unlock();
        }
        return queue.remove();
    }
}