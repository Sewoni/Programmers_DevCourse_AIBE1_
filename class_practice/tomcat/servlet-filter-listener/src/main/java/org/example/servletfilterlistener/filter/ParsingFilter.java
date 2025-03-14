package org.example.servletfilterlistener.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;

@WebFilter("/data/*")
public class ParsingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
//        HttpServletResponse response = (HttpServletResponse) resp;
        System.out.println(request.getPathInfo());
        String[] params = request.getPathInfo().split("/");
        System.out.println(Arrays.toString(params));
        if (params.length > 1) {
            for (int i = 1; i < params.length; i++) {
                req.setAttribute("param%d".formatted(i), params[i]);
            }
        }
        chain.doFilter(req, resp);
    }
}