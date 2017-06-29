package testthread.conditionsequence;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
	private static ReentrantLock lock = new ReentrantLock();
	private static Condition conditionA = lock.newCondition();
	private static Condition conditionB = lock.newCondition();
	private static Condition conditionC = lock.newCondition();

	public static void main(String[] args) throws InterruptedException {
		Runnable runnableA = new Runnable() {
			public void run() {
				try {
					lock.lock();
					conditionA.await();
					for (int i = 0; i < 3; i++) {
						System.out.println("A " + i);
					}
					conditionB.signal();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					lock.unlock();
				}
			}
		};

		Runnable runnableB = new Runnable() {
			public void run() {
				try {
					lock.lock();
					conditionB.await();
					for (int i = 0; i < 3; i++) {
						System.out.println("B " + i);
					}
					conditionC.signal();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					lock.unlock();
				}
			}
		};

		Runnable runnableC = new Runnable() {
			public void run() {
				try {
					lock.lock();
					conditionC.await();
					for (int i = 0; i < 3; i++) {
						System.out.println("C " + i);
					}
					conditionA.signal();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					lock.unlock();
				}
			}
		};

		Thread[] arrayA = new Thread[5];
		Thread[] arrayB = new Thread[5];
		Thread[] arrayC = new Thread[5];

		for (int i = 0; i < 5; i++) {
			arrayA[i] = new Thread(runnableA);
			arrayB[i] = new Thread(runnableB);
			arrayC[i] = new Thread(runnableC);
			arrayA[i].start();
			arrayB[i].start();
			arrayC[i].start();
		}

		lock.lock();
		conditionA.signal();
		lock.unlock();
	}
}
