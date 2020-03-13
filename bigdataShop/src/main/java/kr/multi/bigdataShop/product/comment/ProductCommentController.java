package kr.multi.bigdataShop.product.comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class ProductCommentController {
	@Autowired
	ProductCommentService service;
	
	@RequestMapping(value="/comment/write.do",method=RequestMethod.POST)
	public String Comment(ProductCommentDTO comment) {
		service.insert(comment);
		return "redirect:/product/read.do?prd_no="+comment.getPrd_no();
	}
	@RequestMapping("/comment/result.do")
	public ModelAndView ShowComment() {
		ModelAndView mav = new ModelAndView();
		List<CommentCountDTO> wordlist =service.wordlist();
		List<CommentCountDTO> cloudlist = service.cloudList();
		System.out.println(wordlist);
		mav.addObject("wordlist",wordlist);
		mav.addObject("cloudlist",cloudlist);
		mav.setViewName("comment/result");
		return mav;
	}
}
