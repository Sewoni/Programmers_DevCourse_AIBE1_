package org.example.mytarocard.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public abstract class Controller extends HttpServlet {

    protected void view(HttpServletRequest req,
                        HttpServletResponse resp,String name) throws
            ServletException, IOException {
        String prefix="/WEB-INF/views/";
        String suffix="jsp";

        req.getRequestDispatcher("%s/%s.%s").formatted(prefix,name,suffix)).forward(req,resp);
    }
}
