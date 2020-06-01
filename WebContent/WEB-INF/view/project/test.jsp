<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	$(window).on("load", function() {

		//페이지 로딩 완료 후, 멜론 순위가져오기 함수 실행함 
		getRank();
	});

	//멜론 순위가져오기
	function getRank() {

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
					team_rank += (" 클럽명 : "+json[i].name+" |");
					team_rank += (" 경기수 :"+json[i].playNm+ " | ");
					team_rank += (" 승점 :"+json[i].score + " | ");
					team_rank += (" 승 :"+json[i].win+ " | ");
					team_rank += (" 무 :"+json[i].draw + " | ");
					team_rank += (" 패 :"+json[i].lose + " | ");
					team_rank += (" 득점 :"+json[i].get + " | ");
					team_rank += (" 실점 :"+json[i].miss + " | ");
					team_rank += (" 득실 :"+json[i].diff + " | ");
					team_rank += (" 수집시간 :"+json[i].collect_time + "<br> ");

				}

				$('#team_rank').html(team_rank);
			}
		})

	}
</script>
</head>
<body>
	<h1>k리그 순위</h1>
	<hr />
	<div id="team_rank"></div>
	<br />
	<hr />
</body>
</html>


