package testproject;

import java.util.HashMap;
import java.util.Map;

public class TestReferencesInArray {
	public static void main(String[] args){
		Object o1 = new Object();
		Object o2 = new Object();
		Object[] array = new Object[2];
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put(o2, null);
		array[0] = o1;
		array[1] = o2;
		o1 = null;
		o2 = null;
		System.out.println("");
	}
}
