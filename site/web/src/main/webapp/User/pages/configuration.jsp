<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: achiu
  Date: 22/02/13
  Time: 4:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <h1>Configuration</h1>

    <s:form action='Configuration' namespace="/User">
        <s:textfield name="customerBookmark.bookmark_location" key="configuration.bookmark.url.title"/>
        <s:submit/>
    </s:form>
</body>
</html>