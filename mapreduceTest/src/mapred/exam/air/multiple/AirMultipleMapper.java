package mapred.exam.air.multiple;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
public class AirMultipleMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
	
	Text outputkey = new Text();
	static final IntWritable one = new IntWritable(1);

	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		if (key.get() > 0) {
			String[] line = value.toString().split(",");
			String month = line[1];
			if (line != null & line.length > 0) {
					
					// 출발 지연
					if (!line[15].equals("NA") && Integer.parseInt(line[15]) > 0) {
						outputkey.set("departure,"+month);
						context.write(outputkey, one);
					}
					//도착 지연
					if (!line[14].equals("NA") && Integer.parseInt(line[14]) > 0) {
						outputkey.set("arrive,"+month);
						context.write(outputkey, one);
					}
					if(line[15].equals("NA")){
						outputkey.set("departureNA,"+month);
						context.write(outputkey, one);
					}
					if(line[14].equals("NA")) {
						outputkey.set("arriveNA,"+month);
						context.write(outputkey, one);
					}
					
			}
		}
	}
}
