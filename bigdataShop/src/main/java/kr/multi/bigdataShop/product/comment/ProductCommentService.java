package kr.multi.bigdataShop.product.comment;

import java.util.List;

public interface ProductCommentService {
	int insert(ProductCommentDTO comment);
	List<ProductCommentDTO> commentlist(String prd_no);
	List<CommentCountDTO> wordlist();
	List<CommentCountDTO> cloudList();
}
