<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<%@include file="/WEB-INF/views/common/header.jsp"%>
	<script>
	function cancle(){
		if(confirm('정말 취소하시겠습니까?')){
			location.href="${pageContext.request.contextPath}/human/viewhuman.do?humanno=${humanno}";
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
	   	<h2 class="text-black text-center"><strong>점괘 등록</strong></h2>
		<form class="form-horizontal" method="post" name="writeform" id="writeform" action="${pageContext.request.contextPath}/fortune/addfortune.do">
			<input class="form-control" type="hidden" name="humanno" id="humanno" value="${humanno}"/>
			<div>
			<label>내괘</label>
			<input class="form-control" type="number" name="innerfortune" id="innerfortune" value=""/>
			<label>외괘</label>
			<input class="form-control" type="number" name="outerfortune" id="outerfortune" value=""/>
			<label>변화괘</label>
			<input class="form-control" type="number" name="changefortune" id="changefortune" value=""/>	
			</div>
			<div>
			<label>년</label>
			<input class="form-control" type="number" name="fortuneyear" id="fortuneyear" value=""/>
			<label>월</label>
			<input class="form-control" type="number" name="fortunemonth" id="fortunemonth" value=""/>
			<label>일</label>
			<input class="form-control" type="number" name="fortuneday" id="fortuneday" value=""/>
			</div>
			<div>
				<label>점괘설명</label>
				<textarea class="form-control" maxlength="1000" id="explainfortune" name="explainfortune"></textarea>
			</div>
			<div>
				<label>특이사항</label>
				<textarea class="form-control" maxlength="1000" id="details" name="details"></textarea>
			</div>
			<br><br>
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