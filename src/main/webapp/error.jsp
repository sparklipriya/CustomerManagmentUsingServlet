public class ErrorHandlingFilter implements Filter {

@Override
public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
try {
chain.doFilter(request, response);
} catch (IOException e) {
e.printStackTrace();
response.sendRedirect("error.jsp");
}
}
}
