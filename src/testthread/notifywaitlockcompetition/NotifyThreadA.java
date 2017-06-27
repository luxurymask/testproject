package testthread.notifywaitlockcompetition;

public class NotifyThreadA extends Thread{
	private Object lock;
	
	public NotifyThreadA(Object lock){
		super();
		this.lock = lock;
	}
	
	public void run(){
		Service service = new Service();
		service.notifyMethod(lock);
	}
}
