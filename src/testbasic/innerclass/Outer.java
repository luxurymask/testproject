package testbasic.innerclass;

import java.lang.reflect.Field;

/**
 * 如何通过内部类实例获取到外部类实例？
 * @author liuxl
 */
public class Outer {
	private int i;
	
	class Inner{
		
	}
	
	public Outer() throws Exception{
		getOuter(new Inner(){
			
		});
	}

	//TODO
	public static Outer getOuter(Inner inner) throws Exception{
		Field outerThisField0 = inner.getClass().getDeclaredFields()[0];
		int i = outerThisField0.getInt(inner);
		System.out.println(i);
		return null;
	}
}
