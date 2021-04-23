<%--
  Created by IntelliJ IDEA.
  User: 19931
  Date: 2021/4/23
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.Pengyanlong.model.User" %>
<%@include file="header.jsp"%>

<h1>User Update</h1>
<%
    User u = (User) session.getAttribute("user");
%>
<form method="post" action="${pageContext.request.contextPath}/updateUser">
    <input type="hidden" name="id" value="<%=u.getId()%>">
    Username:<input type="text" id="username" name="username" value="<%=u.getUsername()%>"><br/>
    Password:<input id="password" name="password" type="password" value="<%=u.getPassword()%>"><br/>
    E-mail:<input id="email" name="email" type="email" value="<%=u.getEmail()%>"><br/>

    Gender:
    <input name="sex" type="radio" value="male" <%="male".equals(u.getGender()) ? "checked":""%>>male
    <input name="sex" type="radio" value="female" <%="male".equals(u.getGender()) ? "checked":""%>>female<br/>

    Birth:<input type="text" id="birth" name="birth" value="<%=u.getBirthDate()%>"><br/>
    <input type="submit" value="Save Changes"/>
</form>

<%@include file="footer.jsp"%>