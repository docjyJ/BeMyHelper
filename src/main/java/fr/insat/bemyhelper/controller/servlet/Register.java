package fr.insat.bemyhelper.controller.servlet;


import fr.insat.bemyhelper.controller.Session;
import fr.insat.bemyhelper.controller.entityManager.UserManager;
import fr.insat.bemyhelper.controller.implementation.Factory;
import fr.insat.bemyhelper.model.NeederEntity;
import fr.insat.bemyhelper.model.UserEntity;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "registerServlet", value = "/register")
public class Register extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (Session.getSession(request.getSession()) != null)
            response.sendRedirect("welcome");
        else
            this.getServletContext().getRequestDispatcher("/WEB-INF/view/register.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserManager um = Factory.createFactory().getUserManager();
        int code = 0;
        UserEntity userObj = null;

        String user = request.getParameter("user");
        String first = request.getParameter("first");
        String last = request.getParameter("last");
        String type = request.getParameter("type");
        if (um.exist(user))
            code = 1;
        else try {
                userObj = new UserEntity(first, last, user);
                userObj.setPassword(request.getParameter("pass"));
                if (type.equals("Needer")) userObj.setNeederByUserName(new NeederEntity(userObj));

                if (um.addNew(userObj) != 1) {
                    userObj = null;
                    code = 2;
                }
            } catch (IllegalArgumentException e) {
                code = 3;
            }

        if (userObj == null) {
            request.setAttribute("userFill", user);
            request.setAttribute("firstFill", first);
            request.setAttribute("lastFill", last);
            request.setAttribute("typeFill", type);
            request.setAttribute("errorCode", code);
        }
        else
            Session.setSession(request.getSession(), userObj);
        doGet(request, response);

    }
}