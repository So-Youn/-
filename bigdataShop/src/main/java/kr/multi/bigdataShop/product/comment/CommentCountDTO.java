package kr.multi.bigdataShop.product.comment;

public class CommentCountDTO {
	public String word;
	public String count;
	public CommentCountDTO() {
		
	}
	public CommentCountDTO(String word, String count) {
		super();
		this.word = word;
		this.count = count;
	}
	@Override
	public String toString() {
		return "CommentCountDTO [word=" + word + ", count=" + count + "]";
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	
}
