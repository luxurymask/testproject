package testthread.novisibility;

public class NoVisibility {
	private int value = 0;
	private boolean ready = false;
	
	public synchronized int get(){
		return value;
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
				nv.set(3);
			}
			
		}).start();
		
		new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(nv.ready == false){
					System.out.println(nv.get());
				}
				System.out.println(nv.get());
			}
			
		}).start();
	}
}
