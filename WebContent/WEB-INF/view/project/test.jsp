<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="poly.util.CmmUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="poly.dto.RankDTO"%>
<%@page import="java.util.List"%>

<%
    List<RankDTO> rList = (List<RankDTO>)request.getAttribute("rList");
    
    if (rList==null) {
		rList = new ArrayList<RankDTO>();
	}  
    
     
    %>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://fonts.googleapis.com/css?family=Roboto+Condensed:300,300i,400,400i,700,700i"
	rel="stylesheet">
<link href="/theme/css/bootstrap/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet"
	href="font-awesome-4.7.0//theme/css/font-awesome.min.css">
<link rel="stylesheet" href="/theme/css/animate/animate.min.css">
<link rel="stylesheet"
	href="/theme/css/owl-carousel/owl.carousel.min.css">
<link rel="stylesheet"
	href="/theme/css/owl-carousel/owl.theme.default.min.css">
<link rel="stylesheet" href="/theme/css/style.css">
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
					team_rank += (" 클럽명 : " + json[i].name + " |");
					team_rank += (" 경기수 :" + json[i].playNm + " | ");
					team_rank += (" 승점 :" + json[i].score + " | ");
					team_rank += (" 승 :" + json[i].win + " | ");
					team_rank += (" 무 :" + json[i].draw + " | ");
					team_rank += (" 패 :" + json[i].lose + " | ");
					team_rank += (" 득점 :" + json[i].get + " | ");
					team_rank += (" 실점 :" + json[i].miss + " | ");
					team_rank += (" 득실 :" + json[i].diff + " | ");
					team_rank += (" 수집시간 :" + json[i].collect_time + "<br> ");

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
<table class="table table-sm" style="text-align:center; width:50%;">
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
</html>


