
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 2/17/13
  Time: 11:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
    <title></title>
    <%--<META HTTP-EQUIV="Refresh" CONTENT="1;URL=/User/Home.action">--%>
</head>
<body>
    <h1>Struts 2 Hello World Example</h1>

    <s:form action="Home" namespace="/User">
        <s:submit value="Login" name="login"></s:submit>
        <s:submit value="Register" name="register"></s:submit>
    </s:form>
</body>
</html>