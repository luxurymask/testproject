package testthread.lockreleasethroughexception;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 结论：lock中抛出异常不释放锁，因此，必须要在finally块中进行lock的释放。
 * @author liuxl
 */
public class Main {
	public static void main(String[] args){
		Lock lock = new ReentrantLock();
		Thread thread = new Thread(){

			@Override
			public void run() {
				lock.lock();
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Thread" + Thread.currentThread().getName() + " is ready to make an exception.");
				int[] array = new int[3];
				array[-1] = 0;
				lock.unlock();
			}
		};
		
		thread.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lock.lock();
		System.out.println("Thread" + Thread.currentThread().getName() + " got lock, lock released because of exception.");
		lock.unlock();
	}
}
