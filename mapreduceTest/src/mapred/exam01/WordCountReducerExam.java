package mapred.exam01;
//빈도수 관련 조회하고 싶을 때는 여기서 작업하면 된다.
import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class WordCountReducerExam extends Reducer<Text, IntWritable, Text, IntWritable>{
	IntWritable resultVal = new IntWritable();

	@Override
	protected void reduce(Text key, Iterable<IntWritable> values,
			Reducer<Text, IntWritable, Text, IntWritable>.Context context) throws IOException, InterruptedException {
		int sum=0;
		for(IntWritable value:values) {
			sum = sum+value.get();
		}
		resultVal.set(sum);
		context.write(key, resultVal);
	}
	
}
