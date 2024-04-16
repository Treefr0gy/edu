<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>문제 발생</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
</head>

<style>
	div.panel{
		margin-top: 10%;
		width : 40%;
		display : inline-block;
		background-color: #F5F5F5;
	}
	span.glyphicon-ban-circle{
		color : #E60000;
		font-size: 8em;
	}
	h5.description-for-error{
		color : #E60000;
		margin-top : 50px;
		font-weight: bold;
	}
</style>

<body>
	<div class="container text-center">
		<div class="panel panel-default">
			<div class="panel-body text-center">
				<span class="glyphicon glyphicon-ban-circle"></span>
				<h3 style="font-weight:bold;">예상치 못한 오류가 발생했습니다.</h3>
				<h3>불편을 드려 죄송합니다.</h3>
				<h5 style="color:#ff0303;">예외 코드 : ${code}</h5>
				<h5 style="color:#ff0303;">예외 메시지 : ${message}</h5>
<%--		<ul>
				<c:forEach items="${exception.getStackTrace()}" var="stack">
					<li>${stack.toString()}</li>
				</c:forEach>
			</ul> --%>				
				<h5 class="description-for-error"><span class="glyphicon glyphicon-repeat"></span> <a href="/edu/board/openBoardList.do">목록 페이지로 이동합니다.</a></h5>
			</div>
		</div>
	</div>
</body>

</html>