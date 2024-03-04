package com.example.simpleapp;

import jakarta.servlet.http.HttpServletRequest;

import java.util.HashMap;

public class Nav {
        public static HashMap<String, String> pages = new HashMap<String, String>() {
                {
                        put("/SimpleApp_war", "Homepage");
                        put("page5", "Random 1,000 Integers");
                        put("page4", "Display a Text");
                        put("page3", "Randomize An Image");
                        put("page2", "4 Images Page");
                        put("page1", "All Images Page");
                }
        };
        public static HashMap<String, String> images = new HashMap<String, String>() {
                {
                        put("Vietnam", "pic1.jpg");
                        put("Aurora", "pic2.jpg");
                        put("Autumn", "pic3.jpg");
                        put("Snowflake", "pic4.jpg");
                        put("National Park", "pic5.jpg");
                        put("Waterfall", "pic6.jpg");
                        put("Bird", "pic7.jpg");
                }
        };

        public static String styles = "body { padding: 10px }" +
                        "img { width: 150px; height: 150px; object-fit: cover; border-radius: 5px; }" +
                        ".card { display: flex; justify-content: center; align-items: center; flex-direction: column;}" +
                        ".imagesContainer { display: flex; flex-wrap: wrap; gap: 10px; }" +
                        "a { width: 100%; max-width: 300px; display: inline-block; padding: 10px 20px 10px 20px;" +
                        "border: 1px solid #000; text-decoration: none; color: #000; background-color: #fff;" +
                        "transition: 0.3s; border-radius: 5px; }" +
                        "a:hover { background-color: #000; color: #fff; }" +
                        ".buttonContainer { display: flex; flex-flow: column; row-gap: 10px; margin-bottom: 2rem }" +
                        ".textFrame {width: 100%; min-height: calc(100vh - 400px)}" +
                        ".negativeNumber {color: red;}";

        public static String writeHeader(String title) {
                return "<head>" +
                                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">" +
                                "<style type=\"text/css\"> " + Nav.styles + " </style>" +
                                "<title>" + title + "</title>" +
                                "</head>";
        }

        public static String getImageUrl(HttpServletRequest request, String imageName) {
                String contextPath = request.getContextPath();
                return contextPath + "/getImage?name=" + imageName;
        }

        public static String getTextUrl(HttpServletRequest request, String imageName) {
                String contextPath = request.getContextPath();
                return contextPath + "/getText?name=" + imageName;
        }
}
