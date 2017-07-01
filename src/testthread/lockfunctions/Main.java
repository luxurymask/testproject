package testthread.lockfunctions;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
	private static ReentrantLock lock = new ReentrantLock();
	private static Condition condition = lock.newCondition();
	
	public static void main(String[] args){
		//lock.getHoldCount()
		//不需要先持有锁。
		System.out.println(lock.getHoldCount());
		
		//lock.getQueueLength()
		//不需要先持有锁。
		System.out.println(lock.getQueueLength());
		
		//lock.getWaitQueueLength(Condition condition)
		//需要先持有锁。
		lock.lock();
		System.out.println(lock.getWaitQueueLength(condition));
		lock.unlock();
		
		//lock.hasQueuedThread(Thread thread)
		//不需要先持有锁。
		System.out.println(lock.hasQueuedThread(Thread.currentThread()));
		
		//lock.hasQueuedThreads()
		//不需要先持有锁。
		System.out.println(lock.hasQueuedThreads());
		
		//lock.hasWaiters(Condition condition)
		//需要先持有锁。
		lock.lock();
		System.out.println(lock.hasWaiters(condition));
		lock.unlock();
		
		//lock.isFair()
		//不需要先持有锁。
		System.out.println(lock.isFair());
		
		//lock.isHeldByCurrentThread()
		//显然不需要先持有锁。
		System.out.println(lock.isHeldByCurrentThread());
		
		//lock.isLocked()
		//不需要先持有锁。
		System.out.println(lock.isLocked());
		
		//lock.lockInterruptibly()
		//不需要先持有锁。
		try {
			lock.lockInterruptibly();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally{
			if(lock.isHeldByCurrentThread()){
				lock.unlock();
			}
		}
		
		//lock.tryLock()
		//不需要先持有锁。
		System.out.println(lock.tryLock());
		if(lock.isHeldByCurrentThread()){
			lock.unlock();
		}
		
		//lock.tryLock(long timeout, TimeUnit unit)
		//不需要先持有锁。
		try {
			System.out.println(lock.tryLock(1, TimeUnit.SECONDS));
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally{
			if(lock.isHeldByCurrentThread()){
				lock.unlock();
			}
		}
		
		//condition.awaitUninterruptibly()
		//需要先持有锁。
		lock.lock();
		condition.awaitUninterruptibly();
		lock.unlock();
		
		//condition.awaitUntil(Date date)
		//需要先持有锁。
		//下面代码是不对的，只不过在单线程中，上面的condition在本线程中await着，lock也没释放。
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.SECOND, 1);
		try {
			condition.awaitUntil(calendar.getTime());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally{
			if(lock.isHeldByCurrentThread()){
				System.out.println(1);
				lock.unlock();
			}
		}
	}
}
