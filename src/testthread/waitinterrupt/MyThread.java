package testthread.waitinterrupt;

public class MyThread extends Thread{
	private Object lock;
	
	public MyThread(Object lock){
		super();
		this.lock = lock;
	}
	
	public void run(){
		Service service = new Service();
		service.testMethod(lock);
	}
}
