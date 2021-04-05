<%--
  Created by IntelliJ IDEA.
  User: 19931
  Date: 2021/3/13
  Time: 10:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="header.jsp"%>
    <a href="hello"> go to hello </a>
    <form method="post" action="hello">
        Name :<input type="text" name="name"> <br/>
        Id :<input type="text" name="id"> <br/>
        <input type="submit" value="Send data to server"/>
    </form>
<%@include file="footer.jsp"%>
