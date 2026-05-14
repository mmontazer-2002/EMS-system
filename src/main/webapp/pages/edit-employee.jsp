<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head>

    <title>Edit Employee</title>

</head>

<body>
<h1>Edit Employee</h1>

<s:actionerror/>

<s:form action="updateEmployee">

    <!-- hidden id -->

    <s:hidden
            name="employee.id"/>

    <s:textfield
            name="employee.name"
            label="Name"/>

    <s:textfield
            name="employee.email"
            label="Email"/>

    <s:textfield
                name="employee.department"
                label="Department"/>

    <s:textfield
            name="employee.salary"
            label="Salary"/>

    <s:submit
            value="Update Employee"/>

</s:form>

<br/>

<a href="dashboard"> Back To Dashboard </a>

</body>

</html>

