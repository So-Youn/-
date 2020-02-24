package mapred.exam.air;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class AirMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

	Text outputkey = new Text();
	static final IntWritable one = new IntWritable(1);

	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		if (key.get() > 0) {
			String[] line = value.toString().split(",");
			if (!line[15].equals("NA") & line.length > 0) {
				
					outputkey.set(line[1]+"월");
					double result = Double.parseDouble(line[15]);

					if (result > 0) {
						context.write(outputkey, one);

					
				}
			}
		}
	}

}
