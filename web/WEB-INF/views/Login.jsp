<%--
  Created by IntelliJ IDEA.
  User: 19931
  Date: 2021/4/5
  Time: 10:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>

<h1>Login</h1>
<%
    if(!(request.getAttribute("message") == null)) {
        out.println(request.getAttribute("message"));
    }
%>
<form method="post" action="${pageContext.request.contextPath}/Login">
    Username:<input type="text" id="username" name="username"><br/>
    Password:<input id="password" name="password" type="password"><br/>
    <input type="submit" value="Login"/>
</form>

<%@include file="footer.jsp"%>
