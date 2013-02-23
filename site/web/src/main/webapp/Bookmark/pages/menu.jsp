<%--
  Created by IntelliJ IDEA.
  User: achiu
  Date: 21/02/13
  Time: 12:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
    <title></title>
</head>
<body>
<s:iterator value="#request.CUSTOMER_BOOKMARKS">
    <s:property value = "description"/>
    <s:property value = "link"/>
    <br/>
</s:iterator>

</body>
</html>