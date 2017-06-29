package testthread.lockconditionsignal;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Service {
	private ReentrantLock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	
	public void waitMethod(){
		try{
			lock.lock();
			System.out.println("await start...");
			condition.await();
			System.out.println("await end.");
		}catch(InterruptedException e){
			e.printStackTrace();
		}finally{
			lock.unlock();
			System.out.println(Thread.currentThread().getName() + "lock released.");
		}
	}
	
	public void notifyMethod(){
		try{
			lock.lock();
			System.out.println("有" + lock.getWaitQueueLength(condition) + "个线程正在等待condition");
			condition.signal();
			System.out.println("有" + lock.getWaitQueueLength(condition) + "个线程正在等待condition");
			condition.signalAll();
			System.out.println("有" + lock.getWaitQueueLength(condition) + "个线程正在等待condition");
			condition.signal();
			System.out.println("没有锁在等待，signal()执行被忽略。");
		}finally{
			lock.unlock();
			System.out.println(Thread.currentThread().getName() + "lock released.");
		}
	}
}
