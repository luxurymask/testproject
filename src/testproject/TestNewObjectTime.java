package testproject;

import java.util.HashMap;
import java.util.Map;

public class TestNewObjectTime {
	private int i;
	
	public void test(){
		int i;
		Object o;
		int[] array;
		
		
		long currentT1 = System.currentTimeMillis();
		i = 0;
		long currentT2 = System.currentTimeMillis();
		this.i = 0;
		long currentT3 = System.currentTimeMillis();
		o = new Object();
		long currentT4 = System.currentTimeMillis();
		array = new int[10];
		long currentT5 = System.currentTimeMillis();
		
		System.out.println("i = 0 costs: " + (currentT2 - currentT1));
		System.out.println("this.i = 0 costs: " + (currentT3 - currentT2));
		System.out.println("o = new Object() costs: " + (currentT4 - currentT3));
		System.out.println("array = new int[10] costs: " + (currentT5 - currentT4));
	}
	
	public static void main(String[] args){
		System.out.println(System.currentTimeMillis());
		TestNewObjectTime tnot = new TestNewObjectTime();
		tnot.test();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(System.currentTimeMillis());
	}
}
