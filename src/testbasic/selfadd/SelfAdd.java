package testbasic.selfadd;

public class SelfAdd {
	private int count = 0;
	
	public int test(){
		return count++;
	}
	
	public static void main(String[] args){
		SelfAdd s = new SelfAdd();
		System.out.println(s.test());
		System.out.println(s.test());
	}
}
