package testbasic.memberextends;

public class Son extends Father{
	private int j = 1;
	
	public void print(){
		super.print();
		System.out.println("Son print i : " + this.i);
		System.out.println("Son print j : " + j);
	}
}
