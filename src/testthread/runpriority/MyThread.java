package testthread.runpriority;

public class MyThread extends Thread{
	public MyThread(){
		super();
	}
	
	public MyThread(Runnable thread){
		super(thread);
	}

	@Override
	public void run() {
		System.out.println("MyThread run priority=" + this.getPriority());
	}
	
	
}
