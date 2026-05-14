<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
    <title>Login</title>
</head>

<body>

<h2>Employee Management Login</h2>

<s:form action="doLogin">

    <s:textfield
            name="username"
            label="Username"/>

    <s:password
            name="password"
            label="Password"/>

    <s:submit value="Login"/>

</s:form>

<s:actionerror/>

</body>
</html>
