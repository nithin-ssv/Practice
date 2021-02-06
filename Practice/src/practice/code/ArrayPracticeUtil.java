package practice.code;

public class ArrayPracticeUtil {

	public static boolean isValidChar(String inputChar) {
		
		int inputNum = Integer.parseInt(inputChar);
		if(inputNum >0 && inputNum <27) {
			return true;
		}else {
			return false;
		}
	
	}
	

	
}
