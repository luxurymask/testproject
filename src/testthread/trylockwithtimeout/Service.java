package testthread.trylockwithtimeout;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Service {
	public ReentrantLock lock = new ReentrantLock();
	
	public void waitMethod(){
		try{
			System.out.println(Thread.currentThread().getName() + " start at: " + System.currentTimeMillis());
			if(lock.tryLock(3, TimeUnit.SECONDS)){
				System.out.println(Thread.currentThread().getName() + "获得锁的时间：" + System.currentTimeMillis());
				Thread.sleep(2100);
			}else{
				System.out.println(Thread.currentThread().getName() + "没有获得锁：" + System.currentTimeMillis());
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		}finally{
			if(lock.isHeldByCurrentThread()){
				lock.unlock();
			}
		}
	}
}
