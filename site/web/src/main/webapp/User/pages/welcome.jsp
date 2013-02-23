<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head></head>
<body>
<h1>Struts 2 Hello World Example</h1>

<h4>
    Hello
    <s:set var="Customer" value="%{#session.CUSTOMER_BEAN}"/>
    <s:property value="%{#Customer.firstName}" />
    <s:property value="%{#Customer.lastName}" />
</h4>

<a href="<s:url action='Menu' namespace="/Bookmark" />" >Bookmark Menu</a>
<%--<a href="<s:url action='Configuration' namespace="/User" />">My Configuration</a>
<a href="<s:url action='Profile' namespace="/User" />">My Profile</a>--%>
</body>
</html>