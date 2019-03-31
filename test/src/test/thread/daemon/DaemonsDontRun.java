package test.thread.daemon;

import java.util.concurrent.TimeUnit;

public class DaemonsDontRun {
	/**

     * @param args

     */

    public static void main(String[] args) {

        Thread t = new Thread(new ADaemon());
        t.setDaemon(true);//ע�ͺ�Ͳ����ػ��߳��ˣ���ȫ��ִ����Ž���
        t.start();

    }
}

 

class ADaemon implements Runnable {
    public void run() {

        try {
            System.out.println("start ADaemon...");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("-----");
        } catch (InterruptedException e) {
            System.out.println("Exiting via InterruptedException");
        } finally {
            System.out.println("This shoud be always run ?");

        }

    }
}
