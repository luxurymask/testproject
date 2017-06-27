package testthread.synchronizedonclass;

public class Run {
	public static void main(String[] args){
//		Service service = new Service();
//		ThreadA a = new ThreadA(service);
//		a.setName("A");
//		a.start();
//		ThreadB b = new ThreadB(service);
//		b.setName("B");
//		b.start();
//		ThreadC c = new ThreadC(service);
//		c.setName("C");
//		c.start();
		

		Service serviceA = new Service();
		Service serviceB = new Service();
		Service serviceC = new Service();
		ThreadA a = new ThreadA(serviceA);
		a.setName("A");
		a.start();
		ThreadB b = new ThreadB(serviceB);
		b.setName("B");
		b.start();
		ThreadC c = new ThreadC(serviceC);
		c.setName("C");
		c.start();
		
//		ServiceB service = new ServiceB();
//		ThreadD d = new ThreadD(service);
//		d.setName("D");
//		d.start();
//		ThreadE e = new ThreadE(service);
//		e.setName("E");
//		e.start();
	}
}
