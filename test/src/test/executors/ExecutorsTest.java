package test.executors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorsTest {
	public static void main(String[] args) throws Exception {
		long start=System.currentTimeMillis();
		List<String> list=new ArrayList<String>();
		for (int i = 0; i < 3000; i++) {
			list.add(i+"");
		}
		int threadSize=500;
		int dataSize=list.size();
		
		int threadNum=dataSize/threadSize+1;
		
		boolean special=dataSize%threadSize==0;
		
		ExecutorService exec=Executors.newFixedThreadPool(threadNum);
		
		List<Callable<Integer>> tasks=new ArrayList<Callable<Integer>>();
		Callable<Integer> task=null;
		List<String> cutList=null;
		for (int i = 0; i < args.length; i++) {
			if(i==threadNum-1){
				if(special){
					break;
				}
				cutList=list.subList(threadSize * i, dataSize);
			}else{
				cutList=list.subList(threadSize * i, threadSize * (i + 1));
			}
			
			final List<String> listStr=cutList;
			
			task=new Callable<Integer>() {
				@Override
				public Integer call() throws Exception {
					 System.out.println(Thread.currentThread().getName() + "线程：" + listStr);
	                  return 1;
				}
			};
			
			tasks.add(task);
		}
		
		List<Future<Integer>> results=exec.invokeAll(tasks);
		for (Future<Integer> future : results) {
			System.out.println(future.get());
		}
		exec.shutdown();
		System.out.println("线程消耗："+(System.currentTimeMillis() - start)+"毫秒");
	}
}
