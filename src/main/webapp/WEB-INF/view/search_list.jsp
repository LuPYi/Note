<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file="/WEB-INF/view/header.jsp"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>
 <h1 class="fw-bold m-3 text-primary">查詢結果</h1>
 <c:forEach var="noteBook" items="${notes}">
     
     	<div class="card m-2 border-info border-3" style="width: 15rem;">
			<div class="card-body">
				<h5 class="card-title fw-bold">${noteBook.subject}</h5>
				<p class="card-text">${noteBook.context}</p>
				<button class="btn btn-success position-absolute bottom-0 end-0" onclick="window.location.href='/Note/note/update/${ noteBook.bookId }'">修改</button>
	  		</div>
		</div>
     
 </c:forEach>

<%@ include file="/WEB-INF/view/footer.jsp"%>