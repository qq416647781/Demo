package test;

import test.thread.daemon.ThreadSync;

public class ThreadSyncTest {
	public static void main(String[] args) {
		Thread thread1=new Thread(new ThreadSync());
		Thread thread2=new Thread(new ThreadSync());
		thread1.start();
		thread2.start();
	}
}
