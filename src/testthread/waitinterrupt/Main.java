package testthread.waitinterrupt;

public class Main {
	public static void main(String[] args){
		Object lock = new Object();
		MyThread a = new MyThread(lock);
		a.start();
		a.interrupt();
		System.out.println("end.");
	}
}
