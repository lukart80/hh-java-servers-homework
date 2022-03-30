import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

public class ClearCounterFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String clearHeader = httpServletRequest.getHeader("hh-auth");
        if (clearHeader == null || clearHeader.length() < 10 ) {
            throw new IllegalArgumentException();
        }



        filterChain.doFilter(servletRequest, servletResponse);
    }
}
