package testthread.awaituninterruptibly;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Service {
	public ReentrantLock lock = new ReentrantLock();
	public Condition condition = lock.newCondition();
	
	public void testMethod(){
		try{
			System.out.println(Thread.currentThread().getName() + " begin...");
			lock.lock();
			System.out.println("await begin...");
			condition.awaitUninterruptibly();
			System.out.println("await end.");
		}finally{
			lock.unlock();
		}
	}
}
