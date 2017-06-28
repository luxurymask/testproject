package testthread.pipedreaderwriter;

import java.io.PipedReader;

public class ReadThread extends Thread{
	private ReadData read;
	private PipedReader reader;
	
	public ReadThread(ReadData read, PipedReader reader){
		this.read = read;
		this.reader = reader;
	}
	
	public void run(){
		read.readMethod(reader);
	}
}
