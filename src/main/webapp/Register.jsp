<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>註冊</title>
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

        .register-container {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 300px;
            text-align: center;
        }

        .register-container h2 {
            margin-bottom: 20px;
            color: #333;
        }

        .register-container label {
            display: block;
            margin-bottom: 8px;
            color: #555;
        }

        .register-container input {
            width: 100%;
            padding: 8px;
            margin-bottom: 16px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        .btn1 {
            background-color: #4caf50;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        .btn1:hover {
            background-color: #45a049;
        }

        .btn2 {
            background-color: #FF0000;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        .btn2:hover {
            background-color: #DC143C;
        }
    </style>
</head>
<body>

    <div class="register-container">
        <h2>註冊</h2>
        
         <!-- Display error message if it exists -->
        <% String errorMessage = (String)request.getAttribute("errorMessage"); %>
        <% if (errorMessage != null && !errorMessage.isEmpty()) { %>
            <p style="color: red;"><%= errorMessage %></p>
        <% } %>
        
        <form action="RegistrationServlet" method="post">
            <label for="name">名稱:</label>
            <input type="text" id="name" name="name" placeholder="請輸入名稱" required>
            
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" placeholder="請輸入Email" required>

            <label for="password">密碼:</label>
            <input type="password" id="password" name="password" placeholder="請輸入密碼" required>

            <label for="confirm-password">確認密碼:</label>
            <input type="password" id="confirm-password" name="confirm-password" placeholder="請再次輸入密碼" required>

            <button class="btn1" type="submit">註冊</button>
            <button class="btn2" type="button" onclick="location.href='login.jsp';">返回登入</button>
        </form>
    </div>

</body>
</html>
