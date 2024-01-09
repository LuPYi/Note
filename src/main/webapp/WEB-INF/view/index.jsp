<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<%@ include file="/WEB-INF/view/header.jsp"%>
<html>
<head>
<meta charset="UTF-8">
<title>個人記事本</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ"
	crossorigin="anonymous"></script>
</head>
<body>
	<div class="container mt-4">
		<div class="jumbotron">
			<h1 class="display-4">歡迎來到我的個人記事本</h1>
			<p class="lead">這是一個簡單的首頁，你可以在這裡添加和管理你的記事。</p>
			<hr class="my-4">
			<p>開始記錄你的想法和事件吧！</p>
			<div>
				<a class="btn btn-primary btn-lg" href="/Note/note/addNote" role="button">開始記錄</a>
			</div>
		</div>

		<div class="container">
			<div class="row">
				<div class="col-md-8 mt-xl-4">
					<h2>最新記事</h2>
					<div class="accordion" id="accordionExample">
					    <c:forEach items="${ noteBooks }" var="noteBook">
					    	<div class="accordion-item">
								<h2 class="accordion-header" id="headingOne">
									<button class="accordion-button collapsed" type="button"
										data-bs-toggle="collapse" data-bs-target="#collapse${ noteBook.bookId }">
										${ noteBook.subject }</button>
								</h2>
								<div id="collapse${ noteBook.bookId }" class="accordion-collapse collapse" data-bs-parent="#accordionExample">
									<div
										class="accordion-body d-flex justify-content-between align-items-center">
										${ noteBook.context }
										<button class="btn btn-danger" type="submit">刪除</button>
									</div>
								</div>
							</div>
					    </c:forEach>
					</div>
				</div>
				<div class="col-md-4 mt-xl-4">
					<h2>簡介</h2>
					<p>這裡是我的個人記事本，我會在這裡分享一些有趣的事情和心得。</p>
				</div>
			</div>
		</div>
	</div>
</body>
</html>

<%@ include file="/WEB-INF/view/footer.jsp"%>
