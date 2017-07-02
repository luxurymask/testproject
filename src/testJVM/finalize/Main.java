package testJVM.finalize;

public class Main {
	public static void main(String[] args) throws InterruptedException{
		CanReliveObject.canReliveObject = new CanReliveObject();
		System.out.println(CanReliveObject.canReliveObject.hashCode());
		CanReliveObject.canReliveObject = null;
		
		System.out.println("first gc");
		System.gc();
		
		Thread.sleep(2000);
		
		if(CanReliveObject.canReliveObject == null){
			System.out.println("canReliveObject == null");
		}else{
			System.out.println("canReliveObject != null");
			System.out.println(CanReliveObject.canReliveObject.hashCode());
		}
		
		CanReliveObject.canReliveObject = null;
		
		System.out.println("second gc");
		System.gc();
		
		Thread.sleep(2000);
		
		if(CanReliveObject.canReliveObject == null){
			System.out.println("canReliveObject == null");
		}else{
			System.out.println("canReliveObject != null");
			System.out.println(CanReliveObject.canReliveObject.hashCode());
		}
		
		System.out.println("-----------------cannot relive-------------------");
		
		CannotReliveObject.cannotReliveObject = new CannotReliveObject();
		System.out.println(CannotReliveObject.cannotReliveObject.hashCode());
		CannotReliveObject.cannotReliveObject = null;
		
		System.out.println("gc");
		System.gc();
		
		Thread.sleep(2000);
		
		if(CannotReliveObject.cannotReliveObject == null){
			System.out.println("cannotReliveObject == null");
		}else{
			System.out.println("cannotReliveObject != null");
			System.out.println(CannotReliveObject.cannotReliveObject.hashCode());
		}
	}
}
