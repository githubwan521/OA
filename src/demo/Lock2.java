public class Lock2 implements Runnable {
    private int flag = 1;
    private static final Object o1 = new Object();
    private static final Object o2 = new Object();

    @Override
    public void run() {
        System.out.println("flag=" + flag);
        if (flag == 1) {
            synchronized (o1) {
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized (o2) {
                    System.out.println("1");
                }
            }
        }
        if (flag == 0) {
            synchronized (o2) {
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized (o1) {
                    System.out.println("0");
                }
            }
        }
    }

    public static void main(String[] args) {

        Lock2 td1 = new Lock2();
        Lock2 td2 = new Lock2();
        td1.flag = 1;
        td2.flag = 0;

        new Thread(td1).start();
        new Thread(td2).start();

    }
}
