<%@ page contentType="text/html;"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<body>
<h2>Bookmark Home Page</h2>


<h4>What would you like to do?</h4>

<%--<span class="error">${messages.error}</span>--%>


<a href="<s:url action="User/Login"/>">Login here</a>
<br/>
<a href="<s:url action="Test"/>">Register here</a>




</body>
</html>
