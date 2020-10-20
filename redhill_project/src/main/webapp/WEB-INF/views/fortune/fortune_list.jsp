<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@include file="/WEB-INF/views/common/header.jsp"%>
<body>
<!-- Navigation -->
	<%@include file="/WEB-INF/views/common/navbar.jsp"%> 
	<div class="container">
		<br>
		<br>
		<br>
	    <!-- Page Content -->
		<div id="layoutSidenav_content">
	       	<main>
	           	<div class="container-fluid">
	               	<div class="card mb-4">
	                   	<div class="card-body">
	                       	<div class="table-responsive">
	                       	<h2 class="text-black text-center"><strong>점괘 목록</strong></h2>
	                           	<table class="table table-bordered table-hover" style="table-layout: fixed" id="dataTable" width="100%" cellspacing="0" >
									<thead>
									<tr>
										<th>등록번호</th>
										<th>내부괘</th>
										<th>외부괘</th>
										<th>변화괘</th>
										<th>날짜</th>
										
									</tr>
									</thead>
									<tbody>
										<c:forEach var="data" items="${fortunelist}" varStatus="status">
											<tr>
												<td><a href="${pageContext.request.contextPath}/fortune/viewfortune.do?fortuneno=${data.fortuneno}">${data.fortuneno}</a></td>
												<td>${data.innerfortune}</td>
												<td>${data.outerfortune}</td>
												<td>${data.changefortune}</td>
												<td>${data.fortunedate}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
								<p align="right">
								<button class="btn btn-primary" onclick="location.href='${pageContext.request.contextPath}/human/viewhuman.do?humanno=${humanno}'">돌아가기</button>
								</p>
							</div>
	                       </div>
	                   </div>
	               </div>
	         	</main>
	       </div>
	</div>
	<!-- dataTable 기능 제거 및 위치-->
		<script>
			$("#dataTable").DataTable({   
		   
		   		dom : "<'row'<'col-sm-2'l><'col-sm-7'><'col-sm-3'f>>" +
		   			"<'row'<'col-sm-12'tr>>" +
		   			"<'row'<'col-sm-12 col-md-8'p>>",
		   		 "language":{
		   		   "url": "//cdn.datatables.net/plug-ins/1.10.9/i18n/Korean.json"
		   		 },
				"bFilter": false
			});   
		</script>  
	<%@include file="/WEB-INF/views/common/footer.jsp"%>   
	
</body>
</html>