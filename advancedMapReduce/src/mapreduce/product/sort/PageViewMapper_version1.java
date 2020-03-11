package mapreduce.product.sort;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class PageViewMapper_version1 extends Mapper<LongWritable, Text, MyKey, IntWritable> {
	//LongWritable, Text : 한 라인 전체가 통으로 들어올 것.
	//MyKey, IntWritable :partitioner에서 형태 맞추어 주어야 한다.
	MyKey outputkey = new MyKey();
	static final IntWritable one = new IntWritable(1);

	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, MyKey, IntWritable>.Context context)
			throws IOException, InterruptedException {
		
			String[] line = value.toString().split("\\t");
					outputkey.setProductId(line[2]);
					outputkey.setUserId(line[9]);
					context.write(outputkey, one);
				
	}

}
