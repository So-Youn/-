package mapred.exam.air.option;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/* 
 * 하둡을 실행할 때 사용자가 입력하는 옵션을 Mapper내부에서 사용할 수 있도록
 * 옵션이 어떤 값으로 입력되었냐에 다라 다른 작업을 할 수 있도록 처리
 * 
 * -D 옵션과 함께 사용자가 입력하는 jobType이라는 옵션에 지정한 값을 추출해서 Mapper에 선언된 변수에 저장.
 */
public class AirOptionMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
	String jobType; // 사용자가 입력하는 옵션 값을 저장하기 위한 변수
	Text outputkey = new Text();
	static final IntWritable one = new IntWritable(1);

	// Mapper실행될 때 한 번만 실행되는 메소드
	@Override
	protected void setup(Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		jobType = context.getConfiguration().get("jobType"); // 환경 설정 정보 넘기는 configuration

	}

	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		if (key.get() > 0) {
			String[] line = value.toString().split(",");
			if (line != null & line.length > 0) {
				if (jobType.equals("departure")) {
					// 출발 지연
					if (!line[15].equals("NA") && Integer.parseInt(line[15]) > 0) {
						outputkey.set(line[1] + "월");
						context.write(outputkey, one);
					}
				} else if (jobType.equals("arrival")) {
					//도착 지연
					if (!line[14].equals("NA") && Integer.parseInt(line[14]) > 0) {
						outputkey.set(line[1] + "월");
						context.write(outputkey, one);
					}
				}

			}
		}
	}
}
