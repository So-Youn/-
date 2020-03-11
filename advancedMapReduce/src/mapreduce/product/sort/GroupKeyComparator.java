package mapreduce.product.sort;
//상품 ID로 그룹 피아 될 수 있도록 작성한다.

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class GroupKeyComparator extends WritableComparator{

	protected GroupKeyComparator() { // 기본 생성자
		super(MyKey.class,true);
	}

	@SuppressWarnings("rawtypes")
	@Override
	//MyKey의 compareTo 메소드 호출
	//매개변수로 전달된 두개의 같은 MyKey - key를 가진 것끼리 모은다.
	//셔플 단에서 자동으로 처리...
	public int compare(WritableComparable obj1, WritableComparable obj2) {
		MyKey key1 = (MyKey)obj1;
		MyKey key2 = (MyKey)obj2;
		return key1.getProductId().compareTo(key2.getProductId());
	}
	
	
	

}
