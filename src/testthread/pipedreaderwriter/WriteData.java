package testthread.pipedreaderwriter;

import java.io.IOException;
import java.io.PipedWriter;

public class WriteData {
	public void writeMethod(PipedWriter writer){
		try{
			System.out.println("write start...");
			for(int i = 0;i < 300;i++){
				String outData = "" + i;
				writer.write(outData);
				System.out.println("write: " + outData);
			}
			System.out.println("write end.");
			writer.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
