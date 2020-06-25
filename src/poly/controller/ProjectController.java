package poly.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import poly.dto.NewsAllDTO;
import poly.dto.NewsDTO;
import poly.dto.RankDTO;
import poly.service.INewsService;
import poly.service.IRankService;
import poly.service.impl.NewsService;
import poly.util.CmmUtil;



/*
 * Controller 선언해야만 Spring 프레임워크에서 Controller인지 인식 가능
 * 자바 서블릿 역할 수행
 * */
@Controller
public class ProjectController {
	private Logger log = Logger.getLogger(this.getClass());

	@Resource(name = "RankService")
	private IRankService rankservice;
	
	@Resource(name = "NewsService")
	private INewsService NewsService;

	@RequestMapping(value = "project/index")
	public String getMovieInfoFromWEB(HttpServletRequest request, HttpServletResponse response, ModelMap model)
			throws Exception {
		
		List<NewsDTO> nList= NewsService.getNews();
		
		if (nList==null) {
			nList = new ArrayList<NewsDTO>();
		}
		model.addAttribute("nList",nList);

		List<RankDTO>rList= rankservice.getRank();
		if (rList==null) {
			rList = new ArrayList<RankDTO>();
		}
		model.addAttribute("rList",rList);
		
		List<String> sList = rankservice.getEvent();
		
		model.addAttribute("sList",sList);
		
		ArrayList<String> iList = NewsService.getImg(nList);
		
		model.addAttribute("iList",iList);
		
		return "/project/index";
	}

	@RequestMapping(value="searchNews")
	public String searchNews(HttpSession session, HttpServletRequest request, HttpServletResponse response,
	         Model model) throws Exception {



	      try {
	         String keyword = CmmUtil.nvl(request.getParameter("query"));


	        List<NewsAllDTO> nList = NewsService.selectNews(keyword);
	        model.addAttribute("nList",nList);  

	      } catch (Exception e) {
	         log.info(e.toString());
	         e.printStackTrace();

	      }
	      
	   
	      	
	      
	      return "/project/news-list";
	      
	   }
	@RequestMapping(value = "project/getRank")
	@ResponseBody
	public List<RankDTO> collectRank(HttpServletRequest request, HttpServletResponse response, ModelMap model)
			throws Exception {
		
		log.info(this.getClass().getName()+".get rank start");
		List<RankDTO>rList= rankservice.getRank();		
		
		return rList;
	}
	
	@RequestMapping(value = "project/test")
	public String test(HttpServletRequest request, HttpServletResponse response, ModelMap model)
			throws Exception {
		List<RankDTO>rList= rankservice.getRank();
		if (rList==null) {
			rList = new ArrayList<RankDTO>();
		}
		model.addAttribute("rList",rList);
		return "/project/test";
	}

	@RequestMapping(value = "project/news-list")
	public String news(HttpServletRequest request, HttpServletResponse response, ModelMap model)
			throws Exception {
		
		List<NewsAllDTO> naList= NewsService.getNewsAll();
		
		if (naList==null) {
			naList = new ArrayList<NewsAllDTO>();
		}
		model.addAttribute("naList",naList);


		
		return "/project/news-list";
	}
}



