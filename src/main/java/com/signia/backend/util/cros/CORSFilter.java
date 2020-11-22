package com.signia.backend.util.cros;


import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class CORSFilter extends GenericFilterBean implements Filter {

    private final List<String> allowedOrigins = Collections.singletonList("http://localhost:4200");

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        // Lets make sure that we are working with HTTP (that is, against HttpServletRequest and HttpServletResponse objects)
        if (req instanceof HttpServletRequest && res instanceof HttpServletResponse) {
            HttpServletRequest request = (HttpServletRequest) req;
            HttpServletResponse response = (HttpServletResponse) res;

            // Access-Control-Allow-Origin
            String origin = request.getHeader("Origin");
            response.setHeader("Access-Control-Allow-Origin", allowedOrigins.contains(origin) ? origin : "");
            response.setHeader("Vary", "Origin");

            // Access-Control-Max-Age
            response.setHeader("Access-Control-Max-Age", "3600");

            // Access-Control-Allow-Credentials
            response.setHeader("Access-Control-Allow-Credentials", "true");

            // Access-Control-Allow-Methods
            response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");

            // Access-Control-Allow-Headers
            response.setHeader("Access-Control-Allow-Headers",
                    "Origin, X-Requested-With, Content-Type, Accept, " + "X-CSRF-TOKEN");
        }

        chain.doFilter(req, res);
    }
}
