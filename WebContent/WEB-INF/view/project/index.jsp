<%@page import="poly.util.CmmUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="poly.dto.NewsDTO"%>
<%@page import="poly.dto.RankDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    List<NewsDTO> nList = (List<NewsDTO>)request.getAttribute("nList");
    
    if (nList==null) {
		nList = new ArrayList<NewsDTO>();
	}  
   
    List<RankDTO> rList = (List<RankDTO>)request.getAttribute("rList");
    
    if (rList==null) {
		rList = new ArrayList<RankDTO>();
	} 
    
	List<String> iList = (List<String>)request.getAttribute("iList");
    
    if (iList==null) {
		iList = new ArrayList<String>();
	} 
    
    List<String> sList = (List<String>)request.getAttribute("sList");
    
    if (sList==null) {
		sList = new ArrayList<String>();
	}
     
    String user_name = (String) session.getAttribute("user_name");
    String user_mail = (String) session.getAttribute("user_mail");
    		
    
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--
author: Boostraptheme
author URL: https://boostraptheme.com
License: Creative Commons Attribution 4.0 Unported
License URL: https://creativecommons.org/licenses/by/4.0/
-->


<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Business Bootstrap Responsive Template</title>
    <link rel="shortcut icon" href="/theme/img/favicon.ico">
<script
   src="https://cdnjs.cloudflare.com/ajax/libs/socket.io/2.3.1/socket.io.js"></script>
   <script
   src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <!-- Global Stylesheets -->
    <link href="https://fonts.googleapis.com/css?family=Roboto+Condensed:300,300i,400,400i,700,700i" rel="stylesheet">
    <link href="/theme/css/bootstrap/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="font-awesome-4.7.0//theme/css/font-awesome.min.css">
    <link rel="stylesheet" href="/theme/css/animate/animate.min.css">
    <link rel="stylesheet" href="/theme/css/owl-carousel/owl.carousel.min.css">
    <link rel="stylesheet" href="/theme/css/owl-carousel/owl.theme.default.min.css">
    	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="/theme/css/style.css">
  </head>

  <body id="page-top">

<!--====================================================
                         HEADER
======================================================--> 

    <header>


      
      <!-- Navbar -->
      <nav class="navbar navbar-expand-lg navbar-light" id="mainNav" data-toggle="affix">
        <div class="container">
          <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li  data-target="#home"><a class="nav-link smooth-scroll" href="#home">Home</a></li>
                <li  data-target="#comp-offer"><a class="nav-link smooth-scroll" href="#comp-offer">News</a></li> 
                <li  data-target="#service"><a class="nav-link smooth-scroll" href="#community">Community</a></li> 
                <li  data-target="#service"><a class="nav-link smooth-scroll" href="#service-h">Ranking</a></li> 
                
            <%
                if(session.getAttribute("user_name")==null){
                	%>
                <li  data-target=""><a class="nav-link smooth-scroll" onclick="location.href='https://kauth.kakao.com/oauth/authorize?client_id=c043a6a6eaa127bd1f5acdd060afd9ec&redirect_uri=http://localhost:8080/kakaologin.do&response_type=code'" >Login</a></li> 
               
                
                  <%
                }else{%>
                  <li  data-target=""><a class="nav-link smooth-scroll" href="/kakaologout.do">Logout</a></li>
                  <% 
                  }
                  %>
                 
                 
                 
              
                <li>
                  <div class="top-menubar-nav">
                    <div class="topmenu ">
                      <div class="container">
                        <div class="row">
                          <div class="col-md-9">
                            <ul class="list-inline top-contacts">
                              <li>
                                <i class="fa fa-envelope"></i> Email: <a href="mailto:info@htmlstream.com">info@htmlstream.com</a>
                              </li>
                              <li>
                                <i class="fa fa-phone"></i> Hotline: (1) 396 4587 99
                              </li>
                            </ul>
                          </div> 

                        </div>
                      </div>
                    </div> 
                  </div>
                </li>
            </ul>  
          </div>
        </div>
      </nav>
    </header> 


<!--====================================================
                         HOME
======================================================-->
    <section id="home">
      <div id="carousel" class="carousel slide carousel-fade" data-ride="carousel"> 
        <!-- Carousel items -->
        <div class="carousel-inner">
            <div class="carousel-item active slides">
              <div class="overlay"></div>
              <div class="slide-1"></div>
                <div class="hero ">
                  <hgroup class="">
                      <h1>K리그 <span ><a href="" class="typewrite" data-period="2000" data-type='[ " 두둥등장" ]'>
                        <span class="wrap"></span></a></span> </h1>         
                      <h3>The next big idea is waiting for its next big changer</h3>
                  </hgroup>
                  <button class="btn btn-general btn-green wow fadeInUp" role="button"><a href="news-list.do" color="white">뉴스 보러가기</a></button>
                </div>           
            </div> 
        </div> 
      </div> 
    </section> 

    <section id="comp-offer">
      <div class="container-fluid">
        <div class="row">
          <div class="col-md-3 col-sm-6  desc-comp-offer wow fadeInUp" data-wow-delay="0.2s" >
            <h2>Latest News</h2>
            
            <div class="heading-border-light" ></div> 

          </div>
          <div class="col-md-3 col-sm-6 desc-comp-offer wow fadeInUp" data-wow-delay="0.4s">
            <div class="desc-comp-offer-cont" >
              <div class="thumbnail-blogs">
                  <div class="">
                    <i class="fa fa-chain"></i>
                  </div><a href ="<%=CmmUtil.nvl(nList.get(0).getImg())%>" target="_blank" style="color:black;" >
                  <img src="<%=CmmUtil.nvl(iList.get(0)) %>" class="img-fluid" alt="..." style="width:500px;height:350px;">
                  </a>
              </div>
                 
              <h3><a href ="<%=CmmUtil.nvl(nList.get(0).getImg())%>" target="_blank" style="color:black;" ><%=CmmUtil.nvl(nList.get(0).getTitle())%></a></h3>
           
              <a href="#"><i class="fa fa-arrow-circle-o-right"></i> </a>
            </div>
          </div>
          <div class="col-md-3 col-sm-6 desc-comp-offer wow fadeInUp" data-wow-delay="0.6s">
            <div class="desc-comp-offer-cont">
              <div class="thumbnail-blogs">
                  <div class="">
                    <i class="fa fa-chain"></i>
                  </div>
                  <a href ="<%=CmmUtil.nvl(nList.get(1).getImg())%>" target="_blank" style="color:black;" >
                  <img src="<%=CmmUtil.nvl(iList.get(1)) %>" class="img-fluid" alt="..." style="width:500px;height:350px;">
                  </a>
              </div>
              <h3><a href ="<%=CmmUtil.nvl(nList.get(1).getImg())%>" target="_blank" style="color:black;" ><%=CmmUtil.nvl(nList.get(1).getTitle())%></a></h3>
              <a href="#"><i class="fa fa-arrow-circle-o-right"></i> </a>
            </div>
          </div>
          <div class="col-md-3 col-sm-6 desc-comp-offer wow fadeInUp" data-wow-delay="0.8s">
            <div class="desc-comp-offer-cont">
              <div class="thumbnail-blogs">
                  <div class="">
                    <i class="fa fa-chain"></i>
                  </div>
                  <a href ="<%=CmmUtil.nvl(nList.get(2).getImg())%>" target="_blank" style="color:black;" >
                  <img src="<%=CmmUtil.nvl(iList.get(2)) %>" class="img-fluid" alt="..." style="width:500px;height:350px;">
                  </a>
              </div>
              <h3><a href ="<%=CmmUtil.nvl(nList.get(2).getImg())%>" target="_blank" style="color:black;" ><%=CmmUtil.nvl(nList.get(2).getTitle())%></a></h3>
              <a href="#"><i class="fa fa-arrow-circle-o-right"></i> </a>
            </div>
          </div>
        </div>
      </div>
    </section>
    <hr>
     
     <section id="community">
      <div class="container-fluid">
        <div class="row">
          <div class="col-md-3 col-sm-6  desc-comp-offer wow fadeInUp" data-wow-delay="0.2s" >
            <h2>Community</h2>
            
            <div class="heading-border-light" ></div> 

<div>
                  <fieldset>
                     <div id="messageWindow" class="btn btn-dark" style="border:2px solid black;display: block;                         
                         height:400px; width:1300px; margin-left:500px;                     
                           overflow-y:scroll;
                         scroll-behavior:smooth;"></div>
                     <br /> 
                     <div class="scrollbar scrollbar-black bordered-black square thin">
  <div class="force-overflow"></div>
</div>
                     <input id="inputMessage" type="text" / style="margin-left:900px; width:500px;"> 
                     <input type="submit" class="btn btn-dark" onclick="logincheck2()" value="보내기" style="margin-left:1130px; margin-top:15px;">
                        
                  </fieldset>
               </div>
<script>
      var chat = io('http://localhost:3000/');
      console.log(chat);
      let user_name = "<%=user_name%>";
      const user_mail = "<%=user_mail%>";
      
      function send() {         
         
         chat.emit("login", {
               name: user_name,
               userid: user_mail
          });
         chat.emit("chat",{
              msg: $('#inputMessage').val()
         });
      }
      
      function logincheck2(){
         
         if (user_name == "null"){
            user_name = "익명";
            
            send();
            $('#inputMessage').val('');
            
         }else{            
            send();
            $('#inputMessage').val('');
         }
      }
      
      
      chat.on("s2c chat", function(data){
         var time = new Date();
         var timeStr = time.toLocaleTimeString();
         document.getElementById('messageWindow').innerHTML = "<div>"+"[ "+timeStr+ " ] " + data.from.name + " 님이 보낸 채팅 : " + data.msg + "</div>" + "<br/>" + document.getElementById('messageWindow').innerHTML;
      })
      
      
      
   </script>
    
          </div>
          
          </div>
        </div>
      
    </section>
    <hr>
<section id="service-h">
        <div class="container-fluid">
          <div class="row" >
            <div class="col-md-6" >
              <div class="service-himg" > 
                <iframe src="http://static.kleague.com/video/KleagueIntro.mp4" frameborder="0" allowfullscreen></iframe>
              </div>
            </div>
<div class="col-md-6 wow fadeInUp" data-wow-delay="0.3s">
              <div class="service-h-desc">
                <h3>Ranking & Event</h3>
                <div class="heading-border-light"></div> 
              <div class="service-h-tab"> 
                <nav class="nav nav-tabs" id="myTab" role="tablist">
                  <a class="nav-item nav-link active" id="nav-home-tab" data-toggle="tab" href="#nav-home" role="tab" aria-controls="nav-home" aria-expanded="true">K-League 1</a>
                  <a class="nav-item nav-link" id="nav-profile-tab" data-toggle="tab" href="#nav-profile" role="tab" aria-controls="nav-profile" >Event</a> 
                 
                </nav>
                <div class="tab-content" id="nav-tabContent">
                  <div class="tab-pane fade show active" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab"><script
   src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
	$(window).on("load", function() {

		//페이지 로딩 완료 후, 멜론 순위가져오기 함수 실행함 
		getRank();
		getNews();
	});


	/* function getRank() {

		//Ajax 호출
		$.ajax({
			url : "/project/getRank.do",
			type : "post",
			dataType : "JSON",
			contentType : "application/json; charset=UTF-8",
			success : function(json) {

				var team_rank = "";

				for (var i = 0; i < json.length; i++) {
					team_rank += (json[i].rank + "위| ");					
					team_rank += (json[i].name+" |");
					team_rank += (" 경기수 :"+json[i].playNm+ " | ");
					team_rank += (" 승점 :"+json[i].score + " | ");
					team_rank += (" 승 :"+json[i].win+ " | ");
					team_rank += (" 무 :"+json[i].draw + " | ");
					team_rank += (" 패 :"+json[i].lose + " | ");
					team_rank += (" 득점 :"+json[i].get + " | ");
					team_rank += (" 실점 :"+json[i].miss + " | ");
					team_rank += (" 득실 :"+json[i].diff + " <br> ");

				}
				$('#nav-home').html(team_rank);
			}
		})

	} */
	
	function getNews(){
		$.ajax({
			url : "/project/getNews.do",
			type : "post",
			dataType : "JSON",
			contentType : "application/json; charset=UTF-8",
			success : function(json) {
				
				var news ="";
				
				for(var i = 0; i <json.length; i++){
					news += (json[i].title);
					news += (json[i].seq);
					}
				$('p[name=news]').html(news);
				}
			})
	}
</script>
<script type="text/javascript">
$(".navbar-nav ml-auto li").click(function() {
  var scrollPosition = $($(this).attr("data-target")).offset().top;

  $("body").animate({
        scrollTop: scrollPosition
  }, 500);
})
</script>
<table class="table table-sm" style="text-align:center; width:100%;">
	<thead>
		<tr>
			<td scope="col">순위</td>
			<td scope="col">클럽명</td>
			<td scope="col">승</td>
			<td scope="col">무</td>
			<td scope="col">패</td>
			<td scope="col">승점</td>
			<td scope="col">실점</td>
			<td scope="col">득실</td>
			<td scope="col">경기수</td>
			<!-- <td scope="col">수집시간</td> -->
		</tr>
	</thead>
	<tbody>
		<%for(int i=0;i<rList.size();i++){ %>
		<tr>
			<td><%=rList.get(i).getRank()%></td>
			<td scope="row"><%=CmmUtil.nvl(rList.get(i).getName()) %></td>
			<td><%=rList.get(i).getWin()%></td>
			<td><%=rList.get(i).getDraw()%></td>
			<td><%=rList.get(i).getLose()%></td>
			<td><%=rList.get(i).getScore()%></td>
			<td><%=rList.get(i).getMiss()%></td>
			<td><%=rList.get(i).getDiff()%></td>
			<td><%=rList.get(i).getPlayNm()%></td>
			<%-- <td><%=rList.get(i).getCollect_time()%></td> --%>
		</tr>
		<%} %>		

	</tbody>
</table>
</div>
                  <div class="tab-pane fade" id="nav-profile" role="tabpanel" aria-labelledby="nav-profile-tab" >
                  <table class="table table-sm" style="text-align:left; width:50%;float:left;">
	
		<tr>
			<td scope="col">경기 일정 / 중계</td>
			
		</tr>
	
	<tbody>
		<%for(int i=0;i<sList.size()/2;i++){ %>
		<tr>
			<td><%=sList.get(i)%></td>
			
		</tr>
		<%} %>		

	</tbody>
</table>
<table class="table table-sm" style="text-align:left; width:50%;">
	
		<tr>
			<td scope="col">경기 일정 / 중계</td>
			
		</tr>
	
	<tbody>
		<%for(int i=sList.size()/2;i<sList.size();i++){ %>
		<tr>
			<td><%=sList.get(i)%></td>
			
		</tr>
		<%} %>		

	</tbody>
</table>
                   
                  </div> 
   
                </div>
              </div>
              </div>
            </div>
          </div>
        </div>  
    </section>
   

                <!-- End Latest Tweets -->
              </div>
            </div><!--/container -->
          </div> 	
        </div>

        <div id="footer-bottom">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div id="footer-copyrights">
                            <p>Copyrights &copy; 2017 All Rights Reserved by Businessbox. <a href="#">Privacy Policy</a> <a href="#">Terms of Services</a></p>
                        </div>
                    </div> 
                </div>
            </div>
        </div>
        <a href="#home" id="back-to-top" class="btn btn-sm btn-green btn-back-to-top smooth-scrolls hidden-sm hidden-xs" title="home" role="button">
            <i class="fa fa-angle-up"></i>
        </a>
    </footer>

    <!--Global JavaScript -->
    <script src="/theme/js/jquery/jquery.min.js"></script>
    <script src="/theme/js/popper/popper.min.js"></script>
    <script src="/theme/js/bootstrap/bootstrap.min.js"></script>
    <script src="/theme/js/wow/wow.min.js"></script>
    <script src="/theme/js/owl-carousel/owl.carousel.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="/theme/js/jquery-easing/jquery.easing.min.js"></script> 
    <script src="/theme/js/custom.js"></script> 
    <script src="/theme/js/scroll.js"></script>
  </body>

</html>
