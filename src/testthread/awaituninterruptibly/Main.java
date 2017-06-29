package testthread.awaituninterruptibly;

public class Main {
	public static void main(String[] args){
		try{
			Service service = new Service();
			MyThread threadA = new MyThread(service);
			threadA.start();
			Thread.sleep(3000);
			threadA.interrupt();
			
			System.out.println(threadA.isInterrupted());
			service.lock.lock();
			System.out.println(threadA.isInterrupted());
			service.condition.signalAll();
			System.out.println(threadA.isInterrupted());
			service.lock.unlock();
			System.out.println(threadA.isInterrupted());
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}
