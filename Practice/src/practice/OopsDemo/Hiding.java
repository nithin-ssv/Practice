package practice.OopsDemo;

class A{
	
	public void demo(int x, int y) {
		
		System.out.println("\nInside Class A ..");
		
	}
	
}

class  B extends A{
	
	public void demo(float x, float y) {
		
		System.out.println("\nInside Class B ..");
		
	}
	
}

public class Hiding{
	
	public static void main(String args[]) {
		
		B b = new B();
		b.demo(1.0f, 2.0f);
		
	}
	
	
}