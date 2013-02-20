<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head></head>
<body>
<h1>Struts 2 Hello World Example</h1>

<h4>
    Hello
    <s:property value="loginForm.email" />
    <s:property value="registerForm.email"/>
</h4>

</body>
</html>