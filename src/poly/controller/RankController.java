package poly.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import poly.service.IRankService;

@Controller
public class RankController {
	private Logger log = Logger.getLogger(this.getClass());
	
	
	@Resource(name = "RankService")
	private IRankService rankService;
	
	@RequestMapping(value = "rank/collectRank")
	@ResponseBody
	public String collectRank(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		log.info("랭크 컨트롤러 시작");
		
		rankService.collectRank();
		
		log.info("랭크 컨트롤러 끝");
		
		return "success";
	}
	@RequestMapping(value = "rank/collectRank2")
	@ResponseBody
	public String collectRank2(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		log.info("랭크 컨트롤러 시작");
		
		rankService.collectRank2();
		
		log.info("랭크 컨트롤러 끝");
		
		return "success2";
	}

}
