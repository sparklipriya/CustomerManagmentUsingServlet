<!DOCTYPE html>
<html>
<head>
    <title>Update Customers</title>
</head>
<body>
    <h1>Update Customer</h1>

    <form action="UpdateCustomerServlet" method="post">
        <input type="hidden" id="uuid" name="uuid" value="${customer.uuid}">

        <label for="firstName">First Name:</label>
        <input type="text" id="firstName" name="firstName" value="${customer.firstName}" required>
        <br>

        <label for="lastName">Last Name:</label>
        <input type="text" id="lastName" name="lastName" value="${customer.lastName}" required>
        <br>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" value="${customer.email}" required>
        <br>

        <label for="phone">Phone:</label>
        <input type="tel" id="phone" name="phone" value="${customer.phone}" required>
        <br>

        <input type="submit" value="Update Customer">
    </form>

    <a href="customerList.jsp">Back to Customer List</a>
</body>
</html>
