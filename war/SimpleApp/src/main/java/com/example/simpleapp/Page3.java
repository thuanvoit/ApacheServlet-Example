package com.example.simpleapp;

import java.io.*;
import java.util.Map;
import java.util.Random;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "page3", value = "/page3")
public class Page3 extends HttpServlet {
    private String title;

    public void init() {
        title = "Page 2 - Randomize An Image";
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

        Random rand = new Random();
        int randomIndex = rand.nextInt(Nav.images.size());

        Object firstKey = Nav.images.keySet().toArray()[randomIndex];

        out.println("<div class='card'>");
        out.println("<img src='" + Nav.getImageUrl(request, Nav.images.get(
                firstKey)) + "' alt='" + firstKey + "'/>");

        out.println("<p>" + firstKey + "</p>");
        out.println("</div>");

        out.println("</div>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}
