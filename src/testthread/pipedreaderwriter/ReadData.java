package testthread.pipedreaderwriter;

import java.io.IOException;
import java.io.PipedReader;

public class ReadData {
	public void readMethod(PipedReader reader){
		try{
			System.out.println("read start...");
			char[] charArray = new char[32];
			int readLength = reader.read(charArray);
			while(readLength != -1){
				String inData = new String(charArray, 0, readLength);
				System.out.println("read: " + inData);
				readLength = reader.read(charArray);
			}
			System.out.println("read end.");
			reader.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
