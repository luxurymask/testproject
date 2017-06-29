package testthread.lockinterruptibly;

public class Main {
	public static void main(String[] args) throws InterruptedException{
		Service service = new Service();
		Runnable runnable = new Runnable(){
			public void run(){
				service.waitMethod();
			}
		};
		
		Thread threadA = new Thread(runnable);
		threadA.setName("A");
		threadA.start();
		Thread.sleep(500);
		Thread threadB = new Thread(runnable);
		threadB.setName("B");
		threadB.start();
		Thread.sleep(2000);
		System.out.println(threadB.isInterrupted());
		threadB.interrupt();
		System.out.println(threadB.isInterrupted());
		System.out.println("main end.");
	}
}
