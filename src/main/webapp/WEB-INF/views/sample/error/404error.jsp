<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/include/include-header.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>404</title>

</head>
<style>
	#notfound {
		position: relative;
		height: 100vh;
	}
	#notfound .notfound {
		position: absolute;
		left: 50%;
		top: 50%;
		max-width: 767px;
		width: 100%;
		line-height: 1.4;
		transform: translate(-50%,-50%);
	}
	.notfound .notfound-404 {
		line-height: 150px;
		margin-bottom: 25px;
	}
	.notfound .notfound-404 h1 {
	font-size: 186px;
	margin: 0;
	text-transform: uppercase;
	-webkit-background-clip: text;
	}
	.notfound h2 {
		font-size: 26px;
		margin: 0;
	}
	.notfound p {
	font-size: 14px;
	margin-bottom: 0;
	text-transform: uppercase;
	}
	.notfound a {
	display: inline-block;
	text-transform: uppercase;
	color: #fff;
	text-decoration: none;
	background: #5c91fe;
	padding: 10px 40px;
	font-size: 14px;
	font-weight: 700;
	margin-top: 15px;
	}
</style>

<body>

<div id="notfound">
<div class="notfound">
<div class="notfound-404">
<h1>404</h1>
</div>
<h2>페이지를 찾을 수 없습니다.</h2>
<p>페이지가 존재하지 않거나, 사용할 수 없는 페이지입니다.</p>
<p>입력하신 주소가 정확한지 다시 한 번 확인해주세요.</p>
<a href="/edu/board/openBoardList.do">Go To Listpage</a>
</div>
</div>

</body>

</html>