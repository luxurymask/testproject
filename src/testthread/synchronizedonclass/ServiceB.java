package testthread.synchronizedonclass;

public class ServiceB {
	synchronized public void printD(){
		try{
			System.out.println(Thread.currentThread().getName() + ":" + System.currentTimeMillis() + " went into printD().");
			Thread.sleep(3000);
			System.out.println(Thread.currentThread().getName() + ":" + System.currentTimeMillis() + " got out of printD().");
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
	synchronized public static void printE(){
		System.out.println(Thread.currentThread().getName() + ":" + System.currentTimeMillis() + " went into printE().");
		System.out.println(Thread.currentThread().getName() + ":" + System.currentTimeMillis() + " got out of printE().");
	}
}
