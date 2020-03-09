package mapreduce.air.sort;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class CustomKeyComparator extends WritableComparator {

	protected CustomKeyComparator() { //기본 생성자
		super(CustomKey.class,true);
		}
	
	@SuppressWarnings("rawtypes")
	//warning이 뜨는 이유 : WritableComparable의 타입이 정확하지 않기 때문에  warning 발생하는데, 
	//이 타입에 대한 부분을 무시하고 체크하지 않고 처리하겠다는 의미다.
	@Override
	public int compare(WritableComparable obj1, WritableComparable obj2) {
		CustomKey key1 = (CustomKey)obj1;
		CustomKey key2 = (CustomKey)obj2;
		return key1.compareTo(key2);
	}

}
