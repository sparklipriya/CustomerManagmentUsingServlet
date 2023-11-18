public class CustomerDetailsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uuid = req.getParameter("uuid");
        String bearerToken = req.getHeader("Authorization");

        // Make a GET request to the customer details API
        URL url = new URL("https://qa2.sunbasedata.com/sunbase/portal/api/assignment.jsp?cmd=get_customer&uuid=" + uuid);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Authorization", bearerToken);

        // Read the response from the API
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String responseJson = reader.readLine();

        // Parse the JSON response into a customer object
        Customer customer = new Gson().fromJson(responseJson, Customer.class);

        // Set the customer as an attribute in the request
        req.setAttribute("customer", customer);

        // Forward the request to the customer details JSP page
        req.getRequestDispatcher("customerDetails.jsp").forward(req, resp);
    }
}
