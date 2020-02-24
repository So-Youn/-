package mapred.exam.stock;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class StockMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

	Text outputkey = new Text(); // output key
	static final IntWritable one = new IntWritable(1);

	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		// 첫번재 줄은 문자이기 때문에 파싱할 때 오류가 생긴다. 첫번 째 줄은 pass
		if (key.get() >0) {

			// map메소드는 라인 하나당 한번씩 호출이 된다. 그 한줄 : value (Text)
			String[] line = value.toString().split(",");
			if (line != null & line.length > 0) {
				// 년도, 상승마감
				outputkey.set(line[2].substring(0, 4));
				double result = Double.parseDouble(line[6]) - Double.parseDouble(line[3]);

				if (result > 0) { // 상승마감
					context.write(outputkey, one);
				}
				// 집계할 데이터 필터링.
			}
		}
	}

}
