package testthread.waitinterrupt;

public class Service {
	public void testMethod(Object lock){
		try{
			synchronized(lock){
				for(int i = 0;i < 1000;i++){
					System.out.println("i = " + i);
				}
				System.out.println("run begin...");
				//此处如果调用Thread.interrupted()就会清除线程的interrupt状态，再执行下面的wait()时就不会抛出异常。
				//System.out.println(Thread.interrupted());
				lock.wait();
				System.out.println("run end.");
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}
