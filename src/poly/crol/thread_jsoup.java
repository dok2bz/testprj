package poly.crol;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class thread_jsoup extends Thread {
	public void run()
	{
		try 
		{
			String url = "http://www.kleague.com/rank/get_rank_html?select_league=2&select_year=2020&select_competition=7ZWY64KY7JuQ7YGQIEvrpqzqt7gyIDIwMjA%3D&select_r_detail=&return_type=html";

			// JSOUP 라이브러리를 통해 사이트 접속되면, 그 사이트의 전체 HTML소스 저장할 변수
			Document doc = null; //

			doc = Jsoup.connect(url).get();

			// <div class="service_list_song"> 이 태그 내에서 있는 HTML소스만 element에 저장됨
			Elements rowElements = doc.select("body > div.clearfix.team-score");

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
			
//		      String url = "https://sports.news.naver.com/kfootball/news/index.nhn?isphoto=N";
//
//		      Document doc = Jsoup.connect(url).header("Accept", "text/html, application/xhtml+xml,*/*")
//		            .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64; Trident/7.0; rv:11.0) like Gecko")
//		            .header("Accept-Encoding", "gzip,delate").header("Accept-Language", "ko")
//		            .header("Connection", "Keep-Alive").get();
//
//		      // System.out.println(doc);
//		      Elements head = doc.select("a.title span");
//
//		      /* for(int i = 0; i < head.size(); i++) */
//		      for (int i = 0; i < 10; i++) {
//		         Element item = head.get(i);
//		         System.out.println(item.text());
//			
//		      }
			
			}
			}
			catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
