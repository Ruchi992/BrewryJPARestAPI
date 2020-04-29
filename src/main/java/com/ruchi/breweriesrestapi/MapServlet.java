package com.ruchi.breweriesrestapi;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;

@WebServlet(name = "MapServlet", urlPatterns
        = {
            "/MapServlet"
        })
public class MapServlet extends HttpServlet {

    //
    //  methods
    //
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void gotoPage(String url, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("in servlet");

        HandleMapTest(request, response);
    }

    public void HandleMapTest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String pageUrl = "/beermap.jsp";
        //testing brewery #1
        String name = "(512) Brewing Company";
        float latitude = -30.2234f;
        float longitude = -97.7697f;
        String apiKey = "AIzaSyA0kZEl_6sDWjt38LvlJZL5ld_EUgihqdo";       

        //get or pass in those values in real life
        HttpSession session = request.getSession();
        session.setAttribute("name", name);
        session.setAttribute("latitude", latitude);
        session.setAttribute("longitude", longitude);
        session.setAttribute("apiKey", apiKey);
        gotoPage(pageUrl, request, response);
    }
}
