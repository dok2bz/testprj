package poly.crol;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.apache.http.client.ClientProtocolException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class thread_jsoup extends Thread {
		
	private static final char[] jpg = null;

	public static void main(String[] args) throws ClientProtocolException, IOException{
		
		Document doc = Jsoup.connect("https://sports.news.naver.com/news.nhn?oid=139&aid=0002133813").get();
		String folder = doc.title();
		Element element = doc.select("span.end_photo_org").get(0);
		Elements img = element.select("img");
		int page = 0;
		for(Element e : img) {
			String url = e.getElementsByAttribute("src").attr("src");
			
			URL imgUrl = new URL(url);
			BufferedImage jpg = ImageIO.read(imgUrl);
			File file = new File("경로"+folder+"\\"+page+".jpg");
			ImageIO.write(jpg,"jpg",file);
			page+=1;
		}
		System.out.println(img);
		System.out.println(jpg);
	}
	
	}

