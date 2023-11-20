package fr.insat.bemyhelper.controller.servlet;


import fr.insat.bemyhelper.controller.entityManager.BadPasswordException;
import fr.insat.bemyhelper.controller.entityManager.UserManager;
import fr.insat.bemyhelper.controller.entityManager.UserNotFoundException;
import fr.insat.bemyhelper.controller.implementation.Factory;
import fr.insat.bemyhelper.controller.Session;
import fr.insat.bemyhelper.model.UserEntity;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "loginServlet", value = "/login")
public class Login extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (Session.getSession(request.getSession()) != null)
            response.sendRedirect("welcome");
        else
            this.getServletContext().getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserManager um = Factory.getInstance().getUserManager();
        int code = 0;
        UserEntity userObj = null;
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        try {
            userObj = um.correctPassword(user, pass);
        } catch (UserNotFoundException e) {
            code = 1;
        } catch (BadPasswordException e) {
            code = 2;
        }

        if (userObj == null){
            request.setAttribute("userFill", user);
            request.setAttribute("errorCode", code);
        }
        else
            Session.setSession(request.getSession(), userObj);
        doGet(request, response);
    }
}