package pattern.exam;

import java.util.regex.Pattern;

/*
 *  Password 체크
 *  	-> 8글자 이상, 대문자, 소문자, 특수문자, 숫자가 모두 포함
 *  	-> Pattern 연습하면서 작업했던 코드 rename
 *  
 */

public class PassCheck {
	public static boolean isPass(String str) {
		String passreg="";
		return Pattern.matches(passreg, str);
	}
	public static void main(String[] args) {
		System.out.println(isPass("127.0.0.1"));//true
    	System.out.println(isPass("196.168.59.101"));//true
    	System.out.println(isPass("250.0.8.9"));//true
    	System.out.println(isPass("196.168.59"));//false
    	System.out.println(isPass("300.168.59.101"));//false
    	System.out.println(isPass("300.168.592332.101"));//false
    	System.out.println(isPass("300.168.592.문자열"));//false

	}

}
