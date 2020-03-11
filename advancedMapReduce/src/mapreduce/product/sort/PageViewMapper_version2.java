package mapreduce.product.sort;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class PageViewMapper_version2 extends Mapper<LongWritable, Text, MyKey, Text> {
	
	MyKey outputkey = new MyKey();
	Text outputValue = new Text();

	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, MyKey, Text>.Context context)
			throws IOException, InterruptedException {
		
			String[] line = value.toString().split("\\t");
					outputkey.setProductId(line[2]);
					outputkey.setUserId(line[9]);
					outputValue.set(line[9]);
					context.write(outputkey, outputValue);
				
	}

}
