package test.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchTest {
	//���������õ�
	public static void main(String[] args) throws InterruptedException {
		int threadNum=20;
		final CountDownLatch latch=new CountDownLatch(threadNum);
		ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
		for (int i = 0; i < threadNum; i++) {
			Runnable runnable = new Runnable() {
				public void run() {
						try {
							Thread.sleep(1000L);
							System.out.println(Thread.currentThread().getName()+":ִ����!");
						} catch (Exception e) {
							e.printStackTrace();
						}finally{
							latch.countDown();
						}
				}
			};
			cachedThreadPool.submit(runnable);
		}
		latch.await();//�����ȴ���
		System.out.println("ִ������!");
		cachedThreadPool.shutdown();//���̳߳�ֹͣ����
	}
}
