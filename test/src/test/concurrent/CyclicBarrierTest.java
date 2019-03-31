package test.concurrent;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {
	//可以重用的，用完后，还可以做继续这样的操作
	public static void main(String[] args) {
			int n=5;
			final CyclicBarrier barrier =new CyclicBarrier(n, new Runnable() {
				@Override
				public void run() {
					System.out.println("准备开始了!");
				}
			});
			System.out.println("记下线程!");
			for (int i = 0; i < n; i++) {
				Thread thread = new  Thread() {
					public void run() {
						try {
							Thread.sleep(1000L);
							System.out.println(Thread.currentThread().getName()+"：开始跑了!");
							barrier.await();
						} catch (Exception e) {
							e.printStackTrace();
						}
						System.out.println(Thread.currentThread().getName()+"：后期完事了!");
					}
				};
				thread.start();
			}
			
	}
}
