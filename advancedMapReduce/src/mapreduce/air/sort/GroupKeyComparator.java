package mapreduce.air.sort;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class GroupKeyComparator extends WritableComparator {

	protected GroupKeyComparator() { //기본 생성자
		super(CustomKey.class,true);
		}

	@Override
	public int compare(WritableComparable obj1, WritableComparable obj2) {
		CustomKey key1 = (CustomKey)obj1;
		CustomKey key2 = (CustomKey)obj2;
		return key1.getYear().compareTo(key2.getYear());
	}

}
