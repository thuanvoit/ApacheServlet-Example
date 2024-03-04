package com.example.simpleapp;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import java.util.Random;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "page4", value = "/page4")
public class Page4 extends HttpServlet {
    private String title;

    public void init() {
        title = "Page 4 - Display a Text";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");



        //download the text file and extract to string


        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println(Nav.writeHeader(title));
        out.println("<body>");

        out.println(Nav.navBar());

        out.println("<h1>" + title + "</h1>");

        out.println("<div>" + getText(request) + "</div>");

        out.println("</body></html>");
    }

    private String getText(HttpServletRequest request) {
        StringBuilder fullText = new StringBuilder();
        try {
            String textPath = "http://" + request.getServerName() + ":" + request.getServerPort() +
                    request.getContextPath() + "/getObject?name=big.txt";

            URL url = new URL(textPath);
            URLConnection connection = url.openConnection();

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                fullText.append("<p>").append(line).append("</p>");
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fullText.toString();
    }


    public void destroy() {
    }
}
