package mapreduce.product.sort;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class PageViewReducer_version2 extends Reducer<MyKey, Text, Text, Text>{
	 //맵에서 나오는 output이 Text이기 때문에 reducer의 인풋을 <MyKey, Text>로 바꿔준다.
	Text resultVal = new Text();
	Text resultKey = new Text(); //String
	@Override
	protected void reduce(MyKey key, Iterable<Text> values,
			Reducer<MyKey, Text, Text, Text>.Context context) throws IOException, InterruptedException {
		int sum =0; // 하나의 상품이 클릭된 총 횟수
		int user_count=0; //클릭한 사용자 수.
	
		String beforeUserId = "";
		
		for(Text value:values) { //values의 값들을 하나하나 value에 담는다.
			String currentUser = value.toString();
			
			if(!beforeUserId.equals(currentUser)) {
				user_count++;
				
			}
			sum++; // 하나의 상품에 접속한 모든 횟수 
			beforeUserId = currentUser;
		}
		//상품 코드가 바뀔 때마다 출력
		resultKey.set(key.getProductId());
		StringBuffer data = new StringBuffer();
		data.append(user_count).append("\t").append(sum);
		resultVal.set(data.toString());
		context.write(resultKey, resultVal);
		
	
	}
	
	
}
