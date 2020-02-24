package mapred.exam.stock.multiple;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.output.MultipleOutputs;

public class StockMultipleReducer extends Reducer<Text, IntWritable, Text, IntWritable>{
	Text resultKey = new Text();
	IntWritable resultVal = new IntWritable(1);
	MultipleOutputs<Text, IntWritable> multiOut;

	@Override
	protected void cleanup(Reducer<Text, IntWritable, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		multiOut.close();
	}


	@Override
	protected void setup(Reducer<Text, IntWritable, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		multiOut = new MultipleOutputs<Text,IntWritable>(context);
		
	}


	@Override
	protected void reduce(Text key, Iterable<IntWritable> values,
			Reducer<Text, IntWritable, Text, IntWritable>.Context context) throws IOException, InterruptedException {
		//1.Mapper에 전달받은 key에서 구분값을 분리
		String[] data = key.toString().split(",");
		resultKey.set(data[1]);
		//2.key에 추가된 구분자별로  output
		if(data[0].equals("up")) {
			int sum=0;
			for(IntWritable value: values) {
				sum = sum + value.get();
			}
			resultVal.set(sum); //output value에 추가하기
			multiOut.write("up", resultKey, resultVal);
		}else if(data[0].equals("down")) {
			int sum=0;
			for(IntWritable value: values) {
				sum = sum + value.get();
			}
			resultVal.set(sum); //output value에 추가하기
			multiOut.write("down", resultKey, resultVal);
		}else {
			int sum=0;
			for(IntWritable value: values) {
				sum = sum + value.get();
			}
			resultVal.set(sum); //output value에 추가하기
			multiOut.write("equal", resultKey, resultVal);
		}
	}
	
}
