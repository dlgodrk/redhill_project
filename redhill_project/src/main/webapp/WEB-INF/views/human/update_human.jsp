<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@include file="/WEB-INF/views/common/header.jsp"%>
	<script>
		function cancle(){
			if(confirm('정말 취소하시겠습니까?')){
				location.href="${pageContext.request.contextPath}/human/viewhuman.do?humanno=${human.humanno}";
			}
		}
	</script>
</head>

<body>
	<!-- Navigation -->
   	<%@include file="/WEB-INF/views/common/navbar.jsp"%>  
   	
   	<div class="container">
		<br>
		<br>
		<br>
	   	<h2 class="text-black text-center"><strong>수정</strong></h2>
		<form class="form-horizontal" method="post" name="writeform" id="writeform" action="${pageContext.request.contextPath}/human/updatehuman.do">
			<div>
			<input type="hidden" name="humanno" id="humanno" value="${human.humanno}"/>
			<label>이름</label>
				<input class="form-control" type="text" name="name" id="name" value="${human.name}"/>
				<label>성별</label>
				<select class="form-control" id="sex" name="sex">
					<c:if test="${human.sex == '여성'}">
						<option value="여성">여성</option>
						<option value="남성">남성</option>
					</c:if>
					<c:if test="${human.sex == '남성'}">
						<option value="남성">남성</option>
						<option value="여성">여성</option>
					</c:if>
				</select>
				<label>휴대폰 번호</label>
				<input class="form-control" type="text" name="phonenumber" id="phonenumber" value="${human.phonenumber}">
			</div>
			<div>
				<label>양력/음력</label>
				<select class="form-control" id="sunmoon" name="sunmoon">
					<c:if test="${human.sunmoon == '양력'}">
						<option value="양력">양력</option>
						<option value="음력평달">음력평달</option>
						<option value="음력윤달">음력양달</option>
					</c:if>
					<c:if test="${human.sunmoon == '음력평달'}">
						<option value="음력평달">음력평달</option>
						<option value="양력">양력</option>
						<option value="음력윤달">음력양달</option>
					</c:if>
					<c:if test="${human.sunmoon == '음력양달'}">
						<option value="음력윤달">음력양달</option>
						<option value="양력">양력</option>
						<option value="음력평달">음력평달</option>
					</c:if>
				</select>
				<label>출생년도</label>
				<input class="form-control" type="number" name="birthyear" id="birthyear" value="${human.birthyear}">
				<label>출생월</label>
				<input class="form-control" type="number" name="birthmonth" id="birthmonth" value="${human.birthmonth}">
				<label>출생일</label>
			</div>
			<div>
				<input class="form-control" type="number" name="birthday" id="birthday" value="${human.birthday}">
				<label>출생시</label>
				<input class="form-control" type="number" name="birthhour" id="birthhour" value="${human.birthhour}">
				<label>출생분</label>
				<input class="form-control" type="number" name="birthminute" id="birthminute" value="${human.birthminute}">
			</div>
			<div>
				<label>특이사항</label>
				<textarea class="form-control" maxlength="1000" id="details" name="details" >${human.details}</textarea>
			</div>
			<br>
			<br>
			<p align="right">
				<button class="btn btn-primary" type="submit" form="writeform">저장</button>
				<button class="btn btn-primary" type="button" onclick="cancle()">취소</button>
			</p>
		</form>
	</div>
	<br>
	<br>
	<br>
   <%@include file="/WEB-INF/views/common/footer.jsp"%> 
</body>
</html>