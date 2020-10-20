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
    function deletehuman(){
        if(confirm("정보가 모두 삭제됩니다!")==true){
            location.href="${pageContext.request.contextPath}/human/deletehuman.do?humanno="+${human.humanno};
        }
    };
</script>
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
	    <h2 class="text-black text-center">상세정보</h2>
	   	<br>
	   	<br>
	    <table class="table">
			<tr>
				<th>등록번호</th>
				<td>${human.humanno}</td>
				<th>이름</th>
				<td>${human.name}</td>
				<th>성별</th>
				<td>${human.sex}</td>
				<th>전화번호</th>
				<td>${human.phonenumber}</td>
			</tr>
			<tr>
				<th>양력/음력</th>
				<td>${human.sunmoon}</td>
				<th>출생일</th>
				<td>${human.birthyear}-${human.birthmonth}-${human.birthday}</td>
				<th>출생시</th>
				<td>${human.birthhour}:${human.birthminute}</td>
			</tr>
			<tr>
				<th>특이사항</th>
				<td>${human.details}</td>
			</tr>
		</table>
		<br><br>
		<p align = "right">
			<button class="btn btn-primary" onclick="deletehuman()">삭제</button>
			<button class="btn btn-primary" onclick="location.href='${pageContext.request.contextPath}/human/updatehuman.do?humanno=${human.humanno}'">수정</button>
			<button class="btn btn-primary"  onclick="location.href='${pageContext.request.contextPath}/fortune/fortunelist.do?humanno=${human.humanno}'">점괘보기</button>
			<button class="btn btn-primary"  onclick="location.href='${pageContext.request.contextPath}/fortune/addfortune.do?humanno=${human.humanno}'">점괘추가</button>
			<button class="btn btn-primary"  onclick="location.href='${pageContext.request.contextPath}/human/humanlist.do'">목록</button>
		</p>
	</div>
	
	<br>
	<br>
	<br>
	<br>
	<%@include file="/WEB-INF/views/common/footer.jsp"%>  
</body>
</html>