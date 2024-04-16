/** 공통 널(null) 체크
 * Null 체크, 정확한 값이 들어있는제 체크함, 값이 들어있지 않다면 true를 변환하고, 값이 들어있으면 false를 변환함.
 */
function gfn_isNull(str) {
	if (str == null)
		return true;
	if (str == "NaN")
		return true;
	if (new String(str).valueOf() == "underfined")
		return true;
	var chkStr = new String(str);
	if (chkStr.valueOf() == "underfined")
		return true;
	if (chkStr == null)
		return true;
	if (chkStr.toString().length == 0)
		return true;
	return false;
}
/** 공통 submit
 * 파라미터의 동적 추가나 공통적인 파라미터 추가, 아무것도 없을 때의 화면이동이 불편한 경우가 많아서 숨겨둔 form을 하나 만들어 놓고 그 폼을 이용하여 페이지의 이동 및 입력 값 전송
 */
function ComSubmit(opt_formId) {
	this.formId = gfn_isNull(opt_formId) == true ? "commonForm" : opt_formId;
	this.url = "";
	if (this.formId == "commonForm") {
		$("#commonForm")[0].reset();
	};
	this.setUrl = function setUrl(url) {
		this.url = url;
	};
	this.addParam = function addParam(key, value) {
		$("#" + this.formId).append(
				$("<input type='hidden' name='" +key + "' id='" + key
						+ "' value='" + value + "' >"));
	};
	this.submit = function submit() {
		var frm = $("#" + this.formId)[0];
		frm.action = this.url;
		frm.method = "post";
		frm.submit();
	};
}

/** 공통 AJAX
 * input 값 : URL, Data(JSON 형태), async(true/false)
 */
var urlAll = location.href;
var preUrl = urlAll.split("/");
var preURL = "/" + preUrl[3] + "/" + preUrl[4] + "/";
function fn_common_ajax(urlData,postData,async){
	
	$.ajax({
		url		 : preURL + urlData,
		data	 : postData,
		dataType : "JSON",
		cache	 : false,
		async	 : async,
		type	 : "POST",
		beforeSend:function(xmlHttpRequest){
			xmlHttpRequest.setRequestHeader("AJAX","true");
		},
		success	 : function(data) {
			fn_callBack(data);
		},
//	     error	   : function(request,status,error) {
//		   alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
//		 }
	   error : function(e) {
		   console.log("ERROR: ", e);
		   if(e.status == 401){
			   alert("세션이 종료되었습니다. 3초 후 로그인 페이지로 이동합니다.", "error");
			   setTimeout("location.href='/edu/board/openBoardList.do'",3000);
		   } else if(e.responseJSON.isException == true) {
			   alert(e.responseJSON.returnExceptionMsg);
			   setTimeout("location.href='/edu/board/openBoardList.do'",1000);
		   }
	   }
	});
};	