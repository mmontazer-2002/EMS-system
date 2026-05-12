<%@ taglib prefix="s" uri="/struts-tags" %>
<html>

<head>
    <title>Login</title>
</head>

<body>

<h2>Login Page</h2>

<s:form action="login">

    <s:textfield
            name="username"
            label="Username"/>

    <s:password
            name="password"
            label="Password"/>

    <s:submit value="Login"/>

</s:form>

</body>

</html>
