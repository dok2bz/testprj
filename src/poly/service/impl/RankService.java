package poly.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
public List<RankDTO> getRank() throws Exception{
	String colNm = "TeamRank";
	
	List<RankDTO> rList = RankMapper.getRank(colNm);
	if(rList ==null) {
		rList = new ArrayList<RankDTO>();
	}
	
	return rList;
			
}
@Override
public List<String> getEvent() throws Exception {
	
	
	String url = "http://www.kleague.com/schedule?ch=105835";

	Document doc = Jsoup.connect(url).header("Accept", "text/html, application/xhtml+xml,*/*")
			.header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64; Trident/7.0; rv:11.0) like Gecko")
			.header("Accept-Encoding", "gzip,delate").header("Accept-Language", "ko")
			.header("Connection", "Keep-Alive").get();

	
	Calendar cal = Calendar.getInstance();
	cal.setTime(new Date());
	cal.set(Calendar.DATE,1);
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	
	
		ArrayList<String> sList = new ArrayList<>();
	
	  for(int i=2;i<33;i++) {
		  
		  String match1 = null;
		  String match2 = null;
		  String match3 = null;
		  String match4 = null;
		  
		 
		  String date = df.format(cal.getTime());
		  
		  String Document ="div#view_schedule_list table#";
			
		  Document = Document.concat(date);
		  
		  Elements Date = doc.select(Document);
		  
		  
		  //요일
		  String yy = Date.select("thead th").text();
		  
		 
		  
		 // sch1.put("date", yy);
		  
		 
		  //중개
		  String channel = Date.select("tbody td:nth-child(3)").text();
		  
		  String[] channelArr = channel.split(" ");
		  
		  List<String> Arr = new ArrayList<>();
		  
		  for(int s = 0;s<channelArr.length;s++) {
			  Arr.add(channelArr[s]);
		  }
		  if(Arr.contains("G&S")) {
			  int idx = Arr.indexOf("G&S");
			  Arr.remove(idx);
		  }
		  if(Arr.contains("JTBC")) {
			  int idx = Arr.indexOf("JTBC");
			  Arr.set(idx, "JTBC G&S");
		  }

		  
		  //중개 끝
		  
		  //경기
		  String match = Date.select("tbody td.team-match").text(); 
		  
		  
		  //경기 단위로 자르기
		  String[] array = match.split(" ");
		  if(array.length == 3) {
			  match1 = array[0]+" "+array[1] + " "+ array[2];
			 System.out.println("1경기:"+match1);
			 
		  }else if(array.length == 6) {
			  match1 = array[0]+" "+array[1] + " "+ array[2];
			 match2 = array[3]+" "+array[4]+" "+array[5];
				
				  System.out.println("1경기:" + match1);
				  System.out.println("2경기:" + match2);
				 
		  }else if(array.length == 9) {
			  match1 = array[0]+" "+array[1]+" "+array[2];
			  match2 = array[3]+" "+array[4]+" "+array[5];
			  match3 = array[6]+" "+array[7]+" "+array[8];
				
				  System.out.println("1경기:" + match1);
				  System.out.println("2경기:" + match2);
				  System.out.println("3경기:" + match3);
				  
				 
		  }else if(array.length == 12) {
			  match1 = array[0]+" "+array[1]+" "+array[2];
			  match2 = array[3]+" "+array[4]+" "+array[5];
			  match3 = array[6]+" "+array[7]+" "+array[8];
			  match4 = array[9]+" "+array[10]+" "+array[11];
				
				  System.out.println("1경기:" + match1);
				  System.out.println("2경기:" + match2);
				  System.out.println("3경기:" + match3);
				  System.out.println("4경기:" + match4);
				 
			  
		  }

		  
		  if(!yy.equals("")) {
			  System.out.println("경기 일자:"+yy);
			  
			  if(Arr.size() == 1) {
				  String endGame =yy+" "+match1 +" / "+Arr.get(0);
				  sList.add(endGame);
			  }else if(Arr.size() ==2) {
				  String endGame =yy+" "+match1 +" / "+Arr.get(0);
				  String endGame2 =yy+" "+match2 +" / "+Arr.get(1);
				  sList.add(endGame);
				  sList.add(endGame2);
				  
			  }else if(Arr.size() ==3) {
				  String endGame =yy+" "+match1 +" / "+Arr.get(0);
				  String endGame2 =yy+" "+match2 +" / "+Arr.get(1);
				  String endGame3 =yy+" "+match3 +" / "+Arr.get(2);
				  sList.add(endGame);
				  sList.add(endGame2);
				  sList.add(endGame3);
			  }else if(Arr.size() ==4) {
				  String endGame =yy+" "+match1 +" / "+Arr.get(0);
				  String endGame2 =yy+" "+match2 +" / "+Arr.get(1);
				  String endGame3 =yy+" "+match3 +" / "+Arr.get(2);
				  String endGame4 =yy+" "+match4 +" / "+Arr.get(3);
				  sList.add(endGame);
				  sList.add(endGame2);
				  sList.add(endGame3);
				  sList.add(endGame4);
			  }
			  
			  
			  for(int a=0;a<Arr.size();a++) {
				  System.out.println("중계:"+Arr.get(a));						  
				  
				 					  
			  }
			  System.out.println("---------------------------");
			  
			 
		  }
		  

	  cal.set(Calendar.DATE, i);
	  }
	
	return sList;
}

}
