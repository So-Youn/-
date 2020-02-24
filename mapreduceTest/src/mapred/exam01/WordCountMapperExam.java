package mapred.exam01;
//글자 수가 5개 이상인 것만 보고싶을 때
import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordCountMapperExam extends Mapper<LongWritable, Text, Text, IntWritable> {
	
	static final IntWritable outputVal = new IntWritable(1);
	
	Text outputkey = new Text();

	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		
		StringTokenizer st = new StringTokenizer(value.toString());
		while(st.hasMoreTokens()) {
			String token = st.nextToken();
			System.out.println(key+":"+value);
			if(token.length()>=5) {
				outputkey.set(token);
				context.write(outputkey, outputVal);
			}
		}
		
		
		
	}

	
	
	
	
}
