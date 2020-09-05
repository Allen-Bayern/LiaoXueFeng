package MultiThr;

public class InterruptTest {
    public static void main(String[] args) throws InterruptedException{
        Runnable task = () -> {
            int n = 0;
            while(! Thread.currentThread().isInterrupted()){
                n++;
                System.out.println(n + " Hello World!");
            }
        };

        Thread t = new Thread(task);
        t.start();
        Thread.sleep(1);
        t.interrupt(); // 调用该方法t线程
        t.join();
        System.out.println("end");
    }
}
