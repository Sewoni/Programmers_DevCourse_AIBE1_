package org.example.servletfilterlistener;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/data/*")
public class DataServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        String message = "할로! ";
        StringBuilder builder = new StringBuilder();
        for (int i = 1;;i++) {
            String param = (String) request.getAttribute("param%d".formatted(i));
            if (param == null) {
                break;
            }
            builder.append(param);
            builder.append("\n");
//            message += param + ",";
        }
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
//        out.println("<h1>" + message + "</h1>");
        out.println("<h1>" + builder + "</h1>");
        out.println("</body></html>");
    }

}