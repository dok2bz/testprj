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

import poly.dto.Rank2DTO;
import poly.dto.RankDTO;

import poly.persistance.mongo.IRankMapper;
import poly.service.IRankService;
import poly.util.DateUtil;

@Service("RankService")
public class RankService implements IRankService {

	@Resource(name = "RankMapper")
	private IRankMapper RankMapper; // MongoDB에 저장할 Mapper

	// 로그 파일 생성 및 로그 출력을 위한 log4j 프레임워크의 자바 객체
	private Logger log = Logger.getLogger(this.getClass());

	@Override
	public int collectRank() throws Exception {

		// 로그 찍기(추후 찍은 로그를 통해 이 함수에 접근했는지 파악하기 용이하다.)
		log.info(this.getClass().getName() + ".collectRankRank Start!");

		int res = 0;

		List<RankDTO> pList = new ArrayList<RankDTO>();

		// 리그순위 가져오는 페이지
		String url = "http://www.kleague.com/rank?";

		// JSOUP 라이브러리를 통해 사이트 접속되면, 그 사이트의 전체 HTML소스 저장할 변수
		Document doc = null; //

		doc = Jsoup.connect(url).get();

		// <div class="service_list_song"> 이 태그 내에서 있는 HTML소스만 element에 저장됨
		Elements rowElements = doc.select("div.data-body > table.table.league1 > tbody > tr");

		for(Element row : rowElements)
		{
			Elements tdElements = row.getElementsByTag("td");
						
			int rank = Integer.valueOf(tdElements.get(0).text());
			String name = tdElements.get(1).text();
			int playNm = Integer.valueOf(tdElements.get(2).text());
			int score = Integer.valueOf(tdElements.get(3).text());
			int win = Integer.valueOf(tdElements.get(4).text());
			int draw = Integer.valueOf(tdElements.get(5).text());
			int lose = Integer.valueOf(tdElements.get(6).text());
			int get = Integer.valueOf(tdElements.get(7).text());
			int miss = Integer.valueOf(tdElements.get(8).text());
			int diff = Integer.valueOf(tdElements.get(9).text());
			
			
			System.out.println("rank :" + rank);
			System.out.println("name :" + name);
			System.out.println("playNm :" + playNm);
			System.out.println("score :" + score);
			System.out.println("win :" + win);
			System.out.println("draw :" + draw);
			System.out.println("lose :" + lose);
			System.out.println("get :" + get);
			System.out.println("miss :" + miss);
			System.out.println("diff :" + diff);
			
			
			tdElements = null;
			
			
			RankDTO pDTO = new RankDTO();
			pDTO.setCollect_time(DateUtil.getDateTime("yyyyMMddhhmmss"));
			pDTO.setDiff(diff);
			pDTO.setDraw(draw);
			pDTO.setGet(get);
			pDTO.setLose(lose);
			pDTO.setMiss(miss);
			pDTO.setName(name);
			pDTO.setPlayNm(playNm);
			pDTO.setRank(rank);
			pDTO.setScore(score);
			pDTO.setWin(win);
			
			pList.add(pDTO);
			
		}
					

	String colNm = "TeamRank"; // 생성할 컬렉션명
	// MongoDB Collection 생성하기
	RankMapper.createCollection(colNm);

	// MongoDB에 데이터저장하기
	RankMapper.insertRank(pList,colNm);

	// 로그 찍기(추후 찍은 로그를 통해 이 함수에 접근했는지 파악하기 용이하다.)
	log.info(this.getClass().getName()+".collectRankRank End!");

	return res;
	
}
	@Override
	public int collectRank2() throws Exception {

		// 로그 찍기(추후 찍은 로그를 통해 이 함수에 접근했는지 파악하기 용이하다.)
		log.info(this.getClass().getName() + ".collectRankRank Start!");

		int res = 0;

		List<Rank2DTO> pList = new ArrayList<Rank2DTO>();

		// 리그순위 가져오는 페이지
		String url = "http://www.kleague.com/rank?";

		// JSOUP 라이브러리를 통해 사이트 접속되면, 그 사이트의 전체 HTML소스 저장할 변수
		Document doc = null; //

		doc = Jsoup.connect(url).get();

		// <div class="service_list_song"> 이 태그 내에서 있는 HTML소스만 element에 저장됨
		Elements rowElements = doc.select("div.data-body > table.table.league2 > tbody > tr");

		for(Element row : rowElements)
		{
			Elements tdElements = row.getElementsByTag("td");
						
			int rank = Integer.valueOf(tdElements.get(0).text());
			String name = tdElements.get(1).text();
			int playNm = Integer.valueOf(tdElements.get(2).text());
			int score = Integer.valueOf(tdElements.get(3).text());
			int win = Integer.valueOf(tdElements.get(4).text());
			int draw = Integer.valueOf(tdElements.get(5).text());
			int lose = Integer.valueOf(tdElements.get(6).text());
			int get = Integer.valueOf(tdElements.get(7).text());
			int miss = Integer.valueOf(tdElements.get(8).text());
			int diff = Integer.valueOf(tdElements.get(9).text());
			
			
			System.out.println("rank :" + rank);
			System.out.println("name :" + name);
			System.out.println("playNm :" + playNm);
			System.out.println("score :" + score);
			System.out.println("win :" + win);
			System.out.println("draw :" + draw);
			System.out.println("lose :" + lose);
			System.out.println("get :" + get);
			System.out.println("miss :" + miss);
			System.out.println("diff :" + diff);
			
			
			tdElements = null;
			
			
			Rank2DTO pDTO = new Rank2DTO();
			pDTO.setCollect_time(DateUtil.getDateTime("yyyyMMddhhmmss"));
			pDTO.setDiff(diff);
			pDTO.setDraw(draw);
			pDTO.setGet(get);
			pDTO.setLose(lose);
			pDTO.setMiss(miss);
			pDTO.setName(name);
			pDTO.setPlayNm(playNm);
			pDTO.setRank(rank);
			pDTO.setScore(score);
			pDTO.setWin(win);
			
			pList.add(pDTO);
			
		}
					

	String colNm = "TeamRank2"; // 생성할 컬렉션명
	// MongoDB Collection 생성하기
	RankMapper.createCollection2(colNm);

	// MongoDB에 데이터저장하기
	RankMapper.insertRank2(pList,colNm);

	// 로그 찍기(추후 찍은 로그를 통해 이 함수에 접근했는지 파악하기 용이하다.)
	log.info(this.getClass().getName()+".collectRankRank End!");

	return res;
	}
@Override
public List<RankDTO> getRank() throws Exception{
	String colNm = "TeamRank";
	
	List<RankDTO> rList = RankMapper.getRank(colNm);
	if(rList ==null) {
		rList = new ArrayList<RankDTO>();
	}
	
	return rList;
			
}
@Override
public List<Rank2DTO> getRank2() throws Exception{
	String colNm = "TeamRank2";
	
	List<Rank2DTO> rList = RankMapper.getRank2(colNm);
	if(rList ==null) {
		rList = new ArrayList<Rank2DTO>();
	}
	
	return rList;
			
}
}
