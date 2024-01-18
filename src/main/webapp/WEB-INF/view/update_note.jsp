<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/view/header.jsp"%>

<div class="container">
	<h5 class="text-center text-primary mt-3">${ message }</h5>
	<div id="note-container">
		<form id="updateNoteForm" name="updateNoteForm" action="/Note/note/update/${ noteBook.bookId }" method="post">
			<h1 class="display-4">個人記事本</h1>
			<div class="mb-3">
				<label for="note-title" class="form-label"><h3>標題:</h3></label>
				<input type="text" class="form-control" id="subject" name="subject" placeholder="輸入標題" required value="${ noteBook.subject }">
			</div>
			<div class="mb-3">
				<label for="note-content" class="form-label"><h3>內容:</h3></label>
				<textarea class="form-control" id="context" name="context" placeholder="輸入內容" required>${ noteBook.context }</textarea> 
			</div>

			<button class="btn btn-success" id="save-button" name="save-button" type="submit" onclick="upateNoteBook('${noteBook.subject}','${noteBook.context}','${ noteBook.bookId }')">修改記事</button>
		</form>
	</div>
</div>
<%@ include file="/WEB-INF/view/footer.jsp"%>

<script>
	
	function upateNoteBook(subject, context, bookId) {
		if(window.confirm('記事本更新成功\n' + subject + '\n' + context)) {
			window.location = '/Note/note/update/'+ bookId;
		}
	}
	
</script>

<style>
	body {
		font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
		background-color: #f4f4f4;
	}
	
	#note-container {
		max-width: 600px;
		margin: 80px auto;
		background-color: #5088977e;
		padding: 20px;
		border-radius: 10px;
		box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
		text-align: center;
	}
	
	#subject, #context {
		margin-bottom: 10px;
	}
	
	#context {
		width: 100%;
		height: 300px;
		resize: none;
		padding: 10px;
		box-sizing: border-box;
		border: 1px solid #ccc;
		border-radius: 5px;
	}
	
	#save-button {
		margin-top: 10px;
	}
</style>