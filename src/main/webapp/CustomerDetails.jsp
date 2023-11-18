<!DOCTYPE html>
<html>
<head>
<title>Customer Details</title>
</head>
<body>
<h1>Customer Details</h1>
<%
// Get the customer's UUID from the request
String uuid = request.getParameter("uuid");

// Get the bearer token from the previous request
String bearerToken = request.getParameter("dGVzdEBzdW5iYXNlZGF0YS5jb206VGVzdEAxMjM=");

// Make a GET request to the customer details API
URL url = new URL("https://qa2.sunbasedata.com/sunbase/portal/api/assignment.jsp?cmd=get_customer&uuid=" + uuid);
HttpURLConnection connection = (HttpURLConnection) url.openConnection();
connection.setRequestProperty("Authorization", "Bearer " + bearerToken);
connection.setRequestMethod("GET");

// Read the response from the API
BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
String response = reader.readLine();

// Parse the JSON response into a customer object
Customer customer = new Gson().fromJson(response, Customer.class);

// Display the customer details
%>
<p>First Name: <%= customer.getFirstName() %></p>
<p>Last Name: <%= customer.getLastName() %></p>
<p>Email: <%= customer.getEmail() %></p>
<p>Phone: <%= customer.getPhone() %></p>
</body>
</html>
