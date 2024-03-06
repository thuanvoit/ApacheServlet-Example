package com.example.simpleapp;

import jakarta.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.Map;

public class Nav {
        public static HashMap<String, String> pages = new HashMap<String, String>() {
                {
                        put("/SimpleApp", "Homepage");
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

        public static String writeHeader(String title) {
                return "<head>" +
                                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">" +
                                "<link rel=\"stylesheet\" href=\"getObject?name=style.css\">" +
                                "<title>" + title + "</title>" +
                                "</head>";
        }

        public static String getObjectUrl(HttpServletRequest request, String fileName) {
                String contextPath = request.getContextPath();
                return contextPath + "/getObject?name=" + fileName;
        }

        public static String navBar() {
                String output = "<div class='buttonContainer'>";

                for (Map.Entry<String, String> pageInfo : Nav.pages.entrySet()) {
                        output += "<a href='" + pageInfo.getKey() + "'>" + pageInfo.getValue() + "</a>";
                }

                output += "</div>";

                return output;
        }

}
