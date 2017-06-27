package testproject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapCopyTest {
	public static void main(String[] args){
		//基本数据类型是没有问题的
		Map<String, String> mapOri = new HashMap<String, String>();
		mapOri.put("1", "1");
		mapOri.put("2", "2");
		mapOri.put("3", "3");
		Map<String, String> mapCopy2 = new HashMap<String, String>();
		mapCopy2.putAll(mapOri);
		for(Map.Entry<String, String> entry : mapOri.entrySet()){
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		System.out.println("----------------");
		for(Map.Entry<String, String> entry : mapCopy2.entrySet()){
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		mapCopy2.replace("3", "33");
		System.out.println("----------------");
		for(Map.Entry<String, String> entry : mapOri.entrySet()){
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		System.out.println("----------------");
		for(Map.Entry<String, String> entry : mapCopy2.entrySet()){
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		mapCopy2.put("5", "5");
		System.out.println("----------------");
		for(Map.Entry<String, String> entry : mapOri.entrySet()){
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		System.out.println("----------------");
		Iterator<Map.Entry<String, String>> iterator = mapCopy2.entrySet().iterator();
		while(iterator.hasNext()){
			Map.Entry<String, String> entry = iterator.next();
			if(entry.getKey().equals("1")){
				iterator.remove();
			}
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		System.out.println("----------------");
		for(Map.Entry<String, String> entry : mapOri.entrySet()){
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		System.out.println("----------------");
		for(Map.Entry<String, String> entry : mapCopy2.entrySet()){
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		
		//
		Map<String, Map<String, String>> originalMap = new HashMap<String, Map<String, String>>();
		Map<String, String> oriSubMap = new HashMap<String, String>();
		oriSubMap.put("1", "1");
		oriSubMap.put("2", "2");
		oriSubMap.put("3", "3");
		originalMap.put("a", oriSubMap);
		Map<String, Map<String, String>> copyMap = new HashMap<String, Map<String, String>>();
		copyMap.putAll(originalMap);
		
		System.out.println("###########################################################");
		for(Map.Entry<String, Map<String, String>> entry : originalMap.entrySet()){
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		System.out.println("----------------");
		for(Map.Entry<String, Map<String, String>> entry : copyMap.entrySet()){
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		

		for(Map.Entry<String, Map<String, String>> entry : copyMap.entrySet()){
			Iterator<Map.Entry<String, String>> iterator2 = entry.getValue().entrySet().iterator();
			while(iterator2.hasNext()){
				Map.Entry<String, String> entry2 = iterator2.next();
				if(entry2.getKey().equals("1")){
					iterator2.remove();
				}
			}
		}
		System.out.println("----------------");
		for(Map.Entry<String, Map<String, String>> entry : originalMap.entrySet()){
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		System.out.println("----------------");
		for(Map.Entry<String, Map<String, String>> entry : copyMap.entrySet()){
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}
}
