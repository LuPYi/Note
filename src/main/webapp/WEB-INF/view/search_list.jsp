<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file="/WEB-INF/view/header.jsp"%>

 <h2>查詢結果</h2>
 <c:forEach var="noteBook" items="${notes}">
     <p>${noteBook.subject}: ${noteBook.context}
     	<button class="btn btn-success me-1" onclick="window.location.href='/Note/note/update/${ noteBook.bookId }'">修改</button>
     </p>
 </c:forEach>
 
<%@ include file="/WEB-INF/view/footer.jsp"%>