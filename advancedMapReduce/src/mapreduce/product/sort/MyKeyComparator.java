package mapreduce.product.sort;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

//복합기.
//상품 ID로 정렬되고 다시 상품 ID가 동일한 데이터는 UserID 별로 정렬될 수 있도록 처리한다.
public class MyKeyComparator extends WritableComparator {

	protected MyKeyComparator() {
		super(MyKey.class,true);
	}
	@SuppressWarnings("rawtypes")
	@Override
	public int compare(WritableComparable obj1, WritableComparable obj2) {
		MyKey key1 = (MyKey)obj1;
		MyKey key2 = (MyKey)obj2;
		return key1.compareTo(key2);
	}
	
	
	
	
}
