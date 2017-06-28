package testthread.inheritablethreadlocal;

public class Main {
	public static void main(String[] args){
		try{
			for(int i = 0;i < 10;i++){
				System.out.println("Main: " + Tools.t1.get());
			}
			Thread.sleep(5000);
			ThreadA a = new ThreadA();
			a.start();
			Tools.t1.set("new value");
			for(int i = 0;i < 10;i++){
				System.out.println("Main: " + Tools.t1.get());
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}
