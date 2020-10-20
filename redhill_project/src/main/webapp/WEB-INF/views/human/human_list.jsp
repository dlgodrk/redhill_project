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
	                        		<h2 class="text-black text-center"><strong>목록</strong></h2>
	                            	<div align = "right">
										<form id="searchform" name="searchform" action="${pageContext.request.contextPath}/human/searchhuman.do" method="post">
											<input type=text id="name" name="name" placeholder="이름" value=""/>
											<button type="submit" class="btn btn-primary" form="searchform">검색</button>
										</form>
									</div>
	                            	<table class="table table-bordered table-hover" style="table-layout: fixed" id="dataTable" width="100%" cellspacing="0" >
										<thead>
										<tr>
											<th>등록번호</th>
											<th>이름</th>
											<th>성별</th>
											<th>양력/음력</th>
											<th>출생일</th>
											<th>출생시</th>
										</tr>
										</thead>
										<tbody>
											<c:forEach var="data" items="${humanlist}" varStatus="status">
												<tr>
													<td><a href="${pageContext.request.contextPath}/human/viewhuman.do?humanno=${data.humanno}">${data.humanno}</a></td>
													<td>${data.name}</td>
													<td>${data.sex}</td>
													<td>${data.sunmoon}</td>
													<td>${data.birthyear}-${data.birthmonth}-${data.birthday}</td>
													<td>${data.birthhour}:${data.birthminute}</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
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