package mapreduce.basic;

//라인 하나에 대해 처리하는 메소드
//Mapper => 데이터를 분류하는 역할
import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
	//Mapper에서 하는 일 : output데이터를 Mapper의 실행결과로 내보낼 수 있도록 key와 value를 저장하는 변수
	//output데이터의 value는 무조건 1이므로 상수로 정의
	static final IntWritable outputVal = new IntWritable(1);   //static으로 상수로 만들어줌 
	
	//output데이터의 key는 문자열이므로 Text타입으로 정의
	Text outputkey = new Text(); //input은 정해져있지만 output데이터는 내가 만들어주는 것이므로 Text...
	
	
	
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		StringTokenizer st = new StringTokenizer(value.toString()," ");  //기본 작업 위해 ," " 추가
		while(st.hasMoreTokens()) { 
			String token = st.nextToken();
			outputkey.set(token); 
			//Context객체의 write메소드를 통해서 output으로 내보낼 데이터의 key와 value를 정의
			context.write(outputkey, outputVal);
		}
	}
	
}
