package test.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NewFixedThreadPoolTest {
	public static void main(String[] args) {
		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(2);
		newFixedThreadPool.execute(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("�Ҿ�ִ��һ�ε�,���һ�����!");
			}
		});
	}
}
