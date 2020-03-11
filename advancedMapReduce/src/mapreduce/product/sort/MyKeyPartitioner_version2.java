package mapreduce.product.sort;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class MyKeyPartitioner_version2 extends Partitioner<MyKey, Text>{
	//<MyKey, IntWritable>가 mapper의 outputkey value와 똑같아야 한다.

	@Override
	public int getPartition(MyKey key, Text value, int numpartitions) {
		
		return key.getProductId().hashCode() % numpartitions;
	}

}
