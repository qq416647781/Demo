package test.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NewCachedThreadPoolTest {
	public static void main(String[] args) {
		   ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
		   newCachedThreadPool.execute(new Runnable() {
			@Override
			public void run() {
				System.out.println("�Ҿ�ִ��һ�ε�,���һ�������!");
			}
		});
	}
}
