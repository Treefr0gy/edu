<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/WEB-INF/include/include-header.jsp"%>
</head>
<body>
<div id="wrap">
	<div id="container">
		<div class="inner">
			<form id="frm">
				 <table width="100%" class="table02">
				<caption><strong><span class="t_red">*</span> 표시는 필수입력 항목입니다.</strong></caption>
					<colgroup>
						<col width="20%">
						<col width="*" />
					</colgroup>
					<caption>게시글 작성</caption>
					<tbody id="tbody">
						<tr>
							<th scope="row">제목<span class="t_red">*</span></th>
							<td><input type="text" id="boardSubject" name="boardSubject" class="tbox01"></input></td>
						</tr>
						<tr>
							<th>작성자<span class="t_red">*</span></th>
							<td><input type="text" id="boardWriter" name="boardWriter" class="tbox01"/></td>
						</tr>
						<tr>
							<th>내용<span class="t-red">*</span></th>
							<td><textarea rows="20" cols="100" title="내용" id="boardContent" name="boardContent"></textarea></td>
						</tr>
					</tbody>
				</table>
				<div class="btn_right mt15">
					<button type="button" class="btn black mr5" id="list">목록으로</button>
					<button type="button" class="btn black" id="write">등록하기</button>
				</div>
			</form>
		</div>
	</div>
</div>
<%@ include file="/WEB-INF/include/include-body.jsp" %>
<script type="text/javascript">
		$(document).ready(function() {
			$("#list").on("click", function(e){
				e.preventDefault();
				fn_openBoardList();
			});
			
			$("#write").on("click", function(e){
				e.preventDefault();
				fn_insertBoard();
			})
		});
		
		function fn_openBoardList(){
			var comSubmit = new ComSubmit();
			comSubmit.setUrl("<c:url value='/board/openBoardList.do' />");
			comSubmit.submit();
		}
		
		function fn_insertBoard(){
			
			if ($("#boardSubject").val() == ""){
				alert("제목을 입력해주세요.");
				$("#boardSubject").focus();
				return false;
			}
			
			if ($("#boardWriter").val() == ""){
				alert("작성자를 입력해주세요.");
				$("#boardWriter").focus();
				return false;
			}
			
			if ($("#boardContent").val() == ""){
				alert("내용을 입력해주세요.");
				$("#boardContent").focus();
				return false;
			}
			
			var comSubmit = new ComSubmit("frm");
			comSubmit.setUrl("<c:url value='/board/insertBoard.do' />");
			comSubmit.submit();
		}
		
</script>
		
</body>
</html>