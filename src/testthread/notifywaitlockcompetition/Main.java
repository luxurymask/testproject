package testthread.notifywaitlockcompetition;

public class Main {
	public static void main(String[] args){
		Object lock = new Object();
		ThreadA a = new ThreadA(lock);
		a.start();
		NotifyThreadA nA = new NotifyThreadA(lock);
		nA.start();
		NotifyThreadB nB = new NotifyThreadB(lock);
		nB.start();
	}
}
