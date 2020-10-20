<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@include file="/WEB-INF/views/common/header.jsp"%>
	<script>
	function cancle(){
		if(confirm('정말 취소하시겠습니까?')){
			location.href="${pageContext.request.contextPath}/human/addhuman.do";
		}
	}
	function home(){
		if(confirm('정말 홈으로 이동하시겠습니까?')){
			location.href="${pageContext.request.contextPath}/main/main.do";
		}
	}
</script>
</head>

<body>
	<!-- Navigation -->
   	<%@include file="/WEB-INF/views/common/navbar.jsp"%>  
   	
	<c:if test="${!empty check}">
		<script>
			alert("추가완료");
		</script>
	</c:if>
	<div class="container">
		<br>
		<br>
		<br>
	   	<h2 class="text-black text-center"><strong>등록</strong></h2>
		<form class="form-horizontal" method="post" name="writeform" id="writeform" action="${pageContext.request.contextPath}/human/addhuman.do">
			<div>
			<label>이름</label>
				<input class="form-control" type="text" name="name" id="name" value=""/>
				<label>성별</label>
				<select class="form-control" id="sex" name="sex">
					<option value="여성">여성</option>
					<option value="남성">남성</option>
				</select>
				<label>휴대폰 번호</label>
				<input class="form-control" type="text" name="phonenumber" id="phonenumber" value="">
			</div>
			<div>
			<label>양력/음력</label>
			<select class="form-control" id="sunmoon" name="sunmoon">
				<option value="양력">양력</option>
				<option value="음력평달">음력평달</option>
				<option value="음력윤달">음력양달</option>
			</select>
			<label>출생년도</label>
			<input class="form-control" type="number" name="birthyear" id="birthyear" value="">
			<label>출생월</label>
			<input class="form-control" type="number" name="birthmonth" id="birthmonth" value="">
			<label>출생일</label>
			<input class="form-control" type="number" name="birthday" id="birthday" value="">
			<label>출생시</label>
			<input class="form-control" type="number" name="birthhour" id="birthhour" value="">
			<label>출생분</label>
			<input class="form-control" type="number" name="birthminute" id="birthminute" value="">
			</div>
			<div>
				<label>특이사항</label>
				<textarea class="form-control" maxlength="1000" id="details" name="details"></textarea>
			</div>
			<br>
			<br>
			<p align="right">
				<button class="btn btn-primary" type="submit" form="writeform">저장</button>
				<button class="btn btn-primary" type="button" onclick="cancle()">취소</button>
				<button class="btn btn-primary" type="button" onclick="home()">홈으로</button>
			</p>
		</form>
	</div>
	<br>
	<br>
	<br>
   <%@include file="/WEB-INF/views/common/footer.jsp"%> 
</body>
</html>