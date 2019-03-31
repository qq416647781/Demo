package test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import test.thread.daemon.ThreadSync;

public class CacheThreadPool {
	public static void main(String[] args) {
		ExecutorService cacheThreadPool = Executors.newCachedThreadPool();
		Thread thread1=new Thread(new ThreadSync());
		Thread thread2=new Thread(new ThreadSync());
		cacheThreadPool.execute(thread1);
		cacheThreadPool.execute(thread2);
	}
}
