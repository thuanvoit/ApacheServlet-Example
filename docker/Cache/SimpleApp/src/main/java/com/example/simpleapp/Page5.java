package com.example.simpleapp;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import java.util.Random;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "page5", value = "/page5")
public class Page5 extends HttpServlet {
    private String title;

    public void init() {
        title = "Page 5 - Random 1,000 Integers";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");

        // download the text file and extract to string

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println(Nav.writeHeader(title));
        out.println("<body>");

        out.println(Nav.navBar());

        out.println("<h1>" + title + "</h1>");
        
        out.println("<div>" + getRandomIntegers() + "</div>");

        out.println("</body></html>");
    }

    private String getRandomIntegers() {
        StringBuilder fullText = new StringBuilder();
        Random rand = new Random();
        for (int i = 0; i < 1000; i++) {
            int newInt = rand.nextInt();
            if (newInt < 0) {
                fullText.append("<p class='negativeNumber'>").append(newInt).append("</p>");

            } else {
                fullText.append("<p>").append(newInt).append("</p>");
            }

        }
        return fullText.toString();
    }

    public void destroy() {
    }
}
