<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ForMe
  Date: 2019/3/27
  Time: 12:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test</title>
    <meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=0">
</head>
<body>
<c:forEach var="users" items="${list}">
    <strong>${users.username}</strong>
    <strong>${users.password}</strong>
</c:forEach>
</body>
</html>
