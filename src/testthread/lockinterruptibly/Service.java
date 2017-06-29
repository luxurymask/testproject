package testthread.lockinterruptibly;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Service {
	public ReentrantLock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();

	public void waitMethod() {
		try {
			System.out.println(Thread.currentThread().getName() + " start...");
			lock.lockInterruptibly();
			System.out.println("lock begin -" + Thread.currentThread().getName());
			for(int i = 0;i < Integer.MAX_VALUE/10;i++){
				String s = i + "dkdkdk";
			}
			System.out.println("lock end -" + Thread.currentThread().getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			if (lock.isHeldByCurrentThread()) {
				lock.unlock();
			}
		}
	}
}
