package fr.insat.bemyhelper.Servlet;


import fr.insat.bemyhelper.Model.User;
import fr.insat.bemyhelper.Session;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "welcomeServlet", value = "/welcome")
public class Welcome extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User s = Session.getSession(request.getSession());
        if (s == null)
            response.sendRedirect("login");
        else
            this.getServletContext().getRequestDispatcher("/WEB-INF/view/welcome.jsp").forward(request, response);
    }
}