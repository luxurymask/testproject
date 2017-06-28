package testthread.pipedinputoutputstream;

import java.io.IOException;
import java.io.PipedInputStream;

public class ReadData {
	public void readMethod(PipedInputStream input){
		try{
			System.out.println("read start...");
			byte[] byteArray = new byte[32];
			int readLength = input.read(byteArray);
			while(readLength != -1){
				String inData = new String(byteArray, 0, readLength);
				System.out.println("read: " + inData);
				readLength = input.read(byteArray);
			}
			System.out.println("read end.");
			input.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
