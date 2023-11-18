public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String loginId = req.getParameter("login_id");
        String password = req.getParameter("password");

        // Make a POST request to the authentication API
        URL url = new URL("https://qa2.sunbasedata.com/sunbase/portal/api/assignment_auth.jsp");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");

        // Write the JSON body to the request
        String jsonBody = "{\"login_id\": \"" + loginId + "\", \"password\": \"" + password + "\"}";
        OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
        writer.write(jsonBody);
        writer.flush();
        writer.close();

        // Read the response from the API
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String responseJson = reader.readLine();

        // Parse the JSON response into a token object
        Token token = new Gson().fromJson(responseJson, Token.class);

        // Store the token in the session
        req.getSession().setAttribute("token", token.getToken());

        // Redirect the user to the customer list page
        resp.sendRedirect("customerList.jsp");
    }
}
