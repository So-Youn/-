package shop.bigdata.comment;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class CommentWordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
	static final IntWritable outputVal = new IntWritable(1);
	Text outputkey = new Text();
	

	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {

		Pattern p = Pattern.compile("은$|는$|이$|가$|요$|서$|워$");
		String[] w = value.toString().split(" |\t");
		StringBuffer sb = new StringBuffer();
		for (String string : w) {
			Matcher m = p.matcher(string);
			
			if(m.find()) {
				m.appendReplacement(sb, "");
				
			} else {
				m.appendTail(sb);
			}
			outputkey.set(sb.toString());
			context.write(outputkey, outputVal);
			sb.replace(0, sb.length(), "");
		}
	}
}
