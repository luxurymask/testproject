package somewhereoj;

import java.util.Deque;
import java.util.LinkedList;

/*
 * http://cxsjsxmooc.openjudge.cn/2017t2winterw3/1/
 */
public class BooleanExpressions {
	//TODO
	public boolean analyzeExpression(String expression){
		char[] cArray = expression.toCharArray();
		Deque<Character> stack = new LinkedList<>();
		for(int i = 0;i < cArray.length;i++){
			char c = cArray[i];
			if(c == 'V' || c == 'F'){
				stack.push(c);
			}else if(c == '&'){
				c = cArray[++i];
				if(c == 'T' && stack.pop() == 'T') stack.push('T');
				else stack.push('F');
			}
		}
		
		return true;
	}
}
