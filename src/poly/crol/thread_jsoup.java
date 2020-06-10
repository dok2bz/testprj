package poly.crol;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import poly.util.DateUtil;

public class thread_jsoup extends Thread {
	public void run() {
		try {
/////////////////////////////////////////////////////////////////////////////////// 뉴스크롤링 예시         

			String url = "http://www.kleague.com/schedule?ch=105835";

			Document doc = Jsoup.connect(url).header("Accept", "text/html, application/xhtml+xml,*/*")
					.header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64; Trident/7.0; rv:11.0) like Gecko")
					.header("Accept-Encoding", "gzip,delate").header("Accept-Language", "ko")
					.header("Connection", "Keep-Alive").get();

			
			Calendar cal = Calendar.getInstance();
			cal.setTime(new Date());
			cal.set(Calendar.DATE,1);
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			
				ArrayList<HashMap<String,String>> sList = new ArrayList<HashMap<String,String>>();
			  
				// 1번 맵
				HashMap<String, String> sch1 = new HashMap<String, String>();
				
				HashMap<String, HashMap<String, String>> result = new HashMap<String, HashMap<String, String>>();
				
				List<String> yyArr = new ArrayList<>();
			
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
				  yyArr.add(yy);
				  
				  
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
				  
				  
				  List<String> matchArr = new ArrayList<>();
				  //경기 단위로 자르기
				  String[] array = match.split(" ");
				  if(array.length == 3) {
					  match1 = array[0]+" "+array[1] + " "+ array[2];
					 System.out.println("1경기:"+match1);
					  matchArr.add(match1);
					 // sch1.put("match", match1);
				  }else if(array.length == 6) {
					  match1 = array[0]+" "+array[1] + " "+ array[2];
					 match2 = array[3]+" "+array[4]+" "+array[5];
						
						  System.out.println("1경기:" + match1);
						  System.out.println("2경기:" + match2);
						 
					  matchArr.add(match1);
					  matchArr.add(match2);
					 // sch1.put("match", match1);
					 // sch1.put("match", match2);
				  }else if(array.length == 9) {
					  match1 = array[0]+" "+array[1]+" "+array[2];
					  match2 = array[3]+" "+array[4]+" "+array[5];
					  match3 = array[6]+" "+array[7]+" "+array[8];
						
						  System.out.println("1경기:" + match1);
						  System.out.println("2경기:" + match2);
						  System.out.println("3경기:" + match3);
						 
					  matchArr.add(match1);
					  matchArr.add(match2);
					  matchArr.add(match3);
					 // sch1.put("match", match1);
					 // sch1.put("match", match2);
					//  sch1.put("match", match3);
				  }else if(array.length == 12) {
					  match1 = array[0]+" "+array[1]+" "+array[2];
					  match2 = array[3]+" "+array[4]+" "+array[5];
					  match3 = array[6]+" "+array[7]+" "+array[8];
					  match4 = array[9]+" "+array[10]+" "+array[11];
						
						  System.out.println("1경기:" + match1);
						  System.out.println("2경기:" + match2);
						  System.out.println("3경기:" + match3);
						  System.out.println("4경기:" + match4);
						 
					  matchArr.add(match1);
					  matchArr.add(match2);
					  matchArr.add(match3);
					  matchArr.add(match4);
					//  sch1.put("match", match1);
					//  sch1.put("match", match2);
					 // sch1.put("match", match3);
					//  sch1.put("match", match4);
					  
				  }
				//  sList.add(sch1);
				 
				 

				  출처: https://data-traveler.tistory.com/10 [클로이의 데이터 여행기]
				  if(!yy.equals("")) {
					  System.out.println("경기 일자:"+yy);
					  
					  
					  
					  for(int a=0;a<Arr.size();a++) {
						  System.out.println("중계:"+Arr.get(a));
						  
						  //matchArr = 경기, Arr = 장소
						 // sch1.put(matchArr.get(a), Arr.get(a));
						 // result.put(yy, sch1);						  
					  }
					  System.out.println("---------------------------");
					  
					 
				  }
				

			  cal.set(Calendar.DATE, i);
			  }
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}