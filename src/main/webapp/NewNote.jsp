<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="/WEB-INF/view/header.jsp" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>個人記事本</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f4f4f4;
        }

        #note-container {
            max-width: 600px;
            margin: 80px auto; /* Adjust the top margin to move the container down */
            background-color: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            text-align: center; /* Center text within the container */
        }

        #note-title,
        #note-content {
            margin-bottom: 10px;
        }
        
        #note-content {
            width: 100%; /* Make the textarea fill the entire width */
            height: 300px; /* Increase the height of the textarea */
            resize: none; /* Disable textarea resizing */
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
    <div id="note-container">
    <form action="NoteServlet" method="post">
        <h1 class="display-4">個人記事本</h1>
        <div class="mb-3">
            <label for="note-title" class="form-label"><h3>標題:</h3></label>
            <input type="text" class="form-control" id="note-title" placeholder="輸入標題" required>
        </div>
        <div class="mb-3">
            <label for="note-context" class="form-label"><h3>內容:</h3></label>
            <textarea class="form-control" id="note-content" placeholder="輸入內容" required></textarea>
        </div>
        <button id="save-button" class="btn btn-success" type="submit">保存記事</button>
    </div>
    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
<%@ include file="/WEB-INF/view/footer.jsp"%>