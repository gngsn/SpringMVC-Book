<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Book </title>
</head>
<body>

<h2> Title: ${book.title}</h2>
<h2> Author: ${book.author}</h2>
<h2> Genre: ${book.genre}</h2>
<h2> Price: ${book.price}</h2>
<h2> Pubdate: <fmt:formatDate pattern="yyyy/MM/dd" value="${book.pubdate}" /> </h2>

</body>
</html>