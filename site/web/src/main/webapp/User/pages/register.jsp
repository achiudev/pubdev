<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 2/18/13
  Time: 11:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <h1>Registration Page</h1>

    <s:if test="hasActionErrors()">
        <div class="errors">
            <s:actionerror/>
        </div>
    </s:if>

    <s:form action="Register" namespace="/User">
        <s:textfield name="registerDAO.email" key="global.email"></s:textfield>
        <s:textfield name="registerDAO.first_name" key="global.first_name"></s:textfield>
        <s:textfield name="registerDAO.last_name" key="global.last_name"></s:textfield>
        <s:textfield name="registerDAO.country" key="global.country"></s:textfield>
        <s:password name="registerDAO.password" key="global.password"></s:password>
        <s:password name="registerDAO.verify_password" key="global.verify_password"></s:password>
        <s:submit/>
    </s:form>
</body>
</html>