package testthread.runpriority;

public class Run {
	public static void main(String[] args){
		System.out.println("main thread begin priority=" + Thread.currentThread().getPriority());
		MyThread thread = new MyThread();
		System.out.println("---" + thread.getPriority());
		Thread.currentThread().setPriority(6);
		System.out.println("main thread end priority=" + Thread.currentThread().getPriority());
		MyThread thread2 = new MyThread(thread);
		thread2.start();
		System.out.println("thread main priority=" + thread.getPriority());
		System.out.println("thread2 main priority=" + thread2.getPriority());
	}
}
