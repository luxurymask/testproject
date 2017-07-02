package testJVM.eliminatelocks;

/**
 * -server -XX:+DoEscapeAnalysis -XX:+EliminateLocks
 * 为什么锁消除开启后StringBuffer仍然比StringBuilder慢？
 * @author liuxl
 *
 */
public class Main {
	public static void main(String[] args){
		StringBuffer stringBuffer = new StringBuffer();
		long stringBufferStart = System.currentTimeMillis();
		for(int i = 0;i < 10000;i++){
			stringBuffer.append(i + "ddddd");
		}
		long stringBufferTime = System.currentTimeMillis() - stringBufferStart;
		System.out.println(stringBufferTime);
		
		StringBuilder stringBuilder = new StringBuilder();
		long stringBuilderStart = System.currentTimeMillis();
		for(int i = 0;i < 10000;i++){
			stringBuilder.append(i + "ddddd");
		}
		long stringBuilderTime = System.currentTimeMillis() - stringBuilderStart;
		System.out.println(stringBuilderTime);
	}
}
