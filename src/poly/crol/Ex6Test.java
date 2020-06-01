package poly.crol;



import java.io.IOException;



import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;

import org.jsoup.nodes.Element;

import org.jsoup.select.Elements;



public class Ex6Test {



	public static void main(String[] args) throws IOException {

		// TODO Auto-generated method stub



		String urls="https://sports.news.naver.com/kfootball/news/index.nhn?isphoto=N";

		

		Document news=Jsoup.connect(urls).get();

		

		Elements news_url=news.select("div.aside_rank_news>ul>li>a.title");

		                                    

		for(Element element:news_url)

		{

			

			String url=element.attr("href");

			System.out.println(url);

			if(url.contains("sports.news.naver.com"))

			

		{

			Document doc=Jsoup.connect(url).get();

			

			Elements body=doc.select("div#_ranking_news_tab_selector");

			Elements title=doc.select("a.title");

			

			String content=body.text();

			String newstitle=title.text();

			

			System.out.println("제목:"+newstitle);

			System.out.println("내용:"+content);

			

		}



	

		}

	

	}



}