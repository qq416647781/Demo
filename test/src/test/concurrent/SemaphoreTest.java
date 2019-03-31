package test.concurrent;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {
	public static void main(String[] args) {
	  final	Semaphore semaphore=new Semaphore(2);//信号量，好比银行柜台
		
		for (int i = 0; i < 10; i++) {
			Thread thread = new  Thread() {
				public void run() {
					try {
						semaphore.acquire();
						System.out.println(Thread.currentThread().getName()+"：占有了!");
						Thread.sleep(1000L);
						System.out.println(Thread.currentThread().getName()+"：释放了!");
						semaphore.release();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			};
			thread.start();
		}
	}
}
