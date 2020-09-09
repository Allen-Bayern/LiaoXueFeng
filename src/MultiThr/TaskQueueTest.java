package MultiThr;
import java.util.*;

public class TaskQueueTest {
    public static void main(String[] args) throws InterruptedException {
        TaskQueue q = new TaskQueue();
        List<Thread> ts = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            Thread t = new Thread(){
                public void run(){
                    // 执行task：
                    while (true){
                        String s = q.getTask();
                        System.out.println("execute task: " + s);
                    }
                }
            };
            t.start();
            ts.add(t);
        }

        Thread add = new Thread(() -> {
            for (int i = 0; i < 10; ++i) {
                // 放入task
                String s = "t-" + Math.random();
                System.out.println("add task" + s);
                q.addTask(s);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
            }});
        add.start();
        add.join();
        Thread.sleep(100);
        for(Thread t : ts){
            t.interrupt();
        }
    }


}
