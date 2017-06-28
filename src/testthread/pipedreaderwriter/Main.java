package testthread.pipedreaderwriter;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

public class Main {
	public static void main(String[] args){
		WriteData write = new WriteData();
		ReadData read = new ReadData();
		
		PipedWriter writer = new PipedWriter();
		PipedReader reader = new PipedReader();
		
		try{
			writer.connect(reader);
			
			WriteThread writeThread = new WriteThread(write, writer);
			writeThread.start();
			Thread.sleep(1000);
			writeThread.join();
			ReadThread readThread = new ReadThread(read, reader);
			readThread.start();
			
		} catch(IOException e){
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
