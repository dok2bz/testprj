<%@page import="poly.util.CmmUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="poly.dto.NewsAllDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%
    List<NewsAllDTO> naList = (List<NewsAllDTO>)request.getAttribute("naList");
    
    if (naList==null) {
		naList = new ArrayList<NewsAllDTO>();
	}  
   List<NewsAllDTO> nList = (List<NewsAllDTO>)request.getAttribute("nList");
    
    if (nList==null) {
		nList = new ArrayList<NewsAllDTO>();
	}  
    String user_name = (String) session.getAttribute("user_name");
    String user_mail = (String) session.getAttribute("user_mail");
    		
    

    %>
<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Business Bootstrap Responsive Template</title>
    <link rel="shortcut icon" href="theme/img/favicon.ico">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

    <!-- Global Stylesheets -->
    <link href="https://fonts.googleapis.com/css?family=Roboto+Condensed:300,300i,400,400i,700,700i" rel="stylesheet">
    <link href="/theme/css/bootstrap/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="font-awesome-4.7.0//theme/css/font-awesome.min.css">
    <link rel="stylesheet" href="/theme/css/animate/animate.min.css">
    <link rel="stylesheet" href="/theme/css/owl-carousel/owl.carousel.min.css">
    <link rel="stylesheet" href="/theme/css/owl-carousel/owl.theme.default.min.css">
    <link rel="stylesheet" href="/theme/css/style.css">

    <!-- Core Stylesheets -->
    <link rel="stylesheet" href="/theme/css/news.css"> 
    <script
   src="https://cdnjs.cloudflare.com/ajax/libs/socket.io/2.3.1/socket.io.js"></script>
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
                <li  data-target="#home"><a class="nav-link smooth-scroll" href="/project/index.do">Home</a></li>
                <li  data-target="#comp-offer"><a class="nav-link smooth-scroll" href="/project/news-list.do">News</a></li> 
                <li  data-target="#comp-offer"><a class="nav-link smooth-scroll" href="/project/Community.do">Community</a></li> 
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
                 
                    </div>
                  </div>
                </li>
                <li>
                  <i class="search fa fa-search search-btn"></i>
                  <div class="search-open">
                    <div class="input-group animated fadeInUp">
                   
                      
                    </div>
                  </div>
                </li> 
                <li>
                  <div class="top-menubar-nav">
                    <div class="topmenu ">
                      <div class="container">
                        <div class="row">


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
                    LOGIN OR REGISTER
======================================================-->
   
<!--====================================================
                       HOME-P
======================================================-->
    <div id="home-p" class="home-p pages-head3 text-center">
      <div class="container">
        <h1 class="wow fadeInUp" data-wow-delay="0.1s"><a class="nav-link smooth-scroll" href="/project/Community.do" color="white">Community</h1></a>
      
      </div><!--/end container-->
    </div> 

<!--====================================================
                        single-news-p1
======================================================--> 
    <section id="single-news-p1" class="single-news-p1">
      <div class="container">
        <div class="row">
        <div>
                  <fieldset>
                     <div id="messageWindow" style="border:2px solid black;display: block;                         
                         height:400px;                      
                           overflow-y:scroll;
                         scroll-behavior:smooth;"></div>
                     <br /> 
                     
                     <input id="inputMessage" type="text" /> <input
                        type="submit" onclick="logincheck2()" value="전송" />
                        
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
        <br>
          
</table> 

	<button id="load1">더 보기</button>
		
            </div>
          </div> 
        </div>
      </div>
    </section>
 

<!--====================================================
                      FOOTER
======================================================--> 
    <footer 
    style="margin-top: 15%;"
    >

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
        <a href="#home-p" id="back-to-top" class="btn btn-sm btn-green btn-back-to-top smooth-scrolls hidden-sm hidden-xs" title="home" role="button">
            <i class="fa fa-angle-up"></i>
        </a>
    </footer>

    <!--Global JavaScript -->
    <script src="js/popper/popper.min.js"></script>
    <script src="js/bootstrap/bootstrap.min.js"></script>
    <script src="js/wow/wow.min.js"></script>
    <script src="js/owl-carousel/owl.carousel.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="js/jquery-easing/jquery.easing.min.js"></script> 

    <script src="js/custom.js"></script> 
    <script type="text/javascript">
   $(function () {
      $(".load").slice(0, 10).show();
      if ($(".load:hidden").length == 0) {
          $('#load1').attr('style', "display:none;");
       }
      $("#load1").click(function (e) {
         e.preventDefault();
         $(".load:hidden").slice(0, 10).show();
         if ($(".load:hidden").length == 0) {
            $('#load1').attr('style', "display:none;");
         }
      })
   })

</script>
  </body>

</html>
