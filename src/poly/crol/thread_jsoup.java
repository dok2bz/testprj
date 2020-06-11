package poly.crol;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


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
						  String endGame =yy+" "+match1 +Arr.get(0);
						  sList.add(endGame);
					  }else if(Arr.size() ==2) {
						  String endGame =yy+" "+match1 +Arr.get(0);
						  String endGame2 =yy+" "+match2 +Arr.get(1);
						  sList.add(endGame);
						  sList.add(endGame2);
						  
					  }else if(Arr.size() ==3) {
						  String endGame =yy+" "+match1 +Arr.get(0);
						  String endGame2 =yy+" "+match2 +Arr.get(1);
						  String endGame3 =yy+" "+match3 +Arr.get(2);
						  sList.add(endGame);
						  sList.add(endGame2);
						  sList.add(endGame3);
					  }else if(Arr.size() ==4) {
						  String endGame =yy+" "+match1 +Arr.get(0);
						  String endGame2 =yy+" "+match2 +Arr.get(1);
						  String endGame3 =yy+" "+match3 +Arr.get(2);
						  String endGame4 =yy+" "+match4 +Arr.get(3);
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
			  
			  for(int a=0;a<sList.size();a++) {
				  System.out.println("sList "+a+" : "+sList.get(a));
			  }
			  

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}