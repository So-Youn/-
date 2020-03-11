package mapreduce.product.sort;
//상품 ID로 partition 할 수 있도록 작성한다.
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Partitioner;

public class MyKeyPartitioner extends Partitioner<MyKey, IntWritable>{
	//<MyKey, IntWritable>가 mapper의 outputkey value와 똑같아야 한다.

	@Override
	public int getPartition(MyKey key, IntWritable value, int numpartitions) {
		
		return key.getProductId().hashCode() % numpartitions;
	}

}
