package testJVM.ldc;

public class Main {
	public static void main(String[] args){
		String s1 = "123";
		String s2 = "123";
		System.out.println(s1 == s2);
		
		Integer i = 127;
		Integer j = 127;
		Integer k1 = Integer.valueOf(127);
		Integer k2 = Integer.valueOf(128);
		System.out.println(i == j);
		/**
		 * IntegerCache
		 */
		System.out.println(i == k1);
		System.out.println(i == k2);
	}
}
