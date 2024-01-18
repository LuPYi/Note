<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file="/WEB-INF/view/header.jsp"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>
 <h1 class="fw-bold m-3" style="color:#1fafaf;">查詢結果</h1>
	 <div class="row w-100 border bg-primary d-flex justify-content-start">
		 <c:forEach var="noteBook" items="${notes}" varStatus="loop">
	        <div class="col-2 m-3">
	        	<div class="card m-2 border-info border-3" style="width: 20rem;">
				<div class="card-body">
						<h5 class="card-title fw-bold">${noteBook.subject}</h5>
						<p class="card-text">${noteBook.context}</p>
						<div class="d-grid gap-2 d-md-flex justify-content-md-end">
							<button class="btn btn-success" onclick="window.location.href='/Note/note/update/${ noteBook.bookId }'">修改</button>
							<button class="btn btn-danger" onclick="deleteNoteBook('${noteBook.subject}','${ noteBook.bookId }')">刪除</button>
						</div>
			  		</div>
				</div>
	        </div>
		 </c:forEach>
	</div>
     <c:if test="${isEmpty}">
        <p class="fs-2 fw-bold text-danger m-3">查無記事本</p>
     </c:if>

<%@ include file="/WEB-INF/view/footer.jsp"%>

<script>
	
	function deleteNoteBook(subject,bookId) {
		if(window.confirm('確定要刪除嗎？' + subject)) {
			window.location = '/Note/note/delete/'+ bookId;
		}
	}

</script>


<style>

</style>