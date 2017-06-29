package testthread.trylockwithtimeout;

public class Main {
	public static void main(String[] args){
		Service service = new Service();
		Runnable runnable = new Runnable(){
			public void run(){
				service.waitMethod();
			}
		};
		
		Thread threadA = new Thread(runnable);
		threadA.setName("A");
		threadA.start();
		
		Thread threadB = new Thread(runnable);
		threadB.setName("B");
		threadB.start();
		threadB.interrupt();
	}
}
