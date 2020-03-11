package mapreduce.product.sort;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableUtils;

public class MyKey implements WritableComparable<MyKey>{
	private String productId;
	private String userId;
	private Long mapkey;
	
	public MyKey() {
	}
	
	public MyKey(String productId, String userId) {
		super();
		this.productId = productId;
		this.userId = userId;
	}

	public MyKey(String productId, String userId, Long mapkey) {
		super();
		this.productId = productId;
		this.userId = userId;
		this.mapkey = mapkey;
	}
	
	@Override
	public String toString() {
		return (new StringBuffer()).append(productId).append(userId).toString();
	}
	
	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Long getMapkey() {
		return mapkey;
	}

	public void setMapkey(Long mapkey) {
		this.mapkey = mapkey;
	}

	@Override
	public void write(DataOutput out) throws IOException {
	WritableUtils.writeString(out, productId);
	WritableUtils.writeString(out, userId);
	
	}
	@Override
	public void readFields(DataInput in) throws IOException {
		productId = WritableUtils.readString(in);
		userId = WritableUtils.readString(in);
		
	}
	@Override
	public int compareTo(MyKey obj) {
		int result = productId.compareTo(obj.productId);
		if(result==0) { //productId가 같은 상태
			result = userId.compareTo(obj.userId);
		}
		return result;
	}

}
