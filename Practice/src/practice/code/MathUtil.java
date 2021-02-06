package practice.code;

public class MathUtil {
	
	public static int gcd(int a, int b) {
		if(b==0) {
			return a;
		}else {
			return gcd(b,a%b);
		}
	}
	public static int abs(int a) {
		if(a<0) {
			return (-1)*a;
		}else {
			return a;
		}
	}
	
}
