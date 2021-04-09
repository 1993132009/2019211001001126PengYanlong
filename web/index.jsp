<%--
  Created by IntelliJ IDEA.
  User: 19931
  Date: 2021/3/6
  Time: 10:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="header.jsp"%>
<h1>-Hello world!!!-</h1>

<h2>welcome to my home page</h2>
<form method="get" target="_blank" action="search">
    <input type="text" name="txt" size="30">
    <select name="search">
        <option value="baidu">Baidu</option>
        <option value="bing">Bing</option>
        <option value="google">Google</option>
    </select>
    <input type="submit" value="Search">
</form>

<br/>
<a href="Myjsp.jsp">HelloWorldSrevlet</a>
<br/>
<a href="MMyjsp.jsp">MMyjspSrevlet</a>
<br/>
<a href="config">ConfigDemoSrevlet</a>
<br/>
<a href="count.jsp">PageCount</a>
<br/>
<a href="Register.jsp">RegisterSrevlet</a>
<br/>
<a href="Login.jsp">LoginSrelet</a>
<br/>

<br/>
<br/>
<a href="/redirect">RedirectSrelet</a>
<br/>
<a href="/search">SearchSrelet</a>
<br/>


<%@include file="footer.jsp"%>