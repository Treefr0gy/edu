<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/WEB-INF/include/include-header.jsp" %>
</head>
<body>
<div id="wrap">
	<div id="container">
		<div class="inner">
			<h2>게시글 상세</h2>
				<table width="100%" class="table01">
					<colgroup>
						<col width="15%">
						<col width="35%">
						<col width="15%">
						<col width="*">
					</colgroup>
					<tbody id="tbody">
						<tr>
							<th>제목</th>
							<td>${map.BOARD_SUBJECT }</td>
							<th>조회수</th>
							<td>${map.BOARD_HITS }</td>
						</tr>
						<tr>
							<th>작성자</th>
							<td>${map.BOARD_WRITER }
							<th>작성시간</th>
							<td>${map.INS_DATE }</td>
						</tr>
						<tr>
							<th>내용</th>
							<td colspan="3">${map.BOARD_CONTENT }</td>
						</tr>
					</tbody>
				</table>
				<div class="btn_right mt15">
					<button type="button" class="btn black mr5" id="list">목록으로</button>
					<button type="button" class="btn black mr5" id="update">수정하기</button>
				</div>
		</div>
	</div>
</div>
	<%@ include file="/WEB-INF/include/include-body.jsp" %>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#list").on("click", function(e){
				e.preventDefault();
				fn_openBoardList();
			});
			
			$("#update").on("click", function(e){
				e.preventDefault();
				fn_openBoardUpdate();
			});
		});
	
		function fn_openBoardList(){
			var comSubmit = new ComSubmit();
			comSubmit.setUrl("<c:url value='/board/openBoardList.do' />");
			comSubmit.submit();
		}
		
		function fn_openBoardUpdate(){
			var boardSeq = "${map.BOARD_SEQ}";
			//var searchType = "U";
			
			var comSubmit = new ComSubmit();
			comSubmit.setUrl("<c:url value='/board/openBoardUpdate.do' />");
			comSubmit.addParam("boardSeq", boardSeq);
			//comSubmit.addparam("searchType", searchType);
			comSubmit.submit();
		}
		
	</script>
</body>
</html>