package fr.insat.bemyhelper.controller.servlet;


import fr.insat.bemyhelper.controller.Session;
import fr.insat.bemyhelper.model.UserEntity;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "welcomeServlet", value = "/welcome")
public class Welcome extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserEntity s = Session.getSession(request.getSession());
        if (s == null)
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/login"));
        else
            this.getServletContext().getRequestDispatcher("/WEB-INF/view/welcome.jsp").forward(request, response);
    }
}