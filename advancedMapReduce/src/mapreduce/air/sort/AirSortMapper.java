package mapreduce.air.sort;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class AirSortMapper extends Mapper<LongWritable, Text, CustomKey, IntWritable> {

	CustomKey outputkey = new CustomKey(); //output key
	static final IntWritable one = new IntWritable(1);

	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, CustomKey, IntWritable>.Context context)
			throws IOException, InterruptedException {
		if (key.get() > 0) {
			String[] line = value.toString().split(",");
			if (line != null & line.length > 0) {
				if (!line[15].equals("NA") && Integer.parseInt(line[15]) > 0) {
					outputkey.setYear(line[0]);
					outputkey.setMonth(new Integer(line[1]));
					outputkey.setMapkey(key.get()); // LongWritable이기 때문에 get으로 넘겨준다.
					context.write(outputkey, one);
				}

			}
		}
	}
}
