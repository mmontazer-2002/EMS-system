<%@ taglib prefix="s" uri="/struts-tags" %>

<form action="saveEmployee" method="post">

Name: <input type="text" name="employee.name"/>
Email: <input type="text" name="employee.email"/>
Department: <input type="text" name="employee.department"/>
Salary: <input type="text" name="employee.salary"/>

<input type="submit" value="Save"/>

</form>