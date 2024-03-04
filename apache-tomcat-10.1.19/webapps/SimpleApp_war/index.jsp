<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>CS4675-HW4-P2</title>
        <style>
            body {
                padding: 10px;
            }
            /* make <a> button */
            a {
                width: 100%;
                max-width: 300px;
                display: inline-block;
                padding: 10px 20px 10px 20px;
                border: 1px solid #000;
                text-decoration: none;
                color: #000;
                background-color: #fff;
                transition: 0.3s;
                border-radius: 5px;
            }

            a:hover {
                background-color: #000;
                color: #fff;
            }

            img {
                width: 200px;
                height: 200px;
                border-radius: 5px;
            }

            .buttonContainer {
                display: flex; flex-flow: column; row-gap: 10px; margin-bottom: 2rem
            }
        </style>
    </head>

    <body>
        <h1>CS 4675</h1>
        <h2>HW4 Problem 2 - Apache Tomcat</h2>
        <p>Made by Thuan Vo</p>
        <br />
        <div class="buttonContainer">
            <a href="page1">5 Images Page</a>
            <a href="page2">3 Images Page</a>
            <a href="page3">Random an Image</a>
            <a href="page4">Load a Poem</a>
            <a href="page5">Random 1000 Integer</a>
        </div>
        <img src="getImage?name=hello.gif" alt="hello" />
    </body>

    </html>