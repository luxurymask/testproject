package testthread.pipedinputoutputstream;

import java.io.PipedInputStream;

public class ReadThread extends Thread{
	private ReadData read;
	private PipedInputStream inputStream;
	
	public ReadThread(ReadData read, PipedInputStream inputStream){
		this.read = read;
		this.inputStream = inputStream;
	}
	
	public void run(){
		read.readMethod(inputStream);
	}
}
