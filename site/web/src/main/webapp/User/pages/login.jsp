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


<s:form action="Welcome">
    <s:textfield name="email" label="Email" />
    <s:password name="password" label="Password" />
    <s:submit />
</s:form>

</body>
</html>