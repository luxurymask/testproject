package testthread.pipedinputoutputstream;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Main {
	public static void main(String[] args) {
		WriteData write = new WriteData();
		ReadData read = new ReadData();

		PipedOutputStream outputStream = new PipedOutputStream();
		PipedInputStream inputStream = new PipedInputStream();

		try {
			outputStream.connect(inputStream);

			WriteThread writeThread = new WriteThread(write, outputStream);
			writeThread.start();

			Thread.sleep(1000);

			ReadThread readThread = new ReadThread(read, inputStream);
			readThread.start();
		} catch (IOException e) {
			e.printStackTrace();
		} catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}
