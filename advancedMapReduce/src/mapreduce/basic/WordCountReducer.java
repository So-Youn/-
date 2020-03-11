package mapreduce.basic;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class WordCountReducer extends Reducer<Text, IntWritable, Text, IntWritable>{
	IntWritable resultVal = new IntWritable();
	Text appenddata = new Text();
	String data = "";
	Text resultKey = new Text();
	@Override
	protected void reduce(Text key, Iterable<IntWritable> values, //Iterable : 반복해서 작업할 때 사용하는 interface
			Reducer<Text, IntWritable, Text, IntWritable>.Context context) throws IOException, InterruptedException {
		int sum = 0;
		data = data +"reduce호출";
		appenddata.set(data);
		for (IntWritable value:values) { //reduce에 전달된 입력데이터의 값을 꺼내서 모두 더하기 
			sum = sum+value.get();  // get메소드를 통해서 int값만 꺼낼 수 있음
		}
		resultVal.set(sum);
		resultKey.set(key+":"+appenddata);
		context.write(resultKey, resultVal);
		
		
	
	
	}
}


