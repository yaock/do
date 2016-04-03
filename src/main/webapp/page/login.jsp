<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Hello</title>
    </head>
    <body>
        <c:if test="${empty error}">
            <span style="color: red"><c:out value="${error}"/></span>
        </c:if>
        <form action="/loginCheck" method="post">
            用户名:<input type="text" name="userName"><br>
            密  码:<input type="password" name="password"><br>
            <input type="submit" value="登录"><input type="reset" value="重置">
        </form>
    </body>
</html>