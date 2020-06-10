/*
 * package poly.crol;
 * 
 * import java.security.MessageDigest;
 * 
 * import org.jsoup.Jsoup; import org.jsoup.nodes.Document; import
 * org.jsoup.nodes.Element; import org.jsoup.select.Elements;
 * 
 * import poly.dto.NewsDTO; import poly.util.DateUtil;
 * 
 * public class hash_title extends thread_jsoup { String String
 * url="https://sports.news.naver.com/kfootball/news/index.nhn?isphoto=N";
 * 
 * // JSOUP 라이브러리를 통해 사이트 접속되면, 그 사이트의 전체 HTML소스 저장할 변수 Document doc = null; //
 * 
 * doc=Jsoup.connect(url).get();
 * 
 * Elements head = doc.select("a.title span");
 * 
 * for( int i = 0;i<10;i++) { Element item = head.get(i);
 * System.out.println(item.text());
 * 
 * NewsDTO pDTO = new NewsDTO();
 * pDTO.setCollect_time(DateUtil.getDateTime("yyyyMMddhhmmss")); int seq = i +
 * 1; pDTO.setSeq(seq); pDTO.setTitle(item.text()); }
 * 
 * }
 */