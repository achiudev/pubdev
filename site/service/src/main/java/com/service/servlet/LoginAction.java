package com.service.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA.
 * User: alex
 * Date: 2/17/13
 * Time: 1:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class LoginAction extends HttpServlet {
    private String message;

    public void init() throws ServletException {
        message = "Hello World";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<H1>" + message + "</H1>");
    }

    public void doPost(HttpServletRequest request, HttpServletRequest response) throws ServletException, IOException {
        //setup Http Session


    }



}
