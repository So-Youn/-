package mapred.exam.air.multiple;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.output.MultipleOutputs;

public class AirMultipleReducer extends Reducer<Text, IntWritable, Text, IntWritable>{
	Text resultKey = new Text();
	IntWritable resultVal = new IntWritable(1);
	MultipleOutputs<Text, IntWritable> multiOut;


	@Override
	protected void setup(Reducer<Text, IntWritable, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		multiOut = new MultipleOutputs<Text,IntWritable>(context);
		
	}
	
	@Override
	protected void cleanup(Reducer<Text, IntWritable, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		multiOut.close();
	}
	


	@Override
	protected void reduce(Text key, Iterable<IntWritable> values,
			Reducer<Text, IntWritable, Text, IntWritable>.Context context) throws IOException, InterruptedException {
		
		
		String[] data = key.toString().split(",");
		resultKey.set(data[1]);
		if(data[0].equals("departure")) {
			int sum=0;
			for(IntWritable value:values) {
				sum = sum+value.get();
			}
			resultVal.set(sum); //outputvalue..
			multiOut.write("departure", resultKey, resultVal);
		}else if(data[0].equals("arrive")) {
			int sum=0;
			for(IntWritable value:values) {
				sum = sum+value.get();
			}
			resultVal.set(sum); //outputvalue..
			multiOut.write("arrive", resultKey, resultVal);
		}else if(data[0].equals("departureNA")) {
			int sum=0;
			for(IntWritable value:values) {
				sum = sum+value.get();
			}
			resultVal.set(sum); //outputvalue..
			multiOut.write("departureNA", resultKey, resultVal);
		}else {
			int sum=0;
			for(IntWritable value:values) {
				sum = sum+value.get();
			}
			resultVal.set(sum); //outputvalue..
			multiOut.write("arriveNA", resultKey, resultVal);
		}
		
	}
}
