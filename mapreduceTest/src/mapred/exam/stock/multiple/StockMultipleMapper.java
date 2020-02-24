package mapred.exam.stock.multiple;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class StockMultipleMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
	Text outputkey = new Text();
	static final IntWritable one = new IntWritable(1);

	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		if (key.get() > 0) {

			String[] line = value.toString().split(",");
			if (line != null & line.length > 0) {
				String year = line[2].substring(0, 4);
				double result = Double.parseDouble(line[6]) - Double.parseDouble(line[3]);
				
					if (result > 0) {
						outputkey.set("up,"+year);
						context.write(outputkey, one);
					}
					else if (result < 0) {
						outputkey.set("down,"+year);
						context.write(outputkey, one);
					}
					else {
						outputkey.set("equal,"+year);
						context.write(outputkey, one);
					}
				}

			}
		}
	}


