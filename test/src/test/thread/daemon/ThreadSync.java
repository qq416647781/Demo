package test.thread.daemon;

import java.util.concurrent.TimeUnit;

public class ThreadSync implements Runnable{
	private static int i=1000;
	private static Object lockObj=new Object();
	
	@Override
	public  void  run(){
		synchronized(ThreadSync.class){
			while(true){
				System.out.println("¿ªÊ¼!");
				if(i>0){
					try {
						TimeUnit.MILLISECONDS.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("i:"+(--i));
				}else{
					break;
				}
				System.out.println("½áÊø!");
			}
		}
	}
}
