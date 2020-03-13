package pattern.exam;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternAPITest {

	public static void main(String[] args) {
		String value="배송이 너무 느려요 상품가 좋아서 예뻐요 좋아 좋아";
		Pattern p = Pattern.compile("은|는|이|가|요|서");
		Matcher m = p.matcher(value);
		//패턴에 일치하지 않는 문자들만 추출해서 저장
		StringBuffer sb = new StringBuffer(); 
		while(m.find()) {
			String data = m.group(); //패턴과 일치하는 단어 골라내는 작업
			System.out.println(data);
			//패턴에 만족하는 문자열을 ""로 치환한 후 전체 문자열을 StringBuffer에 저장 - \,$는 치환문자로 사용할 수 없다.
			m.appendReplacement(sb, ""); //치환할 때 패턴 문자, 기호는 사용하지 못함.
			
			
		}
		//조건에 만족하지 않아도 추가할 수 있도록 구현
		m.appendTail(sb); 
		System.out.println(sb);
		String[] result = sb.toString().split(" ");
		for(int i=0;i<result.length;i++) {
			System.out.println(result[i]);
		}
	}

}
