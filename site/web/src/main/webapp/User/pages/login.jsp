<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<h1>Struts 2 Hello World Example</h1>

<s:if test="hasActionErrors()">
    <div class="errors">
        <s:actionerror/>
    </div>
</s:if>


<s:form action="Login" namespace="/User">
    <s:textfield name="loginForm.email" key="global.email"/>
    <s:password name="loginForm.password" key="global.password" />
    <s:submit />
</s:form>

<s:form action="Index" namespace="/">
    <s:submit name="index" value="Index"/>
</s:form>

</body>
</html>