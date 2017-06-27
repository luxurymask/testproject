package testthread.synchronizedonclass;

public class ThreadD extends Thread{
	private ServiceB service;
	public ThreadD(ServiceB service){
		super();
		this.service = service;
	}
	
	@Override
	public void run(){
		service.printD();
	}
}
