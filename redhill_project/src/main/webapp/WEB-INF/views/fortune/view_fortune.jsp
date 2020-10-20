<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/header.jsp"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
    function deletefortune(){
        if(confirm("정보가 모두 삭제됩니다!")==true){
            location.href="${pageContext.request.contextPath}/fortune/deletefortune.do?fortuneno=${fortune.fortuneno}&humanno=${fortune.humanno}";
        }
    };
</script>
<body>
	<!-- Navigation -->
	<%@include file="/WEB-INF/views/common/navbar.jsp"%> 
	<div class="container">
	   	<br>
	   	<br>
	    <h2 class="text-black text-center">점괘 상세</h2>
	   	<br>
	   	<br>
		<table class="table">
	
			<tr>
				<th>등록번호</th>
				<td>${fortune.fortuneno}</td>
				<th>날짜</th>
				<td>${fortune.fortunedate}</td>
			</tr>
			<tr>
				<th>내부괘</th>
				<td>${fortune.innerfortune}</td>
				<th>외부괘</th>
				<td>${fortune.outerfortune}</td>
				<th>변화괘</th>
				<td>${fortune.changefortune}</td>
			</tr>
			<tr>
				<th>점괘 해석</th>
				<td>${fortune.explainfortune}</td>
			</tr>
			<tr>
				<th>특이사항</th>
				<td>${fortune.details}</td>
			</tr>
		</table>
		
		<br><br>
		<p align = "right">
			<button class="btn btn-primary" onclick="deletefortune()">삭제</button>
			<button class="btn btn-primary" onclick="location.href='${pageContext.request.contextPath}/fortune/updatefortune.do?fortuneno=${fortune.fortuneno}'">수정</button>
			<button class="btn btn-primary" onclick="location.href='${pageContext.request.contextPath}/fortune/fortunelist.do?humanno=${fortune.humanno }'">목록</button>
		</p>
	</div>
	
	<br>
	<br>
	<br>
	<br>
	<%@include file="/WEB-INF/views/common/footer.jsp"%> 
	
</body>
</html>