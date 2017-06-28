package testthread.pipedreaderwriter;

import java.io.PipedWriter;

public class WriteThread extends Thread{
	private WriteData write;
	private PipedWriter writer;
	
	public WriteThread(WriteData write, PipedWriter writer){
		this.write = write;
		this.writer = writer;
	}
	
	public void run(){
		write.writeMethod(writer);
	}
}
