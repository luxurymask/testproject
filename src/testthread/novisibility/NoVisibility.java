package testthread.novisibility;

public class NoVisibility {
	private int value = 0;
	private boolean ready = false;
	
	public synchronized int synchronizedGet(){
		return value;
	}
	
	public int get(){
		return value;
	}
	
	public synchronized void synchronizedSet(int value){
		this.value = value;
		this.ready = true;
	}
	
	public void set(int value){
		this.value = value;
		this.ready = true;
	}
	
	public static void main(String[] args){
		NoVisibility nv = new NoVisibility();
		new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + " set 3.");
				nv.set(3);
				System.out.println(Thread.currentThread().getName() + " set 3 over.");
			}
			
		}).start();
		
		new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(nv.ready == false){
					System.out.println(Thread.currentThread().getName() + " " + nv.synchronizedGet());
				}
				System.out.println(Thread.currentThread().getName() + " " + nv.synchronizedGet());
			}
			
		}).start();
		
		new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(nv.ready == false){
					System.out.println(Thread.currentThread().getName() + " " + nv.synchronizedGet());
				}
				System.out.println(Thread.currentThread().getName() + " " + nv.synchronizedGet());
			}
			
		}).start();
	}
}
