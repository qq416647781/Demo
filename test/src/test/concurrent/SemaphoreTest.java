package test.concurrent;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {
	public static void main(String[] args) {
	  final	Semaphore semaphore=new Semaphore(2);//�ź������ñ����й�̨
		
		for (int i = 0; i < 10; i++) {
			Thread thread = new  Thread() {
				public void run() {
					try {
						semaphore.acquire();
						System.out.println(Thread.currentThread().getName()+"��ռ����!");
						Thread.sleep(1000L);
						System.out.println(Thread.currentThread().getName()+"���ͷ���!");
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
