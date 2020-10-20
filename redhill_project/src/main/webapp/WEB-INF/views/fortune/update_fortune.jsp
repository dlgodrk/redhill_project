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
				location.href="${pageContext.request.contextPath}/fortune/viewfortune.do?fortuneno=${fortune.fortuneno}";
			}
		}
	</script>
</head>

<body>
	<!-- Navigation -->
   	<%@include file="/WEB-INF/views/common/navbar.jsp"%>  
   	
	<c:if test="${!empty check}">
		<script>
			alert("수정완료");
		</script>
	</c:if>
	<div class="container">
		<br>
		<br>
		<br>
	   	<h2 class="text-black text-center"><strong>점괘 수정</strong></h2>
			<form class="form-horizontal" method="post" name="writeform" id="writeform" action="${pageContext.request.contextPath}/fortune/updatefortune.do">
				<input class="form-control" type="hidden" name="fortuneno" id="fortuneno" value="${fortune.fortuneno}"/>
				<div>
				<label>내괘</label>
				<input class="form-control" type="number" name="innerfortune" id="innerfortune" value="${fortune.innerfortune}"/>
				<label>외괘</label>
				<input class="form-control" type="number" name="outerfortune" id="outerfortune" value="${fortune.outerfortune}"/>
				<label>변화괘</label>
				<input class="form-control" type="number" name="changefortune" id="changefortune" value="${fortune.changefortune}"/>	
				</div>
				<div>
				<label>점괘날짜</label>
				<input class="form-control" type="text" name="fortunedate" id="fortunedate" value="${fortune.fortunedate}"/>
				</div>
				<div>
					<label>점괘설명</label>
					<textarea class="form-control" maxlength="1000" id="explainfortune" name="explainfortune">${fortune.explainfortune}</textarea>
				</div>
				<div>
					<label>특이사항</label>
					<textarea class="form-control" maxlength="1000" id="details" name="details">${fortune.details}</textarea>
				</div>
				<button class="btn btn-primary" type="submit" form="writeform">저장</button>
				<button class="btn btn-primary" type="button" onclick="cancle()">취소</button>
			</form>
	</div>
		<br>
		<br>
		<br>
	   <%@include file="/WEB-INF/views/common/footer.jsp"%> 
</body>
</html>