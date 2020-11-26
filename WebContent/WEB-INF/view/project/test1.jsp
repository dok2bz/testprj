<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
   src="https://cdnjs.cloudflare.com/ajax/libs/socket.io/2.3.1/socket.io.js"></script>
   <script
   src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
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
      let user_name = "assssss";
      const user_mail = "asd";
      
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
</body>
</html>