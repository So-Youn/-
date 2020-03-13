package kr.multi.bigdataShop.product.comment;

import java.util.List;

public interface ProductCommentDAO {
	int insert(ProductCommentDTO comment);
	public List<ProductCommentDTO> commentList(String prd_no);
	public List<CommentCountDTO> wordList();
	public List<CommentCountDTO> cloudList();
}
