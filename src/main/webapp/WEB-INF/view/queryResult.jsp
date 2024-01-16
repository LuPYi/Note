<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>查询结果</title>
</head>
<body>
    <h2>查询结果</h2>
    <c:forEach var="note" items="${notes}">
        <p>${note.subject}: ${note.context}</p>
    </c:forEach>
</body>
</html>
