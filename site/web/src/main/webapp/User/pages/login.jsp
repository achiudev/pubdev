<%@ page contentType="text/html;"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head></head>
<body>
<h1>Struts 2 Hello World Example</h1>

<s:form action="Welcome">
    <s:textfield name="email" label="Email" />
    <s:password name="password" label="Password" />
    <s:submit />
</s:form>

</body>
</html>