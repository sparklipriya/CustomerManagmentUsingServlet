<!DOCTYPE html>
<html>
<head>
<title>Delete Customer</title>
</head>
<body>
<h1>Delete Customer</h1>
<p>Are you sure you want to delete the customer?
<form action="https://qa2.sunbasedata.com/sunbase/portal/api/assignment.jsp" method="post">
<input type="hidden" name="cmd" value="delete">
<input type="hidden" name="uuid" value="<%= customer.getUuid() %>">
<input type="submit" value="Delete Customer">
</form>
</body>
</html>
