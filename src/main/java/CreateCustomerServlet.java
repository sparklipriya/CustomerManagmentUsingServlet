public class CreateCustomerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String bearerToken = req.getHeader("Authorization");

        // Create a JSON body for the customer creation request
        String jsonBody = "{\"first_name\": \"" + firstName + "\", \"last_name\": \"" + lastName + "\", \"email\": \"" + email + "\", \"phone\": \"" + phone + "\"}";

        // Make a POST request to the create customer API
        URL url = new URL("https://qa2.sunbasedata.com/sunbase/portal/api/assignment.jsp");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Authorization", bearerToken);

        // Write the JSON body to the request
        OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
        writer.write(jsonBody);
        writer.flush();
        writer.close();

        // Read the response from the API
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String responseJson = reader.readLine();

        // Handle the response based on the status code
        if (connection.getResponseCode() == 201) {
            // Customer created successfully
            resp.sendRedirect("customerList.jsp");
        } else {
            // Error creating customer
            resp.sendRedirect("error.jsp");
        }
    }
}
