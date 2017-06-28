package testthread.pipedinputoutputstream;

import java.io.PipedOutputStream;

public class WriteThread extends Thread{
	private WriteData write;
	private PipedOutputStream outputStream;
	
	public WriteThread(WriteData write, PipedOutputStream outputStream){
		super();
		this.write = write;
		this.outputStream = outputStream;
	}
	
	public void run(){
		write.writeMethod(outputStream);
	}
}
