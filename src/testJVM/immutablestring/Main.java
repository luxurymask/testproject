package testJVM.immutablestring;

import java.lang.reflect.Field;

public class Main {
	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		String s = "sssss";
		
		System.out.println(s);
		Field valueField = String.class.getDeclaredField("value");
		valueField.setAccessible(true);
		char[] value = (char[])valueField.get(s);
		value[0] = 'B';
		System.out.println(s);
		
		String s2 = "test";
		Field hashField = String.class.getDeclaredField("hash");
		hashField.setAccessible(true);
		int hash = (int)hashField.getInt(s);
		hash = s2.hashCode();
		System.out.println(s.hashCode() == s2.hashCode());
		System.out.println(s == s2);
	}
}
