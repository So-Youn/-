package mapreduce.basic;

//라인 하나에 대해 처리하는 메소드
//Mapper => 데이터를 분류하는 역할
import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/*
 * Mapper
 * 1. Mapper 클래스를 상속한다
 *  => Mapper에 전달될 input데이터의 key,value타입과 Mapper의 실행 결과로 출력되는 output데이터의 key,value타입을 정의
 * 2.map메소드를 오버라이딩해서 map작업을 수행하면서 처리할 내용을 구현
 *  => 입력된 값을 분석하기 위한 메소드 : 입력된 데이터에 조건을 적용해서 원하는 데이터를 추출하기 위한 반복작업을 수행
 *  
 *  map 메소드의 매개변수 - 입력데이터 키, 입력 값, context
 *  								    --------
 *  									맵리듀스 작업을 수행하여 맵메소드의 실행결과 즉, 출력데이터를 기록하고 
 *  									shuffle(short,merge)하고 리듀서로 내보내는 작업을 수행하는 객체.
 *  									프레임워크 내부에서 기본작업을 처리하는 핵심적인 객체.
 *  									내부에서 머신들끼리 통신할 때 필요한 여러가지 정보를 갖고있다. 
 * 
*/
public class WordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
	//Mapper에서 하는 일 : output데이터를 Mapper의 실행결과로 내보낼 수 있도록 key와 value를 저장하는 변수
	//output데이터의 value는 무조건 1이므로 상수로 정의
	static final IntWritable outputVal = new IntWritable(1);   //static으로 상수로 만들어줌 
	
	//output데이터의 key는 문자열이므로 Text타입으로 정의
	Text outputkey = new Text(); //input은 정해져있지만 output데이터는 내가 만들어주는 것이므로 Text...
	
	
	
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		//key는 linenumber, value는 입력데이터의 한 라인에 해당하는 문장.
		//value는 입력데이터의 한 라인에 해당하는 문장 ex) read a book
		//inputdata를 공백에 대해서 분리하는 작업해주는 클래스 : StringTokenizer => read / a / book => token 3개
		StringTokenizer st = new StringTokenizer(value.toString()," ");  //기본 작업 위해 ," " 추가
		while(st.hasMoreTokens()) { 
			String token = st.nextToken();
			outputkey.set(token); 
			//Context객체의 write메소드를 통해서 output으로 내보낼 데이터의 key와 value를 정의
			context.write(outputkey, outputVal);
		}
	}
	
}
