package testthread.notifywaitlockcompetition;

public class NotifyThreadB extends Thread{
	private Object lock;
	
	public NotifyThreadB(Object lock){
		super();
		this.lock = lock;
	}
	
	public void run(){
		Service service = new Service();
		service.notifyMethod(lock);
	}
}
