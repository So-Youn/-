package pattern.exam;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTest05 {
	public static void main(String[] args) {
	//	String str = "tomato jaava tomato prog potato";
		//String str = "aaaaa aaabc iiiii iiibc aiabc";
		String str = "adsf111 a1 b5 b55 aaa5 qa5 5a";
		//String patternStr ="(tom|pot)ato"; //숫자 뺀 나머지
		//String patternStr = "(a|i) {3}bc"; // a가 3번이거나 i가 3번
		
		String patternStr = "([a-z][0-9])"; //영문자 먼저 -> 숫자
		equalsPattern(str, patternStr);	
	}
	public static void equalsPattern(String str, String patternStr) {
		//1. 패턴을 인식
		Pattern pattern = Pattern.compile(patternStr);
		//2. 패턴을 적용하여 문자열을 관리
		Matcher m = pattern.matcher(str);
		while(m.find()) {
			System.out.println(m.group());
			System.out.println(m.start()+":"+(m.end()-1));
			//위치 정보와 원하는 위치 추출 가능
		}
	} 
}
