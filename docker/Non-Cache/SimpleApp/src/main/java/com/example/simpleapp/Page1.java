package com.example.simpleapp;

import java.io.*;
import java.util.Map;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "page1", value = "/page1")
public class Page1 extends HttpServlet {
    private String title;

    public void init() {
         title = "Page 1 - Loading All Images";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println(Nav.writeHeader(title));
        out.println("<body>");

        out.println(Nav.navBar());

        out.println("<h1>" + title + "</h1>");

        out.println("<div class='imagesContainer'>");

        for (Map.Entry<String, String> image : Nav.images.entrySet()) {
            out.println("<div class='card'>");
            out.println("<img src='" + Nav.getObjectUrl(request, image.getValue()) + "' alt='" + image.getKey() + "'/>");
            out.println("<p>"+image.getKey()+"</p>");
            out.println("</div>");
        }
        out.println("</div>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}
