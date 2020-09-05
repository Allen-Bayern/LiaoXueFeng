package MultiThr;
// https://www.liaoxuefeng.com/wiki/1252599548343744/1306580767211554

public class InterruptTest2 {
    public static void main(String[] args) throws InterruptedException{
        Thread t = new MyThread();
        t.start();
        Thread.sleep(10000);
        t.interrupt(); // 中断t线程
        t.join(); // 等待t线程结束
        System.out.println("end");
    }

static class MyThread extends Thread{
    public void run(){
        Thread hello = new HelloThread();
        hello.start();
        try{
            hello.join();
        } catch (InterruptedException e){
            System.out.println("interrupted!");
        }
        hello.interrupt();
    }
}

static class HelloThread extends Thread{
    @Override
    public void run(){
        int n = 0;
        while (isInterrupted()){
            n++;
            System.out.println(n + " Hello");
            try{
                Thread.sleep(100);
            }catch (InterruptedException e){ break; }
        }
    }
}
}
