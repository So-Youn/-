package spring.data.mongodb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import spring.data.mongodb.dto.ScoreDTO;
import spring.data.mongodb.service.ScoreMongoService;

@Controller
public class ScoreFindController {
	@Autowired
	ScoreMongoService service;
	
	@RequestMapping(value="/score/search",method=RequestMethod.GET)
	public String searchPage() {
		return "search";
	}
	@RequestMapping(value="/score/search",method=RequestMethod.POST)
	public ModelAndView search(String key,String opr,String value) {
		//search결과를 seach.jsp에서 출력하기
		List<ScoreDTO> mongolist = service.findCriteria(key+","+opr,value);
		return new ModelAndView("list","mongolist", mongolist);
	}
	
	
	//update와 read를 위해 필요한 컨트롤러 
	@RequestMapping("score/detail")
	public ModelAndView findById(String key, String value,String action) {
		//mongodb는 key,value로 저장되기 때문에 key, value 모두 받아야 한다.
		ScoreDTO doc = service.findById(key, value);
		String view="";
		if(action.equals("READ")) {
			view = "mongo_detail";
		}else {
			view ="mongo_update";
		}
		return new ModelAndView(view, "document", doc);
	}
	




}
