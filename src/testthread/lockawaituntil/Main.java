package testthread.lockawaituntil;

import java.util.Calendar;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
	private static ReentrantLock lock = new ReentrantLock();
	private static Condition condition = lock.newCondition();
	
	public static void main(String[] args) throws InterruptedException{
		Thread thread = new Thread(new Runnable(){
			public void run(){
				Calendar calendar = Calendar.getInstance();
				calendar.add(Calendar.SECOND, 5);
				try {
					lock.lock();
					condition.awaitUntil(calendar.getTime());
					System.out.println(Thread.currentThread().getName() + ": await over.");
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally{
					System.out.println("finally.");
					lock.unlock();
				}
			}
		});
		
		thread.start();
		Thread.sleep(1000);
		lock.lock();
		System.out.println(Thread.currentThread().getName() + " got the lock.");
		condition.signal();
		lock.unlock();
	}
}
