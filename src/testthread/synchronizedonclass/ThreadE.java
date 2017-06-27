package testthread.synchronizedonclass;

public class ThreadE extends Thread{
	private ServiceB service;
	public ThreadE(ServiceB service){
		super();
		this.service = service;
	}
	
	@Override
	public void run(){
		service.printE();
	}
}
