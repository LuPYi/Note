<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>個人記事本登入</title>
        <link rel="shortcut icon" type="image/x-icon" href="./images/icon.png">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f4f4f4;
                margin: 0;
                display: flex;
                align-items: center;
                justify-content: center;
                height: 100vh;
            }

            .login-container {
                background-color: #fff;
                padding: 20px;
                border-radius: 8px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                width: 300px;
                text-align: center;
            }

            .login-container h2 {
                margin-bottom: 20px;
                color: #333;
            }

            .login-container label {
                display: block;
                margin-bottom: 8px;
                color: #555;
            }

            .login-container input {
                width: 100%;
                padding: 8px;
                margin-bottom: 16px;
                box-sizing: border-box;
                border: 1px solid #ccc;
                border-radius: 4px;
            }
        </style>
    </head>
    <body>
        <div class="login-container">
            <h2>個人記事本登入</h2>
            <form action="/Note/note/login" method="post">
                <label for="username">使用者名稱:</label>
                <input type="text" id="username" name="username" placeholder="請輸入帳號" required>
                
                <label for="password">密碼:</label>
                <input type="password" id="password" name="password" placeholder="請輸入密碼" required>

                <div>
                    <button type="submit" class="btn btn-success btn-lg">登入</button>
                    <a class="btn btn-danger btn-lg" href="/Note/note/register" role="button">註冊</a>
                </div>
            </form>
            <% String errorMessage = (String)request.getAttribute("errorMessage");
           if (errorMessage != null) { %>
            <p style="color: red;"><%= errorMessage %></p>
      		  <% } %>
        </div>
    </body>
</html>
