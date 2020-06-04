package poly.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import poly.dto.NewsDTO;
import poly.dto.RankDTO;
import poly.persistance.mongo.INewsMapper;
import poly.service.INewsService;
import poly.util.DateUtil;

@Service("NewsService")
public class NewsService implements INewsService {

	@Resource(name = "NewsMapper")
	private INewsMapper NewsMapper; // MongoDB에 저장할 Mapper

	// 로그 파일 생성 및 로그 출력을 위한 log4j 프레임워크의 자바 객체
	private Logger log = Logger.getLogger(this.getClass());

	@Override
	public int collectNews() throws Exception {

		// 로그 찍기(추후 찍은 로그를 통해 이 함수에 접근했는지 파악하기 용이하다.)
		log.info(this.getClass().getName() + ".collectnews Start!");

		int res = 0;

		List<NewsDTO> pList = new ArrayList<NewsDTO>();

		// 뉴스 가져오는 페이지
		String url = "https://sports.news.naver.com/kfootball/news/index.nhn?isphoto=N";

		// JSOUP 라이브러리를 통해 사이트 접속되면, 그 사이트의 전체 HTML소스 저장할 변수
		Document doc = null; //

		doc = Jsoup.connect(url).get();

		Elements head = doc.select("a.title span");

		for (int i = 0; i < 10; i++) {
	         Element item = head.get(i);
	         System.out.println(item.text());

	         NewsDTO pDTO = new NewsDTO();
	         pDTO.setCollect_time(DateUtil.getDateTime("yyyyMMddhhmmss"));
	         int seq = i + 1;
	         pDTO.setSeq(seq);
	         pDTO.setTitle(item.text());

	         pList.add(pDTO);

	      }
					

	String colNm = "news"; // 생성할 컬렉션명
	// MongoDB Collection 생성하기
	NewsMapper.createCollection(colNm);

	// MongoDB에 데이터저장하기
	NewsMapper.insertNews(pList,colNm);

	// 로그 찍기(추후 찍은 로그를 통해 이 함수에 접근했는지 파악하기 용이하다.)
	log.info(this.getClass().getName()+".collectnews End!");

	return res;
}
	@Override
	public List<NewsDTO> getNews() throws Exception{
		String colNm = "news";
		
		List<NewsDTO> rList = NewsMapper.getNews(colNm);
		if(rList ==null) {
			rList = new ArrayList<NewsDTO>();
		}
		
		return rList;
				
	}

}
