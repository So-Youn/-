package pattern.exam;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTest03 {
	public static void main(String[] args) {
		//String str = "jaava progra mmaingm";
		//String str ="-@-ja1-  -111aCva--@@-@@@@- 한글 --@@@@-- progra44568EmgFmiJng";
		//String patternStr =".*";
		//String patternStr ="-@+-";
		//String patternStr ="-@?-"; 없거나 하나이거나
		//String patternStr ="[^ ]"; //공백이 아닌 문자
		//String patternStr =".{5}"; //5글자씩 끊어서 출력
		String str = "a 4 m 7 v 9 amJAVA _java aaaxl  programming and spring , hadoop";
		//String patternStr ="[amv]{1,3}"; 
		// a,m,v 가 1회, 2회, 3회인 문자
		//a,m,v,aa,am,av,mv,aaa,aam,amv...
		//String patternStr ="[a-z]{3,}";//3글자 이상
		//String patternStr ="\\W"; // 대문자, 소문자 ,숫자 뺀 모두
		//String patternStr = "\\w"; //대문자 ,소문자, 숫자 모두
		//String patternStr ="\\d"; //숫자만
		String patternStr ="\\D"; //숫자 뺀 나머지
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
