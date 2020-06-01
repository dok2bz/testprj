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

import poly.dto.RankDTO;
import poly.service.IRankService;



/*
 * Controller 선언해야만 Spring 프레임워크에서 Controller인지 인식 가능
 * 자바 서블릿 역할 수행
 * */
@Controller
public class ProjectController {
	private Logger log = Logger.getLogger(this.getClass());

	@Resource(name = "RankService")
	private IRankService rankservice;

	@RequestMapping(value = "project/index")
	public String getMovieInfoFromWEB(HttpServletRequest request, HttpServletResponse response, ModelMap model)
			throws Exception {

//		log.info(this.getClass().getName() + ".getMovieInfoFromWEB start!");
//
//		int res = movieService.getMovieInfoFromWEB();
//
//		//크롤링 결과를 넣어주기
//		model.addAttribute("res", String.valueOf(res));
//		
//		log.info(this.getClass().getName() + ".getMovieInfoFromWEB end!");
		
		return "/project/index";
	}
	@RequestMapping(value = "project/test")
	public String test(HttpServletRequest request, HttpServletResponse response, ModelMap model)
			throws Exception {

		return "/project/test";
	}
	@RequestMapping(value = "project/getRank")
	@ResponseBody
	public List<RankDTO> collectRank(HttpServletRequest request, HttpServletResponse response, ModelMap model)
			throws Exception {
		
		log.info(this.getClass().getName()+".get rank start");
		List<RankDTO>rList= rankservice.getRank();
		

		
		return rList;
	}

}



