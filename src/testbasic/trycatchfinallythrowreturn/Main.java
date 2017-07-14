package testbasic.trycatchfinallythrowreturn;

public class Main {
	public static int test(){
		try{
			System.out.println("try");
			return 0;
		}catch(Exception e){
			System.out.println("catch");
			return 1;
		}finally{
			System.out.println("finally");
		}
	}
	
	public static int test1(){
		try{
			System.out.println("try");
			return 0;
		}catch(Exception e){
			System.out.println("catch");
			return 1;
		}finally{
			System.out.println("finally");
			return 2;
		}
	}
	
	public static int test2() throws Exception{
		try{
			System.out.println("try");
			throw new Exception("try throw");
		}catch(Exception e){
			System.out.println("catch");
			throw new Exception("catch throw");
		}finally{
			System.out.println("finally");
		}
	}
	
	public static int test3() throws Exception{
		try{
			System.out.println("try");
			throw new Exception("try throw");
		}finally{
			System.out.println("finally");
		}
	}
	
	public static void main(String[] args){
		System.out.println(test());
		System.out.println(test1());
		try {
			System.out.println(test3());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
