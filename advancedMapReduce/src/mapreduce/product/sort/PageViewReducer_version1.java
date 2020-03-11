package mapreduce.product.sort;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class PageViewReducer_version1 extends Reducer<MyKey, IntWritable, Text, Text>{
	 
	Text resultVal = new Text();
	Text resultKey = new Text(); //String
	@Override
	protected void reduce(MyKey key, Iterable<IntWritable> values,
			Reducer<MyKey, IntWritable, Text, Text>.Context context) throws IOException, InterruptedException {
		int sum =0; // 하나의 상품이 클릭된 총 횟수
		int user_count=1; //클릭한 사용자 수.
	
		String beforeUserId =key.getUserId();
		
		for(IntWritable value:values) {
			System.out.println(key.toString()); // key..= toString() 
			
			if(beforeUserId.equals(key.getUserId())) {
				
			}
			sum = sum+value.get();
			beforeUserId = key.getUserId();
			
			/*if(!beforeUserId.equals(key.getUserId())) {
				user_count++;
			}*/
		}
		resultKey.set(key.getProductId());
		resultVal.set(sum+" ");
		context.write(resultKey, resultVal);
		
	
	}
	
	
}
