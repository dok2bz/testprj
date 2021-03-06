package poly.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import poly.dto.NewsDTO;
import poly.dto.RankDTO;
import poly.service.INewsService;

@Controller
public class NewsController {
	private Logger log = Logger.getLogger(this.getClass());
	
	
	@Resource(name = "NewsService")
	private INewsService NewsService;
	
	@RequestMapping(value = "news/collectNews")
	@ResponseBody
	public String collectNews(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		log.info("뉴스 컨트롤러 시작");
		
		NewsService.collectNews();
		
		log.info("뉴스 컨트롤러 끝");
		
		return "success";
	}
	
	@RequestMapping(value = "project/getNews")
	@ResponseBody
	public List<NewsDTO> collectNews(HttpServletRequest request, HttpServletResponse response, ModelMap model)
			throws Exception {
		
		log.info(this.getClass().getName()+".get news start");
		List<NewsDTO> nList= NewsService.getNews();
		
		return nList;
	}

}
