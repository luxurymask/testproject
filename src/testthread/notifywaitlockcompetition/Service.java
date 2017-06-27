package testthread.notifywaitlockcompetition;

public class Service {
	public void testMethod(Object lock){
		try{
			synchronized(lock){
				System.out.println("begin wait()...");
				lock.wait();
				System.out.println("end wait().");
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
	public void notifyMethod(Object lock){
		try{
			synchronized(lock){
				System.out.println("begin notify():" + Thread.currentThread().getName());
				lock.notify();
				Thread.sleep(1000);
				System.out.println("end notify():" + Thread.currentThread().getName());
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}
