package com.example.simpleapp;

import java.io.*;
import java.util.Map;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "page2", value = "/page2")
public class Page2 extends HttpServlet {
    private String title;

    public void init() {
        title = "Page 2 - Loading 4 Images";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println(Nav.writeHeader(title));
        out.println("<body>");

        out.println("<div class='buttonContainer'>");

        for (Map.Entry<String, String> pageInfo : Nav.pages.entrySet()) {
            out.println("<a href='" + pageInfo.getKey() + "'>" + pageInfo.getValue() + "</a> ");
        }

        out.println("</div>");

        out.println("<h1>" + title + "</h1>");

        out.println("<div class='imagesContainer'>");

        // display first 4 images

        String[] images = new String[]{
                "Vietnam",
                "Waterfall",
                "Bird",
                "Aurora"
        };

        for (int i = 0; i <= images.length; i++) {
            out.println("<div class='card'>");
            out.println("<img src='" + Nav.getImageUrl(request, Nav.images.get(images[i])) + "' alt='pic" + i + "'/>");
            out.println("<p>"+images[i]+"</p>");
            out.println("</div>");
        }


        out.println("</div>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}
