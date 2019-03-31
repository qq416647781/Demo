package test.concurrent;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {
	//�������õģ�����󣬻����������������Ĳ���
	public static void main(String[] args) {
			int n=5;
			final CyclicBarrier barrier =new CyclicBarrier(n, new Runnable() {
				@Override
				public void run() {
					System.out.println("׼����ʼ��!");
				}
			});
			System.out.println("�����߳�!");
			for (int i = 0; i < n; i++) {
				Thread thread = new  Thread() {
					public void run() {
						try {
							Thread.sleep(1000L);
							System.out.println(Thread.currentThread().getName()+"����ʼ����!");
							barrier.await();
						} catch (Exception e) {
							e.printStackTrace();
						}
						System.out.println(Thread.currentThread().getName()+"������������!");
					}
				};
				thread.start();
			}
			
	}
}
