package MultiThr;
import java.util.concurrent.*;

public class ThrPool {
    // 创建一个固定大小的线程池
    ExecutorService es = Executors.newFixedThreadPool(4);

    for (int i = 0; i <= 5; i++){
        es.submit(new Task("" + i));
    }
    // 关闭线程池
    es.shutdown(); // 使用shutdown关闭线程池的时候，线程池会等待当前任务完成
    // shutdownNow()： 立即停止当前正在执行的任务
    // awaitTermination()则会等待指定的时间让线程池关闭
}

class Task implements Runnable{
    private final String name;

    public Task(String name){
        this.name = name;
    }

    @Override
    public void run(){
        System.out.println("start task" + name);
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){}
        System.out.println("end task" + name);
    }
}