package com.example.simpleapp;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet(name = "getText", value = "/getText")

public class GetText extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String textName = request.getParameter("name");

        response.setContentType("text/plain");

        ServletOutputStream out;

        // Writing this image
        // content as a response
        out = response.getOutputStream();

        // path of the image
        String textPath = getServletContext().getRealPath("/WEB-INF/text");
        FileInputStream fin = new FileInputStream(textPath + "/" + textName);

        // get .txt file from FileInputStream
        BufferedInputStream bin = new BufferedInputStream(fin);
        BufferedOutputStream bout = new BufferedOutputStream(out);

        int ch = 0;
        while ((ch = bin.read()) != -1) {
            // display image
            bout.write(ch);
        }

        // close all classes
        bin.close();
        fin.close();
        bout.close();
        out.close();

        System.out.println("Loaded Text " + textName);
    }
}