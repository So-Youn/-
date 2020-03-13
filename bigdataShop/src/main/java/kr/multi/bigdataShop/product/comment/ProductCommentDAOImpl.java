package kr.multi.bigdataShop.product.comment;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("productcommentdao")
public class ProductCommentDAOImpl implements ProductCommentDAO{
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public int insert(ProductCommentDTO comment) {
		return sqlSession.insert("kr.multi.bigdataShop.product.comment.insert",comment);
	}

	@Override
	public List<ProductCommentDTO> commentList(String prd_no) {
		return sqlSession.selectList("kr.multi.bigdataShop.product.comment.commentlist",prd_no);
	}

	@Override
	public List<CommentCountDTO> wordList() {
		return sqlSession.selectList("kr.multi.bigdataShop.product.comment.wordlist");
	}
	@Override
	public List<CommentCountDTO> cloudList(){
		return sqlSession.selectList("kr.multi.bigdataShop.product.comment.cloudlist");
	}
}
