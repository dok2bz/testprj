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

    <!-- Global Stylesheets -->
    <link href="https://fonts.googleapis.com/css?family=Roboto+Condensed:300,300i,400,400i,700,700i" rel="stylesheet">
    <link href="/theme/css/bootstrap/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="font-awesome-4.7.0//theme/css/font-awesome.min.css">
    <link rel="stylesheet" href="/theme/css/animate/animate.min.css">
    <link rel="stylesheet" href="/theme/css/owl-carousel/owl.carousel.min.css">
    <link rel="stylesheet" href="/theme/css/owl-carousel/owl.theme.default.min.css">
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
                <li  data-target="#service"><a class="nav-link smooth-scroll" href="#service-h">Ranking</a></li> 
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
                  <hgroup class="wow fadeInUp">
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
                 
                  <i class="search fa fa-search search-btn"></i>
                  <div class="search-open">
                    <div class="input-group animated fadeInUp">
                      <input type="text" class="form-control" placeholder="Search" aria-describedby="basic-addon2">
                      <span class="input-group-addon" id="basic-addon2">Go</span>
                    </div>
                  </div>
          
          </div>
          <div class="col-md-3 col-sm-6 desc-comp-offer wow fadeInUp" data-wow-delay="0.4s">
            <div class="desc-comp-offer-cont">
              <div class="thumbnail-blogs">
                  <div class="caption">
                    <i class="fa fa-chain"></i>
                  </div>
                  <img src="/theme/img/news/news-1.jpg" class="img-fluid" alt="...">
              </div>
              
          
              <h3><%=CmmUtil.nvl(nList.get(0).getTitle())%></h3>
           
              <a href="#"><i class="fa fa-arrow-circle-o-right"></i> <%=CmmUtil.nvl(nList.get(0).getCollect_time()) %></a>
            </div>
          </div>
          <div class="col-md-3 col-sm-6 desc-comp-offer wow fadeInUp" data-wow-delay="0.6s">
            <div class="desc-comp-offer-cont">
              <div class="thumbnail-blogs">
                  <div class="caption">
                    <i class="fa fa-chain"></i>
                  </div>
                  <img src="/theme/img/news/news-9.jpg" class="img-fluid" alt="...">
              </div>
              <h3><%=CmmUtil.nvl(nList.get(1).getTitle())%></h3>
              <a href="#"><i class="fa fa-arrow-circle-o-right"></i> <%=CmmUtil.nvl(nList.get(1).getCollect_time()) %></a>
            </div>
          </div>
          <div class="col-md-3 col-sm-6 desc-comp-offer wow fadeInUp" data-wow-delay="0.8s">
            <div class="desc-comp-offer-cont">
              <div class="thumbnail-blogs">
                  <div class="caption">
                    <i class="fa fa-chain"></i>
                  </div>
                  <img src="/theme/img/news/news-12.jpeg" class="img-fluid" alt="...">
              </div>
              <h3><%=CmmUtil.nvl(nList.get(2).getTitle())%></h3>
              <a href="#"><i class="fa fa-arrow-circle-o-right"></i> <%=CmmUtil.nvl(nList.get(2).getCollect_time()) %></a>
            </div>
          </div>
        </div>
      </div>
    </section>
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
			<td scope="col">수집시간</td>
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
			<td><%=rList.get(i).getCollect_time()%></td>
		</tr>
		<%} %>		

	</tbody>
</table>
</div>
                  <div class="tab-pane fade" id="nav-profile" role="tabpanel" aria-labelledby="nav-profile-tab" >
                   
                  </div> 
   
                </div>
              </div>
              </div>
            </div>
          </div>
        </div>  
    </section>
    <footer> 
        <div id="footer-s1" class="footer-s1">
          <div class="footer">
            <div class="container">
              <div class="row">
                <!-- About Us -->
                <div class="col-md-3 col-sm-6 ">
                  <div><img src="/theme/img/logo-w.png" alt="" class="img-fluid"></div>
                  <ul class="list-unstyled comp-desc-f">
                     <li><p>Businessbox is a corporate business theme. You can customize what ever you think to make your website much better from your great ideas. </p></li> 
                  </ul><br> 
                </div>
                <!-- End About Us -->

                <!-- Recent News -->
                <div class="col-md-3 col-sm-6 ">
                  <div class="heading-footer"><h2>Useful Links</h2></div>
                  <ul class="list-unstyled link-list">
                    <li><a href="about.html">About us</a><i class="fa fa-angle-right"></i></li> 
                    <li><a href="project.html">Project</a><i class="fa fa-angle-right"></i></li> 
                    <li><a href="careers.html">Career</a><i class="fa fa-angle-right"></i></li> 
                    <li><a href="faq.html">FAQ</a><i class="fa fa-angle-right"></i></li> 
                    <li><a href="contact.html">Contact us</a><i class="fa fa-angle-right"></i></li> 
                  </ul>
                </div>
                <!-- End Recent list -->

                <!-- Recent Blog Entries -->
                <div class="col-md-3 col-sm-6 ">
                  <div class="heading-footer"><h2>Recent Post Entries</h2></div>
                  <ul class="list-unstyled thumb-list">
                    <li>
                      <div class="overflow-h">
                        <a href="#">Praesent ut consectetur diam.</a>
                        <small>02 OCT, 2017</small>
                      </div>
                    </li>
                    <li>
                      <div class="overflow-h">
                        <a href="#">Maecenas pharetra tellus et fringilla.</a>
                        <small>02 OCT, 2017</small>
                      </div>
                    </li>
                  </ul>
                </div>
                <!-- End Recent Blog Entries -->

                <!-- Latest Tweets -->
                <div class="col-md-3 col-sm-6">
                  <div class="heading-footer"><h2>Get In Touch</h2></div>
                  <address class="address-details-f">
                    25, Dist town Street, Logn <br>
                    California, US <br>
                    Phone: 800 123 3456 <br>
                    Fax: 800 123 3456 <br>
                    Email: <a href="mailto:info@Businessbox.com" class="">info@Businessbox.com</a>
                  </address>  

                </div>
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
