package testproject;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {	
	public static void main(String[] args){
		Map<String, String> map = new HashMap<String, String>();
		System.out.println(map.get("1"));
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		String[] result = new String[n + 1];
		for(int i = 1;i <= n;i++){
			result[i] = i + "";
		}
		quickSort(result, 1, n);
		System.out.println(result[m]);
	}
	
	public static void quickSort(String[] A, int p, int q){
        if(p < q){//don't forget the bound.
            int i = partitionTwoPointers(A, p, q);
            quickSort(A, p, i - 1);
            quickSort(A, i + 1, q);
        }
    }
    
    public static int partitionTwoPointers(String[] A, int p, int q){
    	String x = A[p];
    	int i = p;
    	int j = q;
    	while(i < j){
    		while(i < j && A[j].compareTo(x) >= 0) j--;
    		A[i] = A[j];
    		while(i < j && A[i].compareTo(x) <= 0) i++;
    		A[j] = A[i];
    	}
    	A[i] = x;
    	return i;
    }
//	public static void main(String[] args){
//		Scanner in = new Scanner(System.in);
//		String s = in.next();
//		String s1 = s;
//		String s2 = s;
//		int count = 0;
//		for(int i = 0;i < s.length();i++){
//			String tmp = s2.substring(i, s.length()) + s1.substring(0, i);
//			if(tmp.equals(s)){
//				count++;
//			}
//		}
//		System.out.println(count);
//	}
//	public static void main(String[] args){
//		Scanner in = new Scanner(System.in);
//		int n = in.nextInt();
//		int m = in.nextInt();
//		int[] A = new int[n];
//		for(int i = 0;i < n;i++){
//			A[i] = in.nextInt();
//		}
//		int count = 0;
//		int[] result = new int[n];
//		
//		for(int i = 1;i < n;i++){
//			int temp = A[0] ^ A[i];
//			if(temp > m){
//				count++;
//			}
//			result[i] = temp;
//		}
//		for(int i = 1;i < n;i++){
//			for(int j = i + 1;j < n;j++){
//				if(result[i] + result[j] > m){
//					count++;
//				}
//			}
//		}
//		System.out.println(count);
//	}
//	public static void main(String[] args){
//		Scanner in = new Scanner(System.in);
//		int n = in.nextInt();
//		int[] difficulty = new int[n];
//		for(int i = 0;i < n;i++){
//			difficulty[i] = in.nextInt();
//		}
//		Arrays.sort(difficulty);
//		
//		int count = 0;
//		for(int i = 0;i < n;i++){
//			if(i == n - 2){
//				if(difficulty[i + 1] - difficulty[i] > 20){
//					count += 2;
//				}else{
//					count += 1;
//                  break;
//				}
//			}else if(i == n - 1){
//				count += 2;
//				break;
//			}
//			if(difficulty[i + 1] - difficulty[i] > 20){
//				count += 2;
//			}else if(difficulty[i + 1] - difficulty[i] > 10){
//				count += 1;
//				i++;
//			}else{
//				if(difficulty[i + 2] - difficulty[i + 1] > 10){
//					count += 1;
//       
//				}else{
//                  
//			
//                  i++;
//                }
//              i++;
//			}
//		}
//		System.out.println(count);
//	}
}
