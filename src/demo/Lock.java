
public class Lock {
    public static void main(String[] args) {
        Thread thread1 = new MyThread(Boolean.TRUE);
        Thread thread2 = new MyThread(Boolean.FALSE);
        thread1.start();
        thread2.start();
    }
}

class MyThread extends Thread implements Runnable {
    private static final Object o1 = new Object();
    private static final Object o2 = new Object();
    private boolean flag;

    MyThread(Boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        if (flag) {
            synchronized (o1) {
                System.out.println(flag);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2) {
                    System.out.println(flag);

                }
            }
        } else {
            synchronized (o2) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o1) {
                    System.out.println(flag);
                }
            }
        }
    }
}
