public class CustomerListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bearerToken = req.getHeader("Authorization");

        // Make a GET request to the customer list API
        URL url = new URL("https://qa2.sunbasedata.com/sunbase/portal/api/assignment.jsp?cmd=get_customer_list");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Authorization", bearerToken);

        // Read the response from the API
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String responseJson = reader.readLine();

        // Parse the JSON response into a customer list object
        CustomerList customerList = new Gson().fromJson(responseJson, CustomerList.class);

        // Set the customer list as an attribute in the request
        req.setAttribute("customerList", customerList);

        // Forward the request to the customer list JSP page
        req.getRequestDispatcher("customerList.jsp").forward(req, resp);
    }
}
