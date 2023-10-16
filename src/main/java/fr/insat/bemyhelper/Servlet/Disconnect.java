package fr.insat.bemyhelper.Servlet;


import fr.insat.bemyhelper.Session;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "disconnectServlet", value = "/disconnect")
public class Disconnect extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Session.removeSession(request.getSession());
        response.sendRedirect("login");
    }
}