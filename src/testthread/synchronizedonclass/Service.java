package testthread.synchronizedonclass;

public class Service {
	synchronized public static void printA(){
		try{
			System.out.println(Thread.currentThread().getName() + ":" + System.currentTimeMillis() + " went into printA().");
			Thread.sleep(3000);
			System.out.println(Thread.currentThread().getName() + ":" + System.currentTimeMillis() + " got out of printA().");
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
	synchronized public static void printB(){
		System.out.println(Thread.currentThread().getName() + ":" + System.currentTimeMillis() + " went into printB().");
		System.out.println(Thread.currentThread().getName() + ":" + System.currentTimeMillis() + " got out of printB().");
	}
	
	synchronized public void printC(){
		System.out.println(Thread.currentThread().getName() + ":" + System.currentTimeMillis() + " went into printC().");
		System.out.println(Thread.currentThread().getName() + ":" + System.currentTimeMillis() + " got out of printC().");
	}
}
