<%@ taglib prefix="s" uri="/struts-tags" %>

<html>

<head>
    <title>Employee Dashboard</title>
</head>

<body>

<h1>Employee Dashboard</h1>

<!-- ADD EMPLOYEE -->

<h2>Add Employee</h2>

<s:form action="saveEmployee">

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

    <s:submit value="Save Employee"/>

</s:form>

<hr/>

<!-- EMPLOYEE TABLE -->

<h2>Employee List</h2>

<table border="1">

    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Department</th>
        <th>Salary</th>
        <th>Actions</th>
    </tr>

    <s:iterator value="employees">

        <tr>

            <td>
                <s:property value="id"/>
            </td>

            <td>
                <s:property value="name"/>
            </td>

            <td>
                <s:property value="email"/>
            </td>

            <td>
                <s:property value="department"/>
            </td>

            <td>
                <s:property value="salary"/>
            </td>

            <td>

                <a href="editEmployee?id=
                    <s:property value='id'/>">

                    Edit

                </a>

                <a href="deleteEmployee?id=
                    <s:property value='id'/>">

                    Delete

                </a>

            </td>

        </tr>

    </s:iterator>

</table>

</body>

</html>