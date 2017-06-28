package testthread.pipedinputoutputstream;

import java.io.IOException;
import java.io.PipedOutputStream;

public class WriteData {
	public void writeMethod(PipedOutputStream out){
		try{
			System.out.println("write start...");
			for(int i = 0;i < 300;i++){
				String outData = "" + i;
				out.write(outData.getBytes());
				System.out.println("write: " + outData);
			}
			System.out.println("write end.");
			out.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
