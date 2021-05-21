<%--
  Created by IntelliJ IDEA.
  User: 19931
  Date: 2021/4/5
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%!int count=0;%>
<%!int getCount() {
return ++count;
};%>
This Page count is now(using count()) : <%out.println(getCount());%>

</body>
</html>
