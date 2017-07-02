package testJVM.finalize;

public class CanReliveObject {
	public static CanReliveObject canReliveObject;

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("CanReliveObject finalize() called");
		canReliveObject = this;
		System.out.println(canReliveObject.hashCode());
	}
}
