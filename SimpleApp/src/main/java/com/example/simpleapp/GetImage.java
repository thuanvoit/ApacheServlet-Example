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

@WebServlet(name = "getImage", value = "/getImage")

public class GetImage extends HttpServlet
{
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException
    {
        String imageName = request.getParameter("name");
        // set the content type to image/jpeg.
        response.setContentType("image/jpeg");

        ServletOutputStream out;

        // Writing this image
        // content as a response
        out = response.getOutputStream();

        // path of the image
        String imagePath = getServletContext().getRealPath("/WEB-INF/images");
        FileInputStream fin = new FileInputStream(imagePath + "/" + imageName);

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

        System.out.println("Loaded Image " + imageName);
    }
}