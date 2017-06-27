package testproject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Stream;

public class Test {
	private static final int ID_NUM = 360;
	
	public static void checkResult(){
		File input = new File("/Users/liuxl/Downloads/result(1).txt");
		BufferedReader reader = null;
		String text = null;
		Map<String, String> resultMap = new HashMap<String, String>();
		try{
			reader = new BufferedReader(new FileReader(input));
			while((text = reader.readLine()) != null){
				String[] texts = text.split(" ");
				int length = texts.length;
				if(length >= 2){
					String id = texts[length - 2];
					String flow = texts[length - 1];
					if(resultMap.containsKey(id)){
						resultMap.replace(id, Integer.parseInt(resultMap.get(id)) + Integer.parseInt(flow) + "");
					}else{
						resultMap.put(id, flow);
					}
				}
			}
			System.out.println(resultMap.size());
			int missingCount = 0;
			for(int i = 0;i < ID_NUM;i++){
				if(resultMap.containsKey(i + "")){
					System.out.println("nodeId: " + i + " flow: " + resultMap.get(i + ""));
				}else{
					System.out.println(i + " fuck了老铁...");
					missingCount++;
				}			
			}
			System.out.println("missing: " + missingCount);
		}catch(Exception e){
			System.out.println(e);
		}
		
	}
	
	public static void degree(String path, Map<String, List<String>> degreeMap){
		degree(path, degreeMap, null, null, null);
	}
	
	public static  void degree(String path, Map<String, List<String>> degreeMap, Map<String, Integer> flowMap, Map<String, Integer> costMap, Map<String, Float> flowOverCostMap){
		File caseFile = new File(path);
		BufferedReader reader = null;
		String text = null;
		try{
			reader = new BufferedReader(new FileReader(caseFile));
			while((text = reader.readLine()) != null){
				String[] s = text.split(" ");
				if(s.length == 4){
					String s1 = s[0];
					String s2 = s[1];
					int s3 = Integer.parseInt(s[2]);
					int s4 = Integer.parseInt(s[3]);
					List list = null;
					if(degreeMap.containsKey(s1)){
						list = degreeMap.get(s1);
						list.add(s2);
						degreeMap.replace(s1, list);
						if(flowMap != null){
							flowMap.replace(s1, flowMap.get(s1) + s3);
							costMap.replace(s1, costMap.get(s1) + s4);
							flowOverCostMap.replace(s1, flowOverCostMap.get(s1) + (float)s3/s4);
						}
					}else{
						list = new ArrayList<String>();
						list.add(s2);
						degreeMap.put(s1, list);
						if(flowMap != null){
							flowMap.put(s1, s3);
							costMap.put(s1, s4);
							flowOverCostMap.put(s1, (float)s3/s4);
						}
					}
					list = null;
					if(degreeMap.containsKey(s2)){
						list = degreeMap.get(s2);
						list.add(s1);
						degreeMap.replace(s2, list);
						if(flowMap != null){
							flowMap.replace(s2, flowMap.get(s2) + s3);
							costMap.replace(s2, costMap.get(s2) + s4);
							flowOverCostMap.replace(s2, flowOverCostMap.get(s2) + (float)s3/s4);
						}
					}else{
						list = new ArrayList<String>();
						list.add(s1);
						degreeMap.put(s2, list);
						if(flowMap != null){
							flowMap.put(s2, s3);
							costMap.put(s2, s4);
							flowOverCostMap.put(s2, (float)s3/s4);
						}
					}
				}
			}
		}catch(Exception e){
			System.out.println("0xff" + e);
		}
	}
	
	public static Map<String, Map<String, Integer>> getResult(String resultPath){
		File resultFile = new File(resultPath);
		Map<String, Map<String, Integer>> resultMap = new HashMap<String, Map<String, Integer>>();
		
		BufferedReader reader = null;
		String text = null;
		Map<String, Integer> nextMap = null;
		try{
			reader = new BufferedReader(new FileReader(resultPath));
			while((text = reader.readLine()) != null){
				String[] texts = text.split(" ");
				int length = texts.length;
				if(length > 1){
					String serverId = texts[0];
					String nextId = texts[1];
					int flow = Integer.parseInt(texts[length - 1]);
					if(resultMap.containsKey(serverId)){
						nextMap = resultMap.get(serverId);
						if(nextMap.containsKey(nextId)){
							nextMap.replace(nextId, nextMap.get(nextId) + flow);
						}else{
							nextMap.put(nextId, flow);
						}
					}else{
						nextMap = new HashMap<String, Integer>();
						nextMap.put(nextId, flow);
					}
					resultMap.put(serverId, nextMap);
				}
			}
		}catch(Exception e){
			System.out.println(e);
		}
		return resultMap;
	}
	
	public static void getCase(String casePath, Map<String, Map<String, Integer>> nodeNextFlowMap, Map<String, Map<String, Integer>> nodeNextCostMap){
		File caseFile = new File(casePath);
		BufferedReader  reader = null;
		String text = null;
		Map<String, Integer> nextFlowMap = null;
		Map<String, Integer> nextCostMap = null;
		try{
			reader = new BufferedReader(new FileReader(caseFile));
			while((text = reader.readLine()) != null){
				String[] texts = text.split(" ");
				if(texts.length == 4){
					String id1 = texts[0];
					String id2 = texts[1];
					int flow = Integer.parseInt(texts[2]);
					int cost = Integer.parseInt(texts[3]);
					if(nodeNextFlowMap.containsKey(id1)){
						nextFlowMap = nodeNextFlowMap.get(id1);
						nextCostMap = nodeNextCostMap.get(id1);
					}else{
						nextFlowMap = new HashMap<String, Integer>();
						nextCostMap = new HashMap<String, Integer>();
					}
					nextFlowMap.put(id2, flow);
					nextCostMap.put(id2, cost);
					nodeNextFlowMap.put(id1, nextFlowMap);
					nodeNextCostMap.put(id1, nextCostMap);

					if(nodeNextFlowMap.containsKey(id2)){
						nextFlowMap = nodeNextFlowMap.get(id2);
						nextCostMap = nodeNextCostMap.get(id2);
					}else{
						nextFlowMap = new HashMap<String, Integer>();
						nextCostMap = new HashMap<String, Integer>();
					}
					nextFlowMap.put(id1, flow);
					nextCostMap.put(id1, cost);
					nodeNextFlowMap.put(id2, nextFlowMap);
					nodeNextCostMap.put(id2, nextCostMap);
					
				}else if(texts.length == 3 && !texts[0].equals("800")){
					break;
				}
			}
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	/**
	 * Map按value排序，代码来自：http://www.cnblogs.com/liu-qing/p/3983496.html
	 * @param map
	 * @return
	 */
	public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        Map<K, V> result = new LinkedHashMap<>();
        Stream<Entry<K, V>> st = map.entrySet().stream();

        st.sorted(Comparator.comparing(e -> e.getValue())).forEach(e -> result.put(e.getKey(), e.getValue()));

        return result;
    }
	
	/**
	 * Map按value排序降序（Java7），代码来自：http://www.cnblogs.com/liu-qing/p/3983496.html
	 * @param map
	 * @return
	 */
	public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue7(Map<K, V> map) {
        List<Map.Entry<K, V>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
            @Override
            public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }
	
	public static void main(String[] args){
		String s = "123|323dsaf|dsadkf";
		String[] array = s.split("");
		String[] array2 = s.split("|");
		String[] array3 = s.split("\\|");
		for(String ss : array){
			System.out.print(ss + " ");
		}
		System.out.println();
		for(String ss : array2){
			System.out.print(ss + " ");
		}
		System.out.println();
		for(String ss : array3){
			System.out.print(ss + " ");
		}
	}
}
