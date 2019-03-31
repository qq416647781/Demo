package test.executors;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleThreadPoolTest {
	public static void main(String[] args) {
			ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(1);
			
			scheduledThreadPool.schedule(new Runnable() {
				@Override
				public void run() {
					System.out.println("我就执行一次的,但我还存在!");
				}
			},1,TimeUnit.SECONDS);
			
			
	}
}
