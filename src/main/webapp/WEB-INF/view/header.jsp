<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>個人記事本</title>
		<link rel="shortcut icon" href="/Note/images/edit.png" type="image/x-icon"/>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
	</head>
	<body>
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
			<div class="container-fluid">
				<a class="navbar-brand text-light fs-2" href="#">個人記事本</a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0">
						<li class="nav-item"><a class="nav-link active text-light"
							aria-current="page" href="/Note/note/">首頁</a></li>
						<li class="nav-item"><a class="nav-link text-light"
							href="/Note/note/addNote">記事本</a></li>
					</ul>
					<form class="d-flex ms-lg-auto" action="/Note/note/query" method="get">
						<input class="form-control me-2" type="search" placeholder="Search" name="keyword">
						<button class="btn btn-outline-success" type="submit">Search</button>
					</form>
					<a class="btn btn-danger ms-3 me-1" href="/Note/note/logout" role="button">登出</a>
					<p class="text-white m-2 fs-5 border border-light border-3 p-2">😎${ user.name }</p>
				</div>
			</div>
		</nav>
	</body>
</html>