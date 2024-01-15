<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="/WEB-INF/view/header.jsp"%>

<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>個人記事本</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
<style>
body {
	font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
	background-color: #f4f4f4;
}

#note-container {
	max-width: 600px;
	margin: 80px auto;
	background-color: #fff;
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
</head>
<body>

	<div class="container">
		<h5 class="text-center text-primary mt-3">${ message }</h5>
		<div id="note-container">
			<form id="NoteForm" name="NoteForm">
				<h1 class="display-4">個人記事本</h1>
				<div class="mb-3">
					<label for="note-title" class="form-label"><h3>標題:</h3></label> <input
						type="text" class="form-control" id="subject" name="subject"
						placeholder="輸入標題" required>
				</div>
				<div class="mb-3">
					<label for="note-content" class="form-label"><h3>內容:</h3></label>
					<textarea class="form-control" id="context" name="context"
						placeholder="輸入內容" required></textarea>
				</div>

				<button class="btn btn-success" id="save-button" name="save-button"
					type="submit">保存記事</button>
			</form>
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

<script>

    document.addEventListener("DOMContentLoaded", function() {

        var form = document.getElementById("NoteForm");
        var button = document.getElementById("save-button");

        form.addEventListener("submit", function(event) {
            event.preventDefault();
           
            var subject = document.getElementById("subject").value;
            var context = document.getElementById("context").value;

            fetch("/Note/note/addNote", {
                method: "POST",
                headers: {
                   "content-type": "application/json"
                },
                body: JSON.stringify({
                	subject,context
                })
            })
            .then(response => response.json())
            .then(json => {
            	//console.log(json);
                alert(json);
                window.location = "/Note/note/";
            });

        });
    });
</script>

</body>
</html>
<%@ include file="/WEB-INF/view/footer.jsp"%>