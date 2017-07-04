package test.basic.parameterpassing;

public class Main {
	Object o1;
	static Object o2;
	public static void main(String[] args){
		Main main = new Main();
		main.o1 = new Object();
		o2 = new Object();
		Object o3 = new Object();
		
		System.out.println(main.o1.hashCode());
		System.out.println(o2.hashCode());
		System.out.println(o3.hashCode());
		
		//在进入test方法时，在test方法栈帧上生成了3个指向o1,o2,o3所指向的对象的引用。
		main.test(main.o1, o2, o3);
		
		//所以，虽然在test方法内部对引用进行了更改，但是更改的引用是test栈帧内的引用。
		//因此，在test方法出栈以后，原来的o1,o2,o3仍然引用着原来的对象，并没有发生变化。
		System.out.println(main.o1.hashCode());
		System.out.println(o2.hashCode());
		System.out.println(o3.hashCode());
	}
	
	public void test(Object o1, Object o2, Object o3){
		o1 = new Object();
		o2 = new Object();
		o3 = new Object();
		
		System.out.println(o1.hashCode());
		System.out.println(o2.hashCode());
		System.out.println(o3.hashCode());
	}
}
