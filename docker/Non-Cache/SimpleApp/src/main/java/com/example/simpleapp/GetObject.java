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

@WebServlet(name = "getObject", value = "/getObject")

public class GetObject extends HttpServlet
{
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException
    {
        String fileName = request.getParameter("name");
        String contentType = "text/plain";
        String storagePath = "/WEB-INF/text";

        // support JPG, PNG, JPEG, GIF only
        if (fileName.endsWith(".jpg")
                || fileName.endsWith(".png")
                || fileName.endsWith(".gif")
                || fileName.endsWith("jpeg")) {
            contentType = "image/jpeg";
            storagePath = "/WEB-INF/images";
        }
        else if (fileName.endsWith(".css")) {
            contentType = "text/css";
            storagePath = "/WEB-INF/static";
        }

        // set the content type to image/jpeg.
        response.setContentType(contentType);

        ServletOutputStream out;

        // Writing this image
        // content as a response
        out = response.getOutputStream();

        // path of the image
        String filePath = getServletContext().getRealPath(storagePath);
        FileInputStream fin = new FileInputStream(filePath + "/" + fileName);

        // getting image in BufferedInputStream
        BufferedInputStream bin = new BufferedInputStream(fin);
        BufferedOutputStream bout = new BufferedOutputStream(out);

        int ch =0;
        while((ch=bin.read())!=-1)
        {
            // display image
            bout.write(ch);
        }

        // close all classes
        bin.close();
        fin.close();
        bout.close();
        out.close();

        System.out.println("return object");
    }
}