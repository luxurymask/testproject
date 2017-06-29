package testthread.awaituninterruptibly;

public class MyThread extends Thread{
	private Service service;
	public MyThread(Service service){
		super();
		this.service = service;
	}
	
	public void run(){
		service.testMethod();
	}
}
