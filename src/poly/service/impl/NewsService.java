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

import poly.dto.NewsAllDTO;
import poly.dto.NewsDTO;
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
		Elements url2 = doc.select("a.title");
		String Rurl = "https://sports.news.naver.com/";

		for (int i = 0; i < 10; i++) {
			Element item = head.get(i);
			Element urll = url2.get(i);
			System.out.println(item.text());

			NewsDTO pDTO = new NewsDTO();
			pDTO.setCollect_time(DateUtil.getDateTime("yyyyMMddhhmmss"));
			int seq = i + 1;
			pDTO.setSeq(seq);
			pDTO.setTitle(item.text());
			pDTO.setImg(Rurl + urll.getElementsByAttribute("href").attr("href").substring(11).replace("/read.", "."));

			pList.add(pDTO);

		}

		String colNm = "news"; // 생성할 컬렉션명
		
		String colNm2 = "newsAll";
		
		
		// MongoDB Collection 생성하기
		NewsMapper.createCollection(colNm);
		
		NewsMapper.createCollection(colNm2);
		

		// MongoDB에 데이터저장하기
		NewsMapper.insertNews(pList, colNm);
		
		List<NewsAllDTO> nList = NewsMapper.getNewsAll(colNm2);
		if (nList == null) {
			nList = new ArrayList<NewsAllDTO>();
		}
		
		int nSize = nList.size();
		
		if(nSize == 0) {
			NewsMapper.insertNews(pList, colNm2);
		}else {
			
			ArrayList<String> titleAll = new ArrayList<>();
			
			for(int i=0;i<nSize;i++) {
				
				titleAll.add(nList.get(i).getTitle());
			}
			
			
			
			List<NewsAllDTO> naList = new ArrayList<>();
			
			NewsAllDTO naDTO = new NewsAllDTO();
			
			for(int a=0;a<nList.size();a++) {
				String title = nList.get(a).getTitle();
				if(titleAll.contains(title)) {
					continue;
				}else {
					naDTO.setCollect_time(nList.get(a).getCollect_time());
					naDTO.setSeq(nList.get(a).getSeq());
					naDTO.setTitle(nList.get(a).getTitle());
					naDTO.setImg(nList.get(a).getImg());
					
					naList.add(naDTO);
				}
				
			}
			
			// MongoDB에 데이터저장하기
			NewsMapper.insertNewsAll(naList, colNm2);
			
		}
		
		

		// 로그 찍기(추후 찍은 로그를 통해 이 함수에 접근했는지 파악하기 용이하다.)
		log.info(this.getClass().getName() + ".collectnews End!!!");

		return res;
	}

	@Override
	public List<NewsDTO> getNews() throws Exception {
		String colNm = "news";

		List<NewsDTO> nList = NewsMapper.getNews(colNm);
		if (nList == null) {
			nList = new ArrayList<NewsDTO>();
		}

		ArrayList<String> iList = new ArrayList<String>();

		for (int i = 0; i < 3; i++) {
			String imgUrl = nList.get(i).getImg();

			iList.add(imgUrl);
		}

		return nList;

	}
	
	@Override
	public List<NewsAllDTO> getNewsAll() throws Exception {
		String colNm2 = "newsAll";

		List<NewsAllDTO> naList = NewsMapper.getNewsAll(colNm2);
		if (naList == null) {
			naList = new ArrayList<NewsAllDTO>();
		}

		return naList;

	}
	

	@Override
	public ArrayList<String> getImg(List<NewsDTO> nList) throws Exception {

		ArrayList<String> iList = new ArrayList<String>();

		for (int i = 0; i < 3; i++) {
			String imgUrl = nList.get(i).getImg();

			try {

				String url = imgUrl;

				
				Document doc = Jsoup.connect(url).header("Accept", "text/html, application/xhtml+xml,*/*")
						.header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64; Trident/7.0; rv:11.0) like Gecko")
						.header("Accept-Encoding", "gzip,delate").header("Accept-Language", "ko")
						.header("Connection", "Keep-Alive").get();

				Elements img = doc.select("div.news_end span img");

				String imgSrc = img.get(0).attr("src");

				System.out.println(imgSrc);
				
				iList.add(imgSrc);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		return iList;

	}

	@Override
	public List<NewsAllDTO> selectNews(String keyword) throws Exception {
		
		int res = 0;
	
		
		

		List<NewsAllDTO> nList = NewsMapper.selectNewsAll(keyword);
		if (nList == null) {
			nList = new ArrayList<NewsAllDTO>();
		}
		
		if(nList.size()!=0) {
			res = 1;
		}
		
		
		return nList;
	}

}
