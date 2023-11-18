<!DOCTYPE html>
<html>
<head>
<title>Customer List</title>
</head>
<body>
<h1>Customer List</h1>
<table border="1">
<tr>
<th>First Name</th>
<th>Last Name</th>
<th>Email</th>
<th>Phone</th>
</tr>
<%
// Get the bearer token from the previous request
String bearerToken = request.getParameter("dGVzdEBzdW5iYXNlZGF0YS5jb206VGVzdEAxMjM=");

// Make a GET request to the customer list API
URL url = new URL("https://qa2.sunbasedata.com/sunbase/portal/api/assignment.jsp?cmd=get_customer_list");
HttpURLConnection connection = (HttpURLConnection) url.openConnection();
connection.setRequestProperty("Authorization", "Bearer " + bearerToken);
connection.setRequestMethod("GET");

// Read the response from the API
BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
String response = reader.readLine();

// Parse the JSON response into a list of customers
List<Customer> customers = Arrays.asList(new Gson().fromJson(response, Customer[].class));

// Iterate over the list of customers and display them in the table
for (Customer customer : customers) {
%>
<tr>
<td><%= customer.getFirstName() %></td>
<td><%= customer.getLastName() %></td>
<td><%= customer.getEmail() %></td>
<td><%= customer.getPhone() %></td>
</tr>
<%
}
%>
</table>
</body>
</html>
