package testproject;

public class TestStatic {
	public static int i;
	public int j;
	
	public static void test(int x){
		i = x;
	}
	
	public static void main(String[] args){
		TestStatic t1 = new TestStatic();
		TestStatic t2 = new TestStatic();
		
		t1.test(1);
		t2.test(2);
		System.out.println(t1.i);
		System.out.println(t2.i);
		System.out.println(TestStatic.i);
		TestStatic.test(3);
		System.out.println(t1.i);
		System.out.println(t2.i);
		System.out.println(TestStatic.i);
	}
}
